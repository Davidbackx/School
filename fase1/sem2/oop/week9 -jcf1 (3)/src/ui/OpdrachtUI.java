package ui;

import javax.swing.JOptionPane;

import db.OpdrachtDatabank;
import domain.Opdracht;
import domain.Quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class OpdrachtUI {

	public static void main(String[] args) {

		// TODO gebruik de OpdrachtDatabase klasse  om opdrachten van een txt
		// bestand te lezenen en hier een Quiz van te maken
		OpdrachtDatabank db = new OpdrachtDatabank("Opdrachten-1.txt");
		List<Opdracht> opdracten = db.getOpdrachten();
		Quiz quiz = new Quiz();
		for (Opdracht o : opdracten)
			quiz.voegOpdrachtToe(o);

		// TODO schrijf de main methode verder uit zodat volgende gebeurt
		// Kies een willekeurige opdracht en toon de vraag aan de gebruiker in de console, 
		// waarbij hij een antwoord kan geven in de console dat gecontroleerd wordt met het juiste antwoord.
		// bij foutieve antwoord van de gebruiker kan de hint gegeven worden
		// zie forum --> discussielijn met de naam "JOptionPane" van Greetje Jongen voor inlezen console
		Opdracht opdracht = quiz.getRandomOpdracht();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println(opdracht.getVraag());
			String antwoord = bufferedReader.readLine();
			if (opdracht.isHoofdletterGevoelig()){
				if (antwoord.equals(opdracht.getAntwoord())){
					System.out.println("Goed gedaan");
				}else {
					System.out.println("Niet ok; het juiste antwoord is: \n" + opdracht.getAntwoord());
				}} else {
				if (antwoord.equalsIgnoreCase(opdracht.getAntwoord())){
					System.out.println("Goed gedaan");
				}else {
					System.out.println("Niet ok; het juiste antwoord is: " + opdracht.getAntwoord());
				}
			}

		}	catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
