import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkeerPlaatsTest {

    ParkeerPlaats plaats;

    @Test
    void parkeerplaats_verdieping_geldige_waarde () {
        plaats = new ParkeerPlaats("-3*20");
        assertEquals(plaats.geefVerdiepingNummer(), -3);
    }

    @Test
    void parkeerplaats_code_ongeldige_waarde () {
        Assertions.assertThrows(Exception.class, () -> {
            new ParkeerPlaats(null);
        });
    }

    @Test
    void parkeerplaats_geef_string_geldige_waarde () {
        plaats = new ParkeerPlaats("-3*20");
        plaats.zetBezet();
        assertEquals(plaats.geefStringVorm(), "Parkeerplaats met code -3*20 is bezet.");
    }

    @Test
    void parkeerplaats_geef_string_niet_geldige_waarde () {
        plaats = new ParkeerPlaats("-3*20");
        assertNotEquals(plaats.geefStringVorm(), "Parkeerplaats met code -320 is bezet.");
    }
}