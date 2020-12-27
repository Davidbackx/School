import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GaragesTest {

    Garages garage;

    @BeforeEach
    void setUp () {
        garage = new Garages();
    }

    @Test
    void voeg_garage_toe () {
        Parking test = new Parking("TEST");
        garage.voegGarageToe(test);
        assertEquals(garage.getParking(0), test);
    }

    @Test
    void meeste_aantal_vrije_plaatsen () {
        Parking test = new Parking("TEST", -3, new int[] {60,60,60});
        garage.voegGarageToe(test);
        assertEquals(garage.geefParkingMetMeesteAantalVrijePlaatsen(), test);
    }
}