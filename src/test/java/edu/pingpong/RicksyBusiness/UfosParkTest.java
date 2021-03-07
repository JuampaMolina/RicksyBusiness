package edu.pingpong.RicksyBusiness;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UfosParkTest {

    UfosPark ufosPark = null;
    String[] ufos = {"ufo1", "ufo2", "ufo3"};

    CreditCard tarjeta = null;

    @Before
    public void UfosParkSetUp() {
        ufosPark = new UfosPark();
        tarjeta = new CreditCard("Juan Pastor Ruiz",  "49482026");
        for (String ufo : ufos){
            ufosPark.add(ufo);
        }
    }

    @Test
    public void addUfoTest() {
        ufosPark.add("ufo1");
        assertEquals (ufos.length, ufosPark.getFlota().size());
    }

    @Test
    public void ufoDispatchTest() {
        ufosPark.dispatch(tarjeta);
        assertTrue (List.of(ufos).contains(ufosPark.getUfoOf(tarjeta.number())));
        assertEquals(2500d, tarjeta.credit(), 0.1);
    }

    @Test
    public void noCreditUfoDispatchTest() {
        tarjeta.setCredit(400d);
        ufosPark.dispatch(tarjeta);
        assertNull(ufosPark.getUfoOf(tarjeta.number()));
        assertEquals(400d, tarjeta.credit(), 0.1);
    }

    @Test
    public void dispatchUfoAlreadyReservedTest() {
        ufosPark.dispatch(tarjeta);
        ufosPark.dispatch(tarjeta);
        assertEquals(2500d, tarjeta.credit(), 0.1);
    }

    @Test
    public void noUfoAvaibleDispatchTest() {
        UfosPark ufoPark = new UfosPark();
        ufoPark.add("ufo-X");
        CreditCard card = new CreditCard("David Gelpi", "9999");
        ufoPark.dispatch(tarjeta);
        ufoPark.dispatch(card);
        assertEquals("ufo-X", ufoPark.getUfoOf(tarjeta.number()));
        assertNull(ufoPark.getUfoOf(card.number()));
    }
}
