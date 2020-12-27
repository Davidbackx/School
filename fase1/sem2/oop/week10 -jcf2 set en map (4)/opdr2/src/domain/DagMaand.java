package domain;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DagMaand other = (DagMaand) o;
		return this.maand == other.maand && this.dag == other.dag;
	}


	@Override
	public int compareTo(DagMaand o) {
		if (o == null)
			return 1;
		int i = maand - o.maand;
		if (i == 0)
			i = dag - o.dag;
		return i;
	}
}
