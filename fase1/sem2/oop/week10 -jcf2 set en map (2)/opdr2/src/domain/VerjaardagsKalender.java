package domain;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.Map;
import java.util.Set;


public class VerjaardagsKalender {
	private Map<DagMaand,Set<Persoon>> kalender;
	
	public VerjaardagsKalender(){
		this.kalender = new TreeMap<>();
	}
	
	public void voegVerjaardagToe(Persoon p){
		//TO DO schrijf deze methode
		if (p != null){
			DagMaand dm = new DagMaand(p.getGeboorteDatum().getDayOfMonth(), p.getGeboorteDatum().getMonthValue());
			if (!kalender.containsKey(dm)) {
				kalender.put(dm, new HashSet<Persoon>());
			}
			kalender.get(dm).add(p);
		}
	}
	
	public void verwijderPersoon(Persoon p){
		//TO DO schrijf deze methode
		if (p!=null) {
			DagMaand dm = new DagMaand(p.getGeboorteDatum().getDayOfMonth(), p.getGeboorteDatum().getMonthValue());
			if (this.kalender.containsKey(dm)) {
				Set<Persoon> personen = this.kalender.get(dm);
				if (personen != null) {
					this.kalender.get(dm).remove(p);
					if (this.kalender.get(dm).size() == 0) {
						this.kalender.remove(dm);
					}
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
