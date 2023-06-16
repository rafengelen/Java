package fact.it.startproject.controller;

import fact.it.startproject.model.CashPayment;
import fact.it.startproject.model.Payment;
import fact.it.startproject.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PaymentController {
    @Autowired
    PaymentRepository paymentRepository;
    @RequestMapping("/")
    public String index(){

        return "index";
    }
    @RequestMapping("/results")
    public String index(Model model){

        model.addAttribute("payments", paymentRepository.findAll());
        return "results";

    }
    @RequestMapping("/paymentsAscending")
    public String paymentsAscending(Model model){
        List<Payment> list =paymentRepository.findAllByOrderByAmountAsc();
        model.addAttribute("payments", list);
        return "results";
    }

    @RequestMapping("/cash")
    public String cash(Model model){
        model.addAttribute("payments", paymentRepository.findCashPayments());
        return "results";
    }
    @RequestMapping("/electronic")
    public String electronic(Model model){
        model.addAttribute("payments", paymentRepository.findElectronicPayments());
        return "results";
    }

    @RequestMapping("/greaterPayments")
    public String greaterPayments(Model model, HttpServletRequest request){
        double amount =  Double.parseDouble(request.getParameter("amount"));
        model.addAttribute("payments", paymentRepository.findAllByAmountGreaterThan(amount));
        return "results";
    }

    @RequestMapping("/createCashPayment")
    public String createCashPayment(){return "createCashPayment";}
    @RequestMapping("/processCreateCashPayment")
    public String processCreateCashPayment(Model model, HttpServletRequest request){
        CashPayment cash = new CashPayment();
        cash.setAmount(Double.parseDouble(request.getParameter("amount")));
        cash.setBeneficiary(request.getParameter("beneficiary"));
        cash.setCurrency(request.getParameter("currency"));
        cash.setName(request.getParameter("name"));

        paymentRepository.save(cash);
        model.addAttribute("payments", paymentRepository.findAll());


        return "results";
    }

}

