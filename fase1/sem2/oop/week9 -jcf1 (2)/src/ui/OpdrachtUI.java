package ui;

import javax.swing.JOptionPane;

import db.OpdrachtDatabank;
import domain.Opdracht;
import domain.Quiz;

import java.util.List;

public class OpdrachtUI {

	public static void main(String[] args) {
		// TODO gebruik de OpdrachtDatabase klasse  om opdrachten van een txt
		// bestand te lezenen en hier een Quiz van te maken
		Quiz quiz = new Quiz();
		List<Opdracht> opdrachten = new OpdrachtDatabank("Opdrachten-1.txt").getOpdrachtenGesorteerdOpId();
		for (Opdracht o: opdrachten) quiz.voegOpdrachtToe(o);
		System.out.println(quiz);

		
		// TODO schrijf de main methode verder uit zodat volgende gebeurt
		// Kies een willekeurige opdracht en toon de vraag aan de gebruiker in de console, 
		// waarbij hij een antwoord kan geven in de console dat gecontroleerd wordt met het juiste antwoord.
		// bij foutieve antwoord van de gebruiker kan de hint gegeven worden
		// zie forum --> discussielijn met de naam "JOptionPane" van Greetje Jongen voor inlezen console

		/*
		Opdracht o = quiz.getRandomOpdracht();
		String ant = JOptionPane.showInputDialog(o.getVraag());
		if (ant.equals(o.getAntwoord()));
		else {
			while (!ant.equals(o.getAntwoord()))
				ant = JOptionPane.showInputDialog(o.getVraag() + "\n" + o.getAntwoordHint());
		}
		*/
	}

}
