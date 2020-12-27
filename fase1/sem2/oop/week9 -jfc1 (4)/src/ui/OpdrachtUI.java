package ui;

import db.OpdrachtDatabank;
import domain.Opdracht;
import domain.Quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class OpdrachtUI {

	public static void main(String[] args) {
		Quiz quiz = new Quiz();
		List<Opdracht> opdrachten = new OpdrachtDatabank("opdrachten-1.txt").getOpdrachtenGesorteerdOpId();
		for (Opdracht o: opdrachten) quiz.voegOpdrachtToe(o);
		System.out.println(quiz);

		// TODO maak een nieuwe klasse die de logica om opdrachten van een txt
		// bestand te lezen, implementeert, en hier een Quiz van
		// maakt

		// TODO schrijf de main methode verder uit zodat dit ook gebeurt
		// zie forum --> JOptionPane Greetje Jongen voor inlezen console
//		Opdracht opdracht = quiz.getRandomOpdracht();
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		try {
//			System.out.println(opdracht.getVraag());
//			String antwoord = bufferedReader.readLine();
//			if (opdracht.isHoofdletterGevoelig()){
//				if (antwoord.equals(opdracht.getAntwoord())){
//					System.out.println("Goed gedaan");
//				}else {
//					System.out.println("Niet ok; het juiste antwoord is: \" + opdracht.getAntwoord()");
//				}} else {
//				if (antwoord.equalsIgnoreCase(opdracht.getAntwoord())){
//					System.out.println("Goed gedaan");
//				}else {
//					System.out.println("Niet ok; het juiste antwoord is: " + opdracht.getAntwoord());
//				}
//			}
//
//		}	catch (IOException e) {
//			System.out.println(e.getMessage());
//		}
	}

}
