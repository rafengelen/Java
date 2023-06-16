package fact.it.restaurantappstart.model;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name="table_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "orderdate")
    private LocalDate date;
    private boolean payed;
    @ManyToOne
    private Waiter waiter;
    @ManyToOne
    private Table table;
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItemList= new ArrayList<>();


    @Transient
    private PaymentStrategy paymentStrategy;

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }




    public Order() {
        this.paymentStrategy=new NormalPayment();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public List<OrderItem> getOrderItems() {
        return orderItemList;
    }


    public void addItem(Dish dish ,int quantity){
        OrderItem orderItem = new OrderItem();

        orderItem.setDish(dish);
        orderItem.setQuantity(quantity);
        //we verbinden Order met orderitem
        orderItem.setOrder(this);
        orderItem.setAppliedPrice(this.paymentStrategy.getAppliedPrice(dish.getCurrentPrice()));

        this.orderItemList.add(orderItem);
    }

    public double getTotal(){
        return orderItemList.stream()
                .mapToDouble(i -> i.getQuantity() * i.getAppliedPrice())
                .sum();
    }
}
