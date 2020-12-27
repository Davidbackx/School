import java.time.LocalTime;

public class Rit {
    private LocalTime startTijdstip;
    private LocalTime eindTijdstip;
    private Double aantalKm;

    /**
     * Maak consturctor
     */
    public Rit () {
        startTijdstip = LocalTime.now();
    }

    public void stop (double km, LocalTime tijd){
        if (tijd.isBefore(startTijdstip)) throw new IllegalArgumentException();
        if (km < 1) throw new IllegalArgumentException();

        eindTijdstip = tijd;
        aantalKm = km;
    }

    public boolean isGestopt () {
        return this.aantalKm != null;
    }

    /**
     *  Check of start in een piekuur.
     * @return Boolean
     */
    public boolean startTijdensPiekUren () {
        LocalTime beginP = LocalTime.of(17,0);
        LocalTime eindP = LocalTime.of(19,30);
        if (startTijdstip.isBefore(eindP) && startTijdstip.isAfter(beginP)) return true;
        return false;
    }

    public int totaalAantalMinuten () {
        if (!isGestopt()) throw new IllegalArgumentException();
        return ((eindTijdstip.getHour() * 60) + eindTijdstip.getMinute()) -
                ((startTijdstip.getHour() * 60) + startTijdstip.getMinute());
    }

    public Double prijs(Double[] tarieven) {
        if (!isGestopt()) throw new IllegalStateException("Kan de prijs niet berekenen omdat de rit nog niet gestopt is.");
        if (tarieven == null || tarieven.length != 3) throw new IllegalArgumentException("De gegeven tarievenrij is niet correct.");

        double res = tarieven[0] + Math.min(this.aantalKm - 1 , 5) * tarieven[1] +
                Math.max(0,this.aantalKm - 6) * tarieven[2];
        if (this.startTijdensPiekUren()) res*= 3;
        return res;
    }

    @Override
    public String toString() {
        String uit = "start : " + this.startTijdstip.toString().substring(0,5) + "\neinde: ";
        if (!isGestopt()){
            uit+= "deze rit is nog niet beëindigd\naantal km: nog niet gekend\n";
            uit += "\ntotaal minuten van deze rit: rit is nog niet beëindigd\n";
        }
        else {
            uit += this.eindTijdstip.toString().substring(0,5) + "\naantal km: " + this.aantalKm + "KM";
            uit += "\ntotaal minuten van deze rit: " + this.totaalAantalMinuten() + " minuten";
        }
        return uit;
    }
}
