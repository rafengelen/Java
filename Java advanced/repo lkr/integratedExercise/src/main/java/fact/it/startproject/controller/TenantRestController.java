package fact.it.startproject.controller;

import fact.it.startproject.model.Tenant;
import fact.it.startproject.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TenantRestController {
    @Autowired
    TenantRepository tenantRepository;

    @GetMapping("tenants/select")
    public List<String> tenantsIncome(@RequestBody double income){

        List<Tenant> tenantList = tenantRepository.findAll();
        return tenantList.stream()
                .filter(t -> t.getIncome()<income)
                .map(Tenant::toString)
                .toList();
    }
    @PutMapping("tenants/{id}")
    public ResponseEntity<Tenant> changeIncome(@PathVariable long id, @RequestBody double income){
        Optional<Tenant> optionalTenant = tenantRepository.findById(id);
        if(optionalTenant.isPresent()){
            Tenant tenant = optionalTenant.get();
            tenant.setIncome(income);
            tenantRepository.save(tenant);
            return new ResponseEntity<>(tenant,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @DeleteMapping("tenants/{id}")
    public ResponseEntity<Integer> deleteTenant(@PathVariable long id){
        Optional<Tenant> optionalTenant = tenantRepository.findById(id);
        if (optionalTenant.isPresent()){
            Tenant tenant = optionalTenant.get();
            tenantRepository.delete(tenant);

            return new ResponseEntity<>(Integer.valueOf(tenantRepository.findAll().size()), HttpStatus.OK);
        }
        return new ResponseEntity<>(Integer.valueOf(tenantRepository.findAll().size()), HttpStatus.NOT_FOUND);
    }

}
