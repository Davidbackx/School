import java.time.LocalTime;

public class Appeke {
    public static void main(String[] args) {
        Double[] tar = {5.0, 3.0, 1.5};
        Bedrijf b = new Bedrijf(tar);

        Chauffeur ch = new Chauffeur("Jan");
        b.voegChauffeurToe(ch);

        ch.stopLaatsteRit(10.3, LocalTime.of(17,20));

        System.out.println(b.geefTicket("Jan"));
    }
}
