import java.time.LocalDate;

public class AppekeDeel1 {
    public static void main(String[] args){

        Zwemschool zwemProximus = new Zwemschool();
        zwemProximus.newNiveaugroep("wit");
        zwemProximus.newNiveaugroep("rood",6);
        zwemProximus.newNiveaugroep("blauw",7);

        System.out.println(zwemProximus.getGeschiktegroepenVoorLeeftijd(8)); // moet [rood,blauw] geven
        System.out.println(zwemProximus.getGeschiktegroepenVoorLeeftijd(18)); // moet [wit,rood,blauw] geven

        zwemProximus.newKandidaat("Ann Janssen",LocalDate.of(1999,5,6));
        zwemProximus.newKandidaat("Jan Frederiks",LocalDate.of(2014,12,12));
        zwemProximus.newKandidaat("Piet Leenders",LocalDate.of(2012,5,6));
        System.out.println(zwemProximus.aantalKandidaten()); // moet 3 geven
        zwemProximus.addKandidaatToNiveaugroep("wit",new Kandidaat("Ann Janssen",LocalDate.of(1999,5,6)));
        System.out.println(zwemProximus.volgendeKandidaat("wit").getNaam());// met Ann JAnssen 1999-05-06 geven
        System.out.println(zwemProximus.aantalKandidaten()); // moet 2 geven
    }
}
