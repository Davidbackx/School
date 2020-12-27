import java.net.HttpURLConnection;
import java.time.LocalTime;

public class Chauffeur {
    private String naam;
    private Boolean isBeschikbaar;
    private int totaalAantalMinuten;
    private Double[] tarieven;
    private Rit huidigeRit;

    public Chauffeur (String naam) {
        if (naam.trim().isEmpty() || naam == null) throw new IllegalArgumentException();
        this.naam = naam;
        huidigeRit = new Rit();
        zetBeschikbaar();
    }

    public String getNaam() {
        return naam;
    }

    public void setTarieven(Double[] tarieven) {
        if (tarieven.length != 3 || tarieven == null) throw new IllegalArgumentException();
        this.tarieven = tarieven;
    }

    public void zetBeschikbaar (){
        isBeschikbaar = true;
    }

    public void zetOnbeschikbaar (){
        isBeschikbaar = false;
    }

    public void voegNieuweRitToe () {
        if (!klaarVoorVolgendeRit()) throw new IllegalArgumentException();
        huidigeRit = new Rit();
        zetOnbeschikbaar();
    }

    public double stopLaatsteRit (Double km, LocalTime eind){
        if (huidigeRit == null) throw new IllegalArgumentException();
        huidigeRit.stop(km, eind);
        totaalAantalMinuten += huidigeRit.totaalAantalMinuten();
        zetBeschikbaar();
        return huidigeRit.prijs(tarieven);
    }

    public Boolean klaarVoorVolgendeRit () {
        if (huidigeRit == null || !huidigeRit.isGestopt() || tarieven == null) return  false;
        return true;
    }

    public int totaalAantalMinuten () {
        return totaalAantalMinuten;
    }

    @Override
    public String toString() {
        String uit = this.naam + (this.klaarVoorVolgendeRit()? " is klaar voor volgende rit" : " is niet klaar voor volgende rit");
        if (huidigeRit == null) uit+= "\nheeft nog geen ritten gereden\n";
        else uit+= "\nLaatste rit van " + this.naam + " = \n" + huidigeRit.toString();
        return uit;
    }
}
