package ui;

import javax.swing.JOptionPane;

import db.ComparatorByCategorie;
import db.OpdrachtDatabank;
import domain.Opdracht;
import domain.Quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class OpdrachtUI {

	public static void main(String[] args) {

		// TODO gebruik de OpdrachtDatabase klasse  om opdrachten van een txt

		List<Opdracht> opdrachten = new OpdrachtDatabank("Opdrachten-1.txt").getOpdrachten();
		opdrachten.sort(new ComparatorByCategorie());
		for (Opdracht o: opdrachten) {
			System.out.println(o.toString());
		}

		
		// TODO schrijf de main methode verder uit zodat volgende gebeurt
		// Kies een willekeurige opdracht en toon de vraag aan de gebruiker in de console, 
		// waarbij hij een antwoord kan geven in de console dat gecontroleerd wordt met het juiste antwoord.
		// bij foutieve antwoord van de gebruiker kan de hint gegeven worden
		// zie forum --> discussielijn met de naam "JOptionPane" van Greetje Jongen voor inlezen console

//		try {
//			Opdracht rnd = quiz.getRandomOpdracht();
//			String antwoord = JOptionPane.showInputDialog(rnd.getVraag());
//
//			if (!antwoord.equals(rnd.getAntwoord())) {
//				while (!antwoord.equals(rnd.getAntwoord())) {
//					antwoord = JOptionPane.showInputDialog("Fout!\n" + rnd.getVraag() + "\n" + rnd.getAntwoordHint());
//				}
//			}
//			JOptionPane.showMessageDialog(null, "Juist!");
//		}
//		catch (Exception e) {
//			JOptionPane.showMessageDialog(null, "Error");
//		}
	}

}
