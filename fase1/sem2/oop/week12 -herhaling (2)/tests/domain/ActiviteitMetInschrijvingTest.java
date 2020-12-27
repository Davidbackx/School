package domain;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class ActiviteitMetInschrijvingTest {

    @Test (expected = DomainException.class)
    public void test_schrijf_incorrect () {
        LocalDate mei01 = LocalDate.of(2020,5,1);
        Dropping dropping = new Dropping("Dropping",mei01,"Leuven");

        OrganisatieNaschoolseActiviteiten naschoolseActiviteiten= new OrganisatieNaschoolseActiviteiten();
        naschoolseActiviteiten.voegActiviteitToe(dropping);

        dropping.schrijfIn(new Persoon("Stijn", "Hendrix", LocalDate.of(2020, 2,2)));
    }

}