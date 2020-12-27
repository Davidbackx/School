import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingTest {
    Parking parking;
    @BeforeEach
    void setUp() {
        parking = new Parking("Leuven");
    }

    @Test
    void niewe_parking_ongeldige_waarden () {
        Assertions.assertThrows(Exception.class, () -> {
            new Parking(null);
        });

        Assertions.assertThrows(Exception.class, () -> {
            new Parking("Leuven", 0 , new int[] {});
        });
    }

    @Test
    void min_etage_geldige_waarde () {
        parking = new Parking("Leuven", -6, new int[] {50,50});
        assertEquals(parking.geefMinimumEtage(), -6);
    }

    @Test
    void aantal_vrije_plaatsen_foute_waarde () {
        parking = new Parking("Leuven");
        parking.zetParkeerPlaatsBezet(0,1);
        parking.zetParkeerPlaatsBezet(0,2);
        int vrij = parking.geefTotaalAantalPlaatsen() - 2;
        assertEquals(parking.geefAantalVrijePlaatsen(), vrij);
    }
}