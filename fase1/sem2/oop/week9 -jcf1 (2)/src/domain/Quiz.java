package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Quiz {
	
	private ArrayList<Opdracht> opdrachten;
		
	public Quiz(){		
		opdrachten = new ArrayList<>();
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
		if (opdrachten.contains(opdrachtNieuw))
			return false;
		else {
			opdrachten.add(opdrachtNieuw);
			return true;
		}
	}

	//geeft de verwijderde opdracht terug TIP: gebruik iterator
	public Opdracht verwijderOpdracht(int opdrachtId) {
		Iterator it = opdrachten.iterator();

		while (it.hasNext()) {
			Opdracht next = (Opdracht) it.next();
			if (next.getOpdrachtID() == opdrachtId) {
				it.remove();
				return  next;
			}
		}
		return null;
	}

	public Opdracht getRandomOpdracht(){
 		return opdrachten.get(new Random().nextInt(opdrachten.size()));
	}

	//opdracht op een nieuwe lijn
	public String toString(){
		String out = "";
		for (Opdracht o : opdrachten) {
			out += o.toString() + "\n";
		}
		return out;
	}
}
