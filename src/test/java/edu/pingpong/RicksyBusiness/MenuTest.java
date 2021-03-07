package edu.pingpong.RicksyBusiness;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuTest {
    Menu menu;
    CreditCard tarjeta;

    @Before
    public void menuSetUp() {
        menu = new Menu("Menu Original", 15);
        tarjeta = new CreditCard("Juan Pastor Ruiz",  "49482026");
    }

    @Test
    public void menuDispatchTest() {
        menu.dispatch(tarjeta);
        assert (menu.getOrders().contains(tarjeta.getOwner()));
        assertEquals(2985d, tarjeta.credit(),0.1);
    }
}
