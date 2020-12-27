package domain;

import java.util.LinkedList;
import java.util.List;
import db.OpdrachtDatabank;

public class Quiz {
	
	private List<Opdracht> opdrachten;
	
	//aanmaken van een quiz met een aantal unieke random geselecteerde opdrachten uit de opdrachtenDatabase
	public Quiz(int aantalOpdrachten){	
		OpdrachtDatabank opdrachtenDB = new OpdrachtDatabank();
		int aantalOpdrachtenInDatabank = opdrachtenDB.getOpdrachten().size();
		this.opdrachten = new LinkedList<>();
		int i = 0;
		while (i < Math.min(aantalOpdrachten,aantalOpdrachtenInDatabank)){
			Opdracht opdracht = opdrachtenDB.getRandomOpdracht();
			if (!opdrachten.contains(opdracht)){
				opdrachten.add(opdracht);
				i++;
			}
		}
	}
	
	public Quiz(List<Opdracht> opdrachten){
		this.opdrachten = opdrachten;
	}

	public List<Opdracht> getOpdrachten(){
		return opdrachten;
	}
	
	public Opdracht getOpdracht(int index) {
		return opdrachten.get(index);
	}

	public int getAantalOpdrachten(){
		return opdrachten.size();
	}	
		
	public String toString(){
		String result = "";
		for(Opdracht o : opdrachten) {
			result += o.toString() +"\n";
		}
		return result;
	}
}
