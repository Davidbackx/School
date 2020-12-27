package domain;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CirkelTest {
    Punt2D middelpunt;
    int straal;
    Color kleur;
    Cirkel c,c1,c2;
    private Color andereKleur;

    @Before
    public void setUp() throws Exception {
        middelpunt = new Punt2D(300,400);
        straal = 100;
        kleur = Color.YELLOW;
        c = new Cirkel(kleur,middelpunt,straal);
        c1 = new Cirkel(kleur,new Punt2D(350,350),80);
        c2 = new Cirkel(kleur,new Punt2D(300,510),10);
        andereKleur = Color.BLACK;
    }

    @Test
    public void defaultCirkelMaaktZwarteCirkelMetMiddelpunt1komma1enstraal1(){
        Cirkel c = new Cirkel();
        assertEquals(Color.black,c.getKleur());
        assertTrue(new Punt2D(1,1).heeftZelfdeCoordinatenAls(c.getMiddelPunt()));
        assertEquals(1,c.getStraal());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCirkelMetGeenKleurGooitException()
    {
        new Cirkel(null,middelpunt,straal);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCirkelMetGeenMiddelPuntGooitException()
    {
        new Cirkel(kleur,null,straal);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCirkelMetNegatieveStraalGooitException()
    {

        new Cirkel(kleur,middelpunt,-5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCirkelMetNulAlsStraalGooitException()
    {
        new Cirkel(kleur,middelpunt,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCirkelMetTeGroteStraalGooitException()
    {
        new Cirkel(kleur,middelpunt,350);
    }

    @Test
    public void testCirkelMetGeldigePArametersMaaktObject()
    {
        Cirkel cirkel = new Cirkel(kleur,middelpunt,straal);
        assertEquals(kleur,cirkel.getKleur());
        assertEquals(straal,cirkel.getStraal());
        assertTrue(middelpunt.heeftZelfdeCoordinatenAls(cirkel.getMiddelPunt()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBevatPuntMetNullGooitException() {
        c.bevatPunt(null);
    }

    @Test
    public void testBevatPuntPuntInCirkelGeeftTrue() {
        assertTrue(c.bevatPunt(new Punt2D(350,450)));
    }

    @Test
    public void testBevatPuntPuntOpRandGeeftTrue() {
        assertTrue(c.bevatPunt(new Punt2D(300,300)));
    }

    @Test
    public void testBevatPuntPuntNietInCirkelGeeftFalse() {
        assertFalse(c.bevatPunt(new Punt2D(50,300)));
    }
    @Test(expected = IllegalArgumentException.class)
    public void overlaptMetNullGooitException() {
        c.overlapt(null);
    }

    public void testOverlaptMetOverlappendeCirkelGeeftTrue(){
        assertTrue(c.overlapt(c1));
    }

    public void testOverlaptMetNietOverlappendeCirkelGeeftFalse(){
        assertFalse(c2.overlapt(c1));
    }

    public void testOverlaptMetRakendeCirkelGeeftFalse(){
        assertFalse(c2.overlapt(c));
    }


    @Test
    public void testVerdubbelVerandertStraalVanDezeCirkelInTweeKeerZoGroot() {
        c.verdubbel();
        assertEquals(kleur,c.getKleur());
        assertTrue(middelpunt.heeftZelfdeCoordinatenAls(c.getMiddelPunt()));
        assertEquals(straal*2,c.getStraal());
    }

    @Test
    public void testHalveerVerandertStraalVanDezeCirkelInTweeKeerZoKlein() {
        c.halveer();
        assertEquals(kleur,c.getKleur());
        assertTrue(middelpunt.heeftZelfdeCoordinatenAls(c.getMiddelPunt()));
        assertEquals(straal/2,c.getStraal());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testVeranderKleurMetNullGooitException(){
        c.veranderKleur(null);
    }

    @Test
    public void testVeranderKleurMetandereKleurVerandertKleur(){
        c.veranderKleur(andereKleur);
        assertEquals(andereKleur,c.getKleur());

    }

}