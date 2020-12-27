package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.logging.LoggingPermission;

public class Quiz {

	// TODO Vervang door een een gepaste collectie en initialiseer ze
	private List<Opdracht> opdrachten;

	public Quiz(){
		opdrachten = new ArrayList<>();
	}

	// hoeveel opdracht objecten zitten er in de opdrachtenCollectie
	public int getAantalOpdrachten(){
		// TODO
		return opdrachten.size();
	}

	public boolean isLeeg(){
		// TODO
		return opdrachten.isEmpty();
	}


	//voegt een nieuwe opdracht toe achteraan de opdrachtenCollectie
	// let op opdracht mag niet al voorkomen volgens equals

	public boolean voegOpdrachtToe(Opdracht opdrachtNieuw){
		// TODO
		if (opdrachtNieuw == null) return false;
		if (this.opdrachten.contains(opdrachtNieuw)) return false;
		this.opdrachten.add(opdrachtNieuw);
		return true;
	}


	// TODO verwijder de eventuele opdracht op met opdrachtId in de opdrachtenCollectie
	//geeft de verwijderde opdracht terug TIP: gebruik iterator
	public Opdracht verwijderOpdracht(int opdrachtId) {
		Iterator it = opdrachten.iterator();
		boolean gevonden = false;
		Opdracht next = null;
		while (it.hasNext() && !gevonden) {
			next = (Opdracht) it.next();
			if (next.getOpdrachtID() == opdrachtId) {
				gevonden = true;
				it.remove();
			}
		}
		return next;
	}

	//TODO geeft willekeurige opdracht terug
	public Opdracht getRandomOpdracht(){
		if (this.opdrachten.isEmpty()) return null;
		int i = (int)(Math.random() * this.opdrachten.size());
		return this.opdrachten.get(i);

	}

	// TODO elke opdracht uit de opdrachtenCollectie(volgens toString van Opdracht klasse), elke
	//opdracht op een nieuwe lijn
	public String toString(){
		String result = "";
		for (Opdracht o : opdrachten) {
			result += o + "\n";
		}
		return result;
	}
}
