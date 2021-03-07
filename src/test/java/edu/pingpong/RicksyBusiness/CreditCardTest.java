package edu.pingpong.RicksyBusiness;

import edu.pingpong.RicksyBusiness.CreditCard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreditCardTest {

    CreditCard tarjeta;

    @Before
    public void CreditCardSetUp() {
        tarjeta = new CreditCard("Juan Pastor Ruiz",  "49482026");
    }

    @Test
    public void payInsuficienteTest() {
        assertFalse(tarjeta.pay(4000));
    }

    @Test
    public void paySuficienteTest() {
        assertTrue(tarjeta.pay(2000));
        assertEquals(1000, tarjeta.credit(), 0.01);
    }

    @Test
    public void vaciarTarjetaTest() {
        assertTrue(tarjeta.pay(3000));
        assertEquals(0, tarjeta.credit(), 0.01);
    }
}
