package fact.it.restaurantappstart.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "table-order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "orderdate")
    private LocalDate date;
    private boolean payed;
    @ManyToOne
    private Waiter waiter;
    @ManyToOne
    private Table table;
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItemList = new ArrayList<>();
    @Transient
    private PaymentStrategy paymentStrategy;

    public Order() {
        this.paymentStrategy = new NormalPayment();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public List<OrderItem> getOrderItems() {
        return orderItemList;
    }

    public void setOrderItems(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }



    public void addItem(Dish dish, int quantity){
        //OrderItem object maken
        OrderItem orderItem = new OrderItem();

        //attributen invullen
        orderItem.setDish(dish);
        orderItem.setQuantity(quantity);
        orderItem.setOrder(this);
        orderItem.setAppliedPrice(this.paymentStrategy.getAppliedPrice(dish.getCurrentPrice()));

        //OrderItem toevoegen aan lijst
        this.orderItemList.add(orderItem);
    }

    public double getTotal(){
        //variabele aanmaken om berekend totaal in op te slaan
        double total = 0;
        
        //totale prijs berekenen
        for (OrderItem item : this.orderItemList){
            total += item.getAppliedPrice() * item.getQuantity();
        }
        
        //berekende totale prijst terug geven
        return total;
    }
}
