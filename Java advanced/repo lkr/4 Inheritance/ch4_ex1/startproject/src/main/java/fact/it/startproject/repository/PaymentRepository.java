package fact.it.startproject.repository;

import fact.it.startproject.model.Payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findAllByAmountGreaterThan(double amount);
    List<Payment> findAllByOrderByAmountAsc();
    @Query("SELECT c FROM CashPayment c")
    List<Payment> findCashPayments();
    @Query("SELECT e FROM ElectronicPayment e ORDER BY e.currency")
    List<Payment> findElectronicPayments();

}
