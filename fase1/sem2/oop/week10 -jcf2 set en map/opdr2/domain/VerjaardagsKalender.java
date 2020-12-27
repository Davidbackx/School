package domain;

import java.time.LocalDate;
import java.util.TreeMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class VerjaardagsKalender {
	private Map<DagMaand,Set<Persoon>> kalender;
	
	public VerjaardagsKalender(){
		this.kalender = new TreeMap<>();
	}
	
	public void voegVerjaardagToe(Persoon p){
		//TO DO schrijf deze methode
		if (p != null) {
			DagMaand dm = new DagMaand(p.getGeboorteDatum());
			if (!this.kalender.containsKey(dm)) {
				this.kalender.put(dm, new TreeSet<>());
			}
			this.kalender.get(dm).add(p);
		}
	}
	
	public void verwijderPersoon(Persoon p){
		//TO DO schrijf deze methode
		
	}
	
	public String toString(){
		String uit = "";
		for (DagMaand d : this.kalender.keySet()){
			uit+= d +  " " + this.kalender.get(d) + ":\n"; 
		}
		return uit;
	}
}
