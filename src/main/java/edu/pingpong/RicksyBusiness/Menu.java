package edu.pingpong.RicksyBusiness;

import java.util.ArrayList;
import java.util.List;

public class Menu implements GuestDispatcher{
    private String name;
    private double price;

    private final List<String> orders = new ArrayList<>();

    public List<String> getOrders() {
        return orders;
    }

    public Menu(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void dispatch(CreditCard tarjeta) {
        if (tarjeta.pay(price)) {
            orders.add(tarjeta.getOwner());
        }
    }
}
