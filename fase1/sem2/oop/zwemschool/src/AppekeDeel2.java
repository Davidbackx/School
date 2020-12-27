public class AppekeDeel2 {
    public static void main(String[] args){
        Zwemschool proxOasis = new Zwemschool();

        Locatie zwembad = new Zwembad("ZZZ",6,2.5);
        Locatie grasveld = new Buitenruimte("Grasveld aan park");
        Locatie sporthal = new Binnenruimte("Sporthal",50,66);
        Locatie cafetaria = new Binnenruimte("cafetaria",40,120);

        proxOasis.voegLocatieToe(zwembad);
       // proxOasis.voegLocatieToe(grasveld);
        proxOasis.voegLocatieToe(sporthal);
        proxOasis.voegLocatieToe(cafetaria);

        Locatie l = proxOasis.geefLocatie(45,80);
        System.out.println(l);

    }
}
