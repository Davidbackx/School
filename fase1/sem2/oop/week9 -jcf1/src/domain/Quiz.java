package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Quiz {

	public List<Opdracht> opdrachten;

	public Quiz(){
		this.opdrachten = new ArrayList<>();
	}
	
	// hoeveel opdracht objecten zitten er in de opdrachtenCollectie
	public int getAantalOpdrachten(){
		return opdrachten.size();
	}
		
	public boolean isLeeg(){
		return opdrachten.isEmpty();
	}
		
		
	//voegt een nieuwe opdracht toe achteraan de opdrachtenCollectie
	// let op opdracht mag niet al voorkomen volgens equals
	
	public boolean voegOpdrachtToe(Opdracht opdrachtNieuw){
		if (opdrachtNieuw == null) return false;
		if (opdrachten.contains(opdrachtNieuw)) return false;
		this.opdrachten.add(opdrachtNieuw);
		return true;
	}
	
		
	// TODO verwijder de eventuele opdracht op met opdrachtId in de opdrachtenCollectie
	//geeft de verwijderde opdracht terug TIP: gebruik iterator
	public Opdracht verwijderOpdracht(int opdrachtId) {
		Iterator<Opdracht> it = this.opdrachten.iterator();
		boolean gevonden = false;
		Opdracht op = null;
		while (it.hasNext() && !gevonden) {
			op = it.next();
			if (op.getOpdrachtID() == opdrachtId) {
				it.remove();
				gevonden = true;
			}
		}
		return op;
	}

	//TODO geeft willekeurige opdracht terug	
	public Opdracht getRandomOpdracht() {
		if (this.opdrachten.isEmpty()) return null;
		int i = (int)(Math.random() * this.opdrachten.size());
		return this.opdrachten.get(i);
	}
		
	// TODO elke opdracht uit de opdrachtenCollectie(volgens toString van Opdracht klasse), elke
	//opdracht op een nieuwe lijn
	public String toString(){
		String uit = "";
		for (Opdracht o: this.opdrachten){
			uit+= o + "\n";
		}
		return uit;
	}


}
