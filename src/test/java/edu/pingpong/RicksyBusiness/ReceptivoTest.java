package edu.pingpong.RicksyBusiness;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ReceptivoTest {
    Receptivo receptivo = new Receptivo();

    CreditCard tarjeta = new CreditCard("Juan Pastor Ruiz",  "49482026");

    UfosPark ufosPark = new UfosPark();
    CrystalExpender crystalExpender = new CrystalExpender(2, 50d);

    @Before
    public void registraTest() {
        receptivo.registra(ufosPark);
        ufosPark.add("ufer");
        receptivo.registra(crystalExpender);
        assertEquals(2, receptivo.getListaDispatchers().size());
    }

    @Test
    public void dispatchTest() {
        receptivo.dispatch(tarjeta);
        assertTrue(ufosPark.containsCard(tarjeta.number()));
        assertEquals("ufer", ufosPark.getUfoOf(tarjeta.number()));
        assertEquals(1, crystalExpender.stock());
        assertEquals(2450d, tarjeta.credit(), 0.1);
    }
}
