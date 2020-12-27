package ui;

import domain.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainNaschoolseActiviteiten {
    public static void main(String[] args) {
        Persoon an_12jaar = new Persoon("Anthonis","An", LocalDate.of(2008,1,1));
        Persoon bert_4jaar = new Persoon("Baerts","Bert",LocalDate.of(2016,1,1));
        Persoon celeste_8jaar = new Persoon("Celis","Celeste", LocalDate.of(2012,1,1));

        List<Persoon> kandidaten = new ArrayList<>();
        kandidaten.add(an_12jaar);
        kandidaten.add(bert_4jaar);
        kandidaten.add(celeste_8jaar);

        LocalDate mei01 = LocalDate.of(2020,5,1);
        LocalDate juni01 = LocalDate.of(2020,6,1);

        Dropping dropping = new Dropping("Dropping",mei01,"Leuven");
        Speelplein speelplein = new Speelplein("Don Bosco",juni01);
        Wedstrijd lopen = new Wedstrijd("Loopwedstrijd", juni01,new Lopen());
        Wedstrijd voetbal = new Wedstrijd("Voetbalwedstrijd",juni01,new Voetbal());

        // Maak OrganisatieNaschoolseActiviteten aan
        // Voeg de vier activiteiten toe
        OrganisatieNaschoolseActiviteiten naschoolseActiviteiten= new OrganisatieNaschoolseActiviteiten();
        naschoolseActiviteiten.voegActiviteitToe(dropping);
        naschoolseActiviteiten.voegActiviteitToe(speelplein);
        naschoolseActiviteiten.voegActiviteitToe(lopen);
        naschoolseActiviteiten.voegActiviteitToe(voetbal);

        // Voeg dropping nogmaals toe en zorg ervoor dat
        // 1. opgegooide foutboodschap naar console geschreven wordt
        // 2. programma verder kan gaan
        System.out.println("*********************");
        System.out.println("Probeer activiteit twee maal toe te voegen");
        try {
            naschoolseActiviteiten.voegActiviteitToe(dropping);
        }
        catch (DomainException e) {
            System.out.println(e.getMessage());
        }

        // Schrijf personen in voor activiteit
        naschoolseActiviteiten.schrijfIn(an_12jaar,dropping);
        naschoolseActiviteiten.schrijfIn(an_12jaar,speelplein);
        naschoolseActiviteiten.schrijfIn(bert_4jaar,lopen);
        naschoolseActiviteiten.schrijfIn(celeste_8jaar,voetbal);

        // Schrijf Bert in voor dropping
        System.out.println("\n*********************");
        System.out.println("Schrijf Bert in voor activiteit waarvoor hij te jong is");
        try {
            naschoolseActiviteiten.schrijfIn(bert_4jaar,dropping);
        }
        catch (DomainException e) {
            System.out.println(e.getMessage());
        }

        // Schrijf wedstrijden naar scherm
        System.out.println("\n*********************");
        System.out.println("Overzicht Wedstrijden");
        for (Wedstrijd w:naschoolseActiviteiten.geefWedstrijden()
        ) {
            System.out.println(w+"\n");
        }

        // Geef mogelijke activiteiten voor Celeste op 1 juni
        System.out.println("*********************");
        System.out.println("Mogelijke activiteten Celeste op 1 juni");
        for (Activiteit a:naschoolseActiviteiten.geefActiviteitenVoorPersoonOpDag(celeste_8jaar,juni01)) {
            System.out.println(a+"\n");
        }

        // Verwijder alle activiteiten van 1 juni
        System.out.println("*********************");
        System.out.println("Aantal activiteiten voor verwijderen: "+naschoolseActiviteiten.geefAantalGeregistreerdeActiviteiten());
        naschoolseActiviteiten.verwijderActiviteitenOpDatum(juni01);
        System.out.println("Aantal activiteiten na verwijderen: "+naschoolseActiviteiten.geefAantalGeregistreerdeActiviteiten());


    }
}
