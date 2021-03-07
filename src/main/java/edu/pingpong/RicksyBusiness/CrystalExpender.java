package edu.pingpong.RicksyBusiness;

public class CrystalExpender implements GuestDispatcher{
    private int stock;
    private double itemCost;

    public CrystalExpender(int stock, double itemCost) {
        this.stock = stock;
        this.itemCost = itemCost;
    }

    int stock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getItemCost() {
        return itemCost;
    }

    @Override
    public void dispatch(CreditCard tarjeta) {
        if (stock > 0 && tarjeta.pay(itemCost)) {
            setStock(stock()-1);
        }
    }

    @Override
    public String toString() {
        return "stock: " + stock() + '\n' +
                "item cost: " + getItemCost();
    }
}
