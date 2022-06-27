package fact.it.exparkingticketmachine.model;

public class ParkingTicketMachine {
    private int price, balance, total;

    public ParkingTicketMachine(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void receiveMoney(int amount){
        this.balance += amount;
    }

    public String showTicket(){
        if(balance<price){
            return "You still need to insert at least " + (getPrice()-getBalance()) + " euros";
        }
        else {
            this.balance -= this.price;
            this.total += this.price;
            if(this.balance > 0) {
                return "#-# Parking meter #-# Ticket = " + getPrice() + " euros #-# (change = " + getBalance() + " euros)";
            }
            else {
                return "#-# Parking meter #-# Ticket = " + getPrice() + " euros #-#";
            }
        }
    }
}
