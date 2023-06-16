package fact.it.startproject.controller;

import fact.it.startproject.model.Payment;
import fact.it.startproject.repository.PaymentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PaymentController {
    private PaymentRepository paymentRepository;

    public PaymentController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/results")
    public String results(Model model){
        //get list of payments
        List<Payment> paymentList = this.paymentRepository.findAll();

        //lijst meegeven naar view
        model.addAttribute("paymentList", paymentList);

        return "results";
    }

    @RequestMapping("/resultsAscAmount")
    public String resultsAscAmount(Model model){
        //get list of payments
        List<Payment> paymentList = this.paymentRepository.findAllByOrderByAmountAsc();

        //lijst meegeven naar view
        model.addAttribute("paymentList", paymentList);

        return "results";
    }

    @RequestMapping("/resultsCash")
    public String resultsCash(Model model){
        //get list of payments
        List<Payment> paymentList = this.paymentRepository.getAllCashPayments();

        //lijst meegeven naar view
        model.addAttribute("paymentList", paymentList);

        return "results";
    }

    @RequestMapping("/resultsElectronic")
    public String resultsElectronic(Model model){
        //get list of payments
        List<Payment> paymentList = this.paymentRepository.getElectronicPaymentsOrderedByCurrency();

        //lijst meegeven naar view
        model.addAttribute("paymentList", paymentList);

        return "results";
    }

    @RequestMapping("/resultsFilterAmount")
    public String resultsFilterAmount(Model model, HttpServletRequest request){
        //get value to filter by
        double amount = Double.parseDouble(request.getParameter("amount"));

        //get list of payments
        List<Payment> paymentList = this.paymentRepository.findAllByAmountGreaterThan(amount);

        //lijst meegeven naar view
        model.addAttribute("paymentList", paymentList);

        return "results";
    }
}
