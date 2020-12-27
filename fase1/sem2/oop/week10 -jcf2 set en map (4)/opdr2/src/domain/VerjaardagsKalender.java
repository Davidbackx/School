package domain;

import javax.print.DocFlavor;
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
		if (p != null){
			DagMaand d = new DagMaand(p.getGeboorteDatum());
			if (!this.kalender.containsKey(d)){
				this.kalender.put(d, new TreeSet<>());
			}
			this.kalender.get(d).add(p);
		}
	}
	
	public void verwijderPersoon(Persoon p){
		//TO DO schrijf deze methode
		if (p != null) {
			DagMaand dm = new DagMaand(p.getGeboorteDatum());
			if (kalender.containsKey(dm)) {
				if (kalender.get(dm).contains(p)) {
					kalender.get(dm).remove(p);
					if (kalender.get(dm).size() == 0)
						kalender.remove(dm);
				}
			}
		}
	}
	
	public String toString(){
		String uit = "";
		for (DagMaand d : this.kalender.keySet()){
			uit+= d +  " " + this.kalender.get(d) + ":\n"; 
		}
		return uit;
	}
}
