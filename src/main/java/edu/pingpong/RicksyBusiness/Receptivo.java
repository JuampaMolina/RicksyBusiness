package edu.pingpong.RicksyBusiness;

import java.util.ArrayList;
import java.util.List;

public class Receptivo {
    private final List<GuestDispatcher> listaDispatchers = new ArrayList<>();

    public List<GuestDispatcher> getListaDispatchers() {
        return listaDispatchers;
    }

    public void registra(GuestDispatcher guestDispatcher) {
        listaDispatchers.add(guestDispatcher);
    }

    public void dispatch(CreditCard tarjeta) {
        for (GuestDispatcher dispatcher : listaDispatchers) {
            dispatcher.dispatch(tarjeta);
        }
    }
}
