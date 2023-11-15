package org.ex304.bank;

public class CreditAccount extends Account{
    private double limit;

    public CreditAccount(String id, String name, double balance, double limit) {
        super(id, name, balance);
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "[" + this.getId() + "," +
                this.getName() + "," +
                String.format("%.2f", this.getBalance()) + ","+
                String.format("%.2f", this.getLimit()) + "]";
    }

    @Override
    public Boolean withdraw(double amount){
        if(amount>this.limit+this.getBalance()){
            return false;
        }
        setBalance(getBalance()-amount);
        return true;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }
}
