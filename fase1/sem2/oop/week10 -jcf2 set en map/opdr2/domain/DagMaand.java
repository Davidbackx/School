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
	public int hashCode() {

		return maand * 100 + dag;
	}

	public boolean equals (Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		DagMaand other = (DagMaand)o;
		if (dag != other.dag)
			return false;
		if (maand != other.maand)
			return false;
		return  true;
	}

	@Override
	public int compareTo(DagMaand o) {
		if (o == null) return 1;
		else if (this.maand < o.maand) return -1;
		else if (this.maand > o.maand) return 1;
		return this.dag - o.dag;
	}
}
