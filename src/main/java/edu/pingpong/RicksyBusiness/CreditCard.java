package edu.pingpong.RicksyBusiness;

public class CreditCard {
    private final String owner;
    private final String number;
    private double credit = 3000d;
    private final static String SYMBOL = "EZI";

    public CreditCard(String owner, String number) {
        this.owner = owner;
        this.number = number;
    }

    boolean pay(double pago) {
        if (credit() - pago >= 0) {
           setCredit(credit() - pago);
           return true;
        } else {
            return false;
        }
    }

    String getOwner() {
        return owner;
    }

    String number() {
        return number;
    }

    double credit() {
        return credit;
    }

    void setCredit(double credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "owner: " + getOwner() + '\n' +
                "number: " + number() + '\n' +
                "credit: " + credit() + ' ' + SYMBOL;
    }
}
