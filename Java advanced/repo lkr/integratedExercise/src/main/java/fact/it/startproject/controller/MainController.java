package fact.it.startproject.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import fact.it.startproject.model.*;
import fact.it.startproject.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpClient;

@Controller
public class MainController {
    @Autowired
    PropertyRepository propertyRepository;
    @Autowired
    TenantRepository tenantRepository;
    @Autowired
    ContractRepository contractRepository;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("properties", propertyRepository.findAll());
        return "index";
    }
    @RequestMapping("/addContract")
    public String addContract(Model model, HttpServletRequest request){
        Long id = Long.valueOf(request.getParameter("id"));

        model.addAttribute("property", propertyRepository.findById(id).get());
        model.addAttribute("tenantList", tenantRepository.findAll());
        return "1_addContract";
    }
    @RequestMapping("/processAddContract")
    public String processAddContract(Model model, HttpServletRequest request){
        Contract contract = new Contract();

        Long tenantId = 0L;
        try{
            tenantId = Long.valueOf(request.getParameter("tenantId"));
        } catch(Exception exception){
            model.addAttribute("message", "Please choose a tenant from the list");
            return "error";
        }

        Integer rentalPrice = 0;
        try{
            rentalPrice = Integer.parseInt(request.getParameter("rentalPrice"));
        } catch (NumberFormatException exc){
            model.addAttribute("message", "Enter a valid price. This must be an integer.");
            return "error";
        }


        Long propertyId = Long.valueOf(request.getParameter("propertyId"));

        Tenant tenant = tenantRepository.getById(tenantId);
        Property property = propertyRepository.getById(propertyId);

        contract.setProperty(property);
        contract.setTenant(tenant);


        contract.setRentalPrice(rentalPrice);

        contractRepository.save(contract);
        model.addAttribute("contractList", contractRepository.findAll());
        return "2_contractDetails";
    }
}
