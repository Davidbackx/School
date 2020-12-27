package ui;

import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import domain.*;

public class QuizTestApp {

	public static void main(String[] args) {
		// maak een quiz met een aantal randomvragen uit de opdrachtendatabase
		String aantalVragen = JOptionPane.showInputDialog(null,"typ aantal gewenste vragen voor de quiz","Maak een quiz",JOptionPane.QUESTION_MESSAGE);
		Quiz quiz = new Quiz(Integer.parseInt(aantalVragen));
		// toon de aangemaakte quiz
		JOptionPane.showMessageDialog(null, quiz, "Dit is de quiz",JOptionPane.INFORMATION_MESSAGE);
		// geef de namen van de deelnemers aan de test
		String deelnemers = JOptionPane.showInputDialog(null,"typ namen van de deelnemers gescheiden door een komma","Maak een deelnemer groep",JOptionPane.QUESTION_MESSAGE);
		List <String> deelnemerLijst =  Arrays.asList(deelnemers.split(","));	
		// maak een deelnemergroep
		DeelnemerGroep groep = new DeelnemerGroep(deelnemerLijst);
		//maak een test
		Test test = new Test(groep,quiz);
		//start test
		//alle deelnemers beantwoorden vraag 1, vervolgens beurteling vraag 2, ...
		while (!test.isVoorbij()){
			String vraagAanBeurt = test.getVolgendeVraag();
			//Elke deelnemer beantwoord de vraag die aan de beurt is
			for (int i = 0; i < test.getAantalDeelnemers();i++){
				String deelnemerAanBeurt = test.getDeelnemerAanBeurt();
				//System.out.println(test.getDeelnemerAanBeurt());
				String antwoord = JOptionPane.showInputDialog(null,vraagAanBeurt,"Typ antwoord voor deelnemer "+deelnemerAanBeurt ,JOptionPane.QUESTION_MESSAGE);
				//het antwoord van de speler aan beurt wordt geregistreerd
				test.speel(antwoord);
			}
		}
		//de resultaten van de test worden getoond per deelnemer en per vraag
		JOptionPane.showMessageDialog(null, test.getScoresDeelnemers(), "Overzicht van de scores per deelnemer/vraag",JOptionPane.INFORMATION_MESSAGE);
		//de winnaar(s) van de test worden getoond	
		JOptionPane.showMessageDialog(null, test.getWinnaars(), "Overzicht van de winnaar(s) van de test",JOptionPane.INFORMATION_MESSAGE);
		//de totale score per deelnemer wordt getoond, geordend van de deelnemer met de hoogste score naar de deelnemer met de laagste score
		JOptionPane.showMessageDialog(null, groep.getPuntenOverzicht(), "Overzicht van de totale score per deelnemer",JOptionPane.INFORMATION_MESSAGE);
	}

}
