package domain;

import static org.junit.Assert.*;

import domain.Punt2D;
import org.junit.Before;
import org.junit.Test;;

public class Punt2DTest {
    private Punt2D p;
    @Before
    public void setUp() throws Exception {
        p = new Punt2D(2,4);
    }

    @Test
    public void testDefaultConstructorMaaktObjectMetxNulenyNul() {
        Punt2D p= new Punt2D();
        assertEquals(0,p.getX());
        assertEquals(0,p.getY());
    }

    @Test
    public void testPunt2DMetPositieveParametersMaaktObjectMetJuisteCoordinaten() {
        Punt2D p= new Punt2D(1,2);
        assertEquals(1,p.getX());
        assertEquals(2,p.getY());
    }

    @Test
    public void testPunt2DMetxCoordinaatNulenYCoordinaatPositiefMaaktObjectMetJuisteCoordinaten() {
        Punt2D p= new Punt2D(0,2);
        assertEquals(0,p.getX());
        assertEquals(2,p.getY());
    }

    @Test
    public void testPunt2DIntIntNul() {
        Punt2D p= new Punt2D(1,0);
        assertEquals(1,p.getX());
        assertEquals(0,p.getY());
    }

    @Test
    public void testPunt2DMetxEnyNulMaaktObjectMetJuisteCoordinaten() {
        Punt2D p= new Punt2D(0,0);
        assertEquals(0,p.getX());
        assertEquals(0,p.getY());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPunt2DMetxNegatiefenyPositiefGooitException() {
        new Punt2D(-1,2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPunt2DMetxPositiefEnyNegatiefGooitException() {
        new Punt2D(1,-2);
    }

    @Test
    public void testMoveHorizontaalMetPositieveAfstandGenereertNieuwPuntDatGelijkIsAanDitPuntHorizontaalVerschovenNaarRechtsOverGegegevnAfstand() {
        Punt2D q = p.moveHorizontaal(1);
        assertEquals(3,q.getX());
        assertEquals(4,q.getY());
    }

    @Test
    public void testMoveHorizontaalMetNulGeeftNieuwPuntMetZelfdeCoordinatenAlsDitPunt() {
        Punt2D q = p.moveHorizontaal(0);
        assertTrue(p.heeftZelfdeCoordinatenAls(q));
        assertFalse(p == q);
    }

    @Test
    public void testMoveHorizontaalMetNegatiefNietTeGrootGeeftNieuwPuntDatGelijkIsAanDitPuntHorizontaalVerschovenNaarLinksOverGegegevnAfstand() {
        Punt2D q = p.moveHorizontaal(-1);
        assertEquals(1,q.getX());
        assertEquals(4,q.getY());
    }

    @Test
    public void testMoveHorizontaalMetNegatiefNetNietTeGrootGeeftNieuwPuntDatGelijkIsAanDitPuntHorizontaalVerschovenNaarLinksOverGegegevnAfstand() {
        Punt2D q = p.moveHorizontaal(-2);
        assertEquals(0,q.getX());
        assertEquals(4,q.getY());
    }


    @Test(expected = IllegalArgumentException.class)
    public void testMoveHorizontaalMetNegatiefTeGrootGooitException() {
        p.moveHorizontaal(-3);
    }


    @Test
    public void testMoveVertikaalMetPositieveAfstandGenereertNieuwPuntDatGelijkIsAanDitPuntVerticaalVerschovenNaarOnderOverGegegevenAfstand() {
        Punt2D q = p.moveVerticaal(1);
        assertEquals(2,q.getX());
        assertEquals(5,q.getY());
    }

    @Test
    public void testMoveVertikaalMetNulGeeftNieuwPuntMetZelfdeCoordinatenAlsDitPunt() {
        Punt2D q = p.moveVerticaal(0);
        assertTrue(p.heeftZelfdeCoordinatenAls(q));
        assertFalse(p == q);
    }

    @Test
    public void testMoveVertikaalMetNegatiefNietTeGrootGeeftNieuwPuntDatGelijkIsAanDitPuntVerticaalVerschovenNaarBovenOverGegegevenAfstand() {
        Punt2D q = p.moveVerticaal(-1);
        assertEquals(2,q.getX());
        assertEquals(3,q.getY());
    }

    @Test
    public void testMoveVertikaalMetNegatiefNetNietTeGrootGeeftNieuwPuntDatGelijkIsAanDitPuntVerticaalVerschovenNaarBovenOverGegegevenAfstand() {
        Punt2D q = p.moveVerticaal(-4);
        assertEquals(2,q.getX());
        assertEquals(0,q.getY());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMoveVertikaalMetNegatiefTeGrootGooitException() {
        p.moveVerticaal(-5);
    }

    @Test
    public void testLigtLinksVanMetPuntMetKleinerexGeeftFalse() {
        Punt2D q = new Punt2D(1,6);
        assertFalse(p.ligtLinksVan(q));
    }

    @Test
    public void testLigtLinksVanMetPuntMetGroterexGeeftTrue() {
        Punt2D q = new Punt2D(3,4);
        assertTrue(p.ligtLinksVan(q));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLigtLinksVanMetNullGooitException() {
        p.ligtLinksVan(null);
    }

    @Test
    public void testLigtLinksVanZelfdeCoordinatenGeeftFalse() {
        Punt2D q = new Punt2D(2,4);
        assertFalse(p.ligtLinksVan(q));
        assertFalse(q.ligtLinksVan(p));
    }

    @Test
    public void testLigtRechtsVanPuntMetGroterexGeeftFalse() {
        Punt2D q = new Punt2D(3,6);
        assertFalse(p.ligtRechtsVan(q));
    }

    @Test
    public void testLigtRechtsVanPuntMetKleinerexGeeftTrue() {
        Punt2D q = new Punt2D(1,3);
        assertTrue(p.ligtRechtsVan(q));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLigtRechtsVanMetNullGooitException() {
        p.ligtRechtsVan(null);
    }

    @Test
    public void testLigtRechtsVanZelfdeCoordinatenGeeftFalse() {
        Punt2D q = new Punt2D(2,4);
        assertFalse(p.ligtRechtsVan(q));
        assertFalse(q.ligtRechtsVan(p));
    }


    @Test
    public void testLigtHogerMEtPuntMetGrotereYGeeftTrue() {
        Punt2D q = new Punt2D(3,6);
        assertTrue(p.ligtHoger(q));
    }

    @Test
    public void testLigtHogerMetPuntMetKleinereYGeeftFalse() {
        Punt2D q = new Punt2D(3,3);
        assertFalse(p.ligtHoger(q));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLigtHogerMetNullGooitException() {
        p.ligtHoger(null);
    }

    @Test
    public void testLigtHogerZelfdeCoordinatenGeeftFalse() {
        Punt2D q = new Punt2D(2,4);
        assertFalse(p.ligtHoger(q));
        assertFalse(q.ligtHoger(p));
    }
    @Test
    public void testLigtLagerMetPuntMetGrotereyGeeftFalse() {
        Punt2D q = new Punt2D(2,6);
        assertFalse(p.ligtLager(q));
    }

    @Test
    public void testLigtLagerMetPuntMetKleinereyGeeftTrue() {
        Punt2D q = new Punt2D(2,3);
        assertTrue(p.ligtLager(q));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLigtLagerMetNullGooitException() {
        Punt2D p = new Punt2D(4,5);
        p.ligtLager(null);
    }

    @Test
    public void testLigtLagerZelfdeCoordinatenGeeftFalse() {
        Punt2D q = new Punt2D(2,4);
        assertFalse(p.ligtLager(q));
        assertFalse(q.ligtLager(p));
    }

    @Test
    public void testHeeftZelfdeCoordinatenAlsMEtPuntMetZElfdeCoordinatenGeeftTrue() {
        Punt2D q = new Punt2D(2,4);
        assertTrue(p.heeftZelfdeCoordinatenAls(q));
    }

    @Test
    public void testHeeftZelfdeCoordinatenAlsAndereXGeeftFalse() {
        Punt2D q = new Punt2D(3,4);
        assertFalse(p.heeftZelfdeCoordinatenAls(q));
    }

    @Test
    public void testHeeftZelfdeCoordinatenAlsAndereYGeeftFalse() {
        Punt2D q = new Punt2D(2,5);
        assertFalse(p.heeftZelfdeCoordinatenAls(q));
    }

    @Test
    public void testHeeftZelfdeCoordinatenAlsAndereXEnAndereYGeeftFalse() {
        Punt2D q = new Punt2D(3,5);
        assertFalse(p.heeftZelfdeCoordinatenAls(q));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHeeftZelfdeCoordinatenAlsMetNullGooitException() {
        Punt2D p = new Punt2D(4,5);
        p.heeftZelfdeCoordinatenAls(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBerekenAfstandTotMetNullGooitException() {
        Punt2D p = new Punt2D(1,2);
        p.berekenAfstandTot(null);
    }
    @Test
    public void testBerekenAfstandTotAlsNietNyllBerekentAfstand() {
        Punt2D p = new Punt2D(1,2);
        Punt2D q = new Punt2D(4,6);
        assertEquals(5,p.berekenAfstandTot(q),0.1);
        assertEquals(5,q.berekenAfstandTot(p),0.1);
        assertEquals(0,p.berekenAfstandTot(p),0.1);
    }

    @Test
    public void testFormat() {
        Punt2D p = new Punt2D(1,2);
        assertEquals("(1 , 2)",p.format());
    }

}