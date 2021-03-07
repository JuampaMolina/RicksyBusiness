package edu.pingpong.RicksyBusiness;

import java.util.*;

public class UfosPark implements GuestDispatcher{
    private double fee = 500d;
    private final Map<String, String> flota = new HashMap<String, String>();

    public Map<String, String> getFlota() {
        return flota;
    }

    void add(String ufo) {
        flota.putIfAbsent(ufo, null);
    }

    @Override
    public void dispatch(CreditCard tarjeta) {
        // Creamos una entrada que aún no añadimos a la flota
        Map.Entry<String, String> ufo = null;
        //Comprobamos que la flota no contenga el número de la tarjeta que nos pasan
        if (!flota.containsValue(tarjeta.number())) {
            // Recorremos las entradas de la flota
            for (Map.Entry<String, String> entry : this.flota.entrySet()) {
                // Buscamos una entrada que no tenga ningún valor asignado
                if (entry.getValue() == null) {
                    // Le asignamos la entrada que hemos encontrado a la variable que hemos creado antes
                    ufo = entry;
                    break;
                }
            }
        }

        // Cuando se paga?
        if (ufo != null && tarjeta.pay(fee)) {
            this.flota.put(ufo.getKey(), tarjeta.number());
        }
    }

    String getUfoOf(String numeroTarjeta) {
        String ufo = null;
        if (this.flota.containsValue(numeroTarjeta)) {
            for (Map.Entry<String,String> entry : this.flota.entrySet()) {
                if (entry.getValue() == numeroTarjeta) {
                    ufo = entry.getKey();
                    break;
                }
            }
        }
        return ufo;
    }

    @Override
    public String toString() {
        return this.flota.keySet().toString();
    }

    boolean containsCard(String cardNumber) {
        return this.flota.containsValue(cardNumber);
    }

    Collection<String> cardNumbers() {
        /*
        List<String> numerosTarjetas = new ArrayList<>();
        for (Map.Entry<String, String> entry : this.flota.entrySet()) {
            if (entry.getValue() != null) {
                numerosTarjetas.add(entry.getValue());
            }
        }
        return numerosTarjetas;
         */


        return this.flota.values();
    }
}
