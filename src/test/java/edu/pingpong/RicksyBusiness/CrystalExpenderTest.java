package edu.pingpong.RicksyBusiness;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CrystalExpenderTest {

    CrystalExpender crystalExpender;
    CreditCard tarjeta;

    @Before
    public void CrystalExpenderSetUp() {
        crystalExpender = new CrystalExpender(1, 200d);
        tarjeta = new CreditCard("Juan Pastor Ruiz",  "49482026");
    }

    @Test
    public void crystalDispatchTest() {
        crystalExpender.dispatch(tarjeta);
        assertEquals(0, crystalExpender.stock());
        assertEquals(2800d, tarjeta.credit(), 0.1);
    }

    @Test
    public void noCreditCrystalDispatchTest() {
        tarjeta.setCredit(100d);
        crystalExpender.dispatch(tarjeta);
        assertEquals(1, crystalExpender.stock());
        assertEquals(100d, tarjeta.credit(), 0.1);
    }
}
