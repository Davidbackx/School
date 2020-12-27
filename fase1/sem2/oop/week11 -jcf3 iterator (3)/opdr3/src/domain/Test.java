package domain;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class Test {
	
	private DeelnemerGroep groep;
	private Quiz quiz;
	private int vraagIndex = 0;
	private Opdracht opdrachtAanBeurt;

	/**
	 * Maakt een nieuw spel aan met de gegeven deelnemergroep en quiz.
	 * 
	 * @param deelnemers	de groep van deelnemers
	 * @param quiz	de quiz
	 */	
	public Test(DeelnemerGroep deelnemers, Quiz quiz) {
		this.groep = deelnemers;
		this.quiz = quiz;
	}

	/**
	 * Geeft aan of er nog opdrachten zijn in de quiz.
	 * 
	 * @return true als alle opdrachten uit de quiz beantwoord zijn, anders false
	 */
	public boolean isVoorbij() {
		return vraagIndex >= quiz.getAantalOpdrachten();
	}
    
	/**
	 * Geeft de vraag van de volgende opdracht van de quiz.
	 * 
	 * @return de vraag van de volgende opdracht van de quiz
	 */
	public String getVolgendeVraag() {
		opdrachtAanBeurt = quiz.getOpdracht(vraagIndex);
		vraagIndex++;
	    return (opdrachtAanBeurt.getVraag());
	}
		
	public int getAantalDeelnemers(){
		return groep.getAantalDeelnemers();
	}
	
	public String getDeelnemerAanBeurt(){
		return groep.getDeelnemerAanBeurt();
	}

	/**
	 * Controleert of het antwoord juist is, registreert true/false resultaat voor de speler aan beurt en 
	 * en verplaatst de speler die geantwoord heeft naar achter in de queue
	 * 
	 * @param antwoord	het antwoord (tru.false)  van de deelnemer op de vraag
	 */
	public boolean speel(String antwoord) {
		//TO DO
		boolean juist = opdrachtAanBeurt.isJuisteAntwoord(antwoord);
		groep.registreerScore(groep.getEnVerplaatsDeelnemerAanBeurt(), juist);
//		boolean res = opdrachtAanBeurt.isJuisteAntwoord(antwoord);
//		String deelnemer = groep.getEnVerplaatsDeelnemerAanBeurt();
//		groep.registreerScore(deelnemer, res);
		return juist;
	}

	/**
	 * Geeft de deelnemer terug met het meeste punten.
	 * 
	 * @return de deelnemer met het meeste punten
	 */
	public String getWinnaar(){
	    return groep.getWinnaar();
    }

	/**
	 * Geeft de verzameling van deelnemers terug met het meeste punten.
	 * 
	 * @return de deelnemers met het meeste punten
	 */
	public Set<String> getWinnaars() {
		// TO DO
		return groep.getWinnaars();
	}
	
	/**
	 * Geeft de verzameling van deelnemers terug met een overzicht per vraag
	 * of zij die vraag juist/fout hebben beantwoord
	 * 
	 * @return de deelnemers met juist/fout antwoorden
	 */
	public Map <String,ArrayList<Boolean>> getScoresDeelnemers(){
		return groep.getScoresDeelnemerGroep();
	}	
}
