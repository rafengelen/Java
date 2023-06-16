package fact.it.startproject.repository;

import fact.it.startproject.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    //return results ordered by amount
    List<Payment> findAllByOrderByAmountAsc();

//    @Query("select p from Payment p order by p.amount asc ")
//    List<Payment> getPaymentsOrderedByAmountAsc();

    //return Cash results
    @Query("select c from CashPayment c")
    List<Payment> getAllCashPayments();

    //return Electronic payments ordered by currency
    @Query("select e from ElectronicPayment e order by e.currency")
    List<Payment> getElectronicPaymentsOrderedByCurrency();

    List<Payment> findAllByAmountGreaterThan(double amount);
}
