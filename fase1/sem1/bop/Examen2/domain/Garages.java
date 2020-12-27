import java.util.ArrayList;

public class Garages {
    private ArrayList<Parking> garages;

    public Garages () {
        garages = new ArrayList<>();
    }

    public void voegGarageToe (Parking p) {
        garages.add(p);
    }

    /**
     * Give parking by index.
     * @param index
     * @return
     */
    public Parking getParking (int index) {
        return garages.get(index);
    }

    /**
     * Geeft meeste aantal vrije plaatsen in een garage.
     * @return
     */
    public Parking geefParkingMetMeesteAantalVrijePlaatsen () {
        Parking meest = null;
        for (Parking p : garages){
            if (meest == null){
                meest = p;
                continue;
            }
            if (p.geefAantalVrijePlaatsen() > meest.geefAantalVrijePlaatsen()) {
                meest = p;
            }
        }
        return meest;
    }
}
