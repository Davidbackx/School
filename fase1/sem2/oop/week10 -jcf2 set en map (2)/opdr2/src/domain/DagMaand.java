package domain;

import java.time.LocalDate;

public class DagMaand implements Comparable<DagMaand> {
	private final String[] maandNamen ={"dummy","januari","februari","maart","april","mei","juni",
			                 "juli","augustus","september","oktober","november","december"};
	
	private int dag, maand;

	public DagMaand(int dag, int maand) {
		this.dag = dag;
		this.maand = maand;
	}

	public DagMaand(LocalDate geboorteDatum) {
		if (geboorteDatum != null){
			this.dag = geboorteDatum.getDayOfMonth();
			this.maand = geboorteDatum.getMonthValue();
		} else throw new IllegalArgumentException();
		
	}
		
	public String toString(){
		return this.dag + " " + maandNamen[this.maand];
	}
	
	// TODO vul de ontbrekende methodes aan
	// tip DagMaand zal gebruikt worden als key in een treemap
	// je mag geen code laten genereren door IntelliJ

	@Override
	public int hashCode () {
		return 100 * maand + dag;
	}

	@Override
	public boolean equals (Object o) {
		if (o == null) return false;
		else {
			if (o.getClass() == this.getClass()) {
				DagMaand dm = (DagMaand)o;
				if (dm.dag != dag)
					return false;
				if (dm.maand != maand)
					return false;
				return true;
			}
			else return false;
		}
	}


	@Override
	public int compareTo(DagMaand o) {
		if (o == null) return 1;
		int i = maand - o.maand;
		if (i == 0) {
			i = dag - o.dag;
		}
		return i;
	}
}
