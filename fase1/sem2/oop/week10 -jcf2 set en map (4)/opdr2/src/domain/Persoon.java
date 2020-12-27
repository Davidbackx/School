package domain;

import java.time.LocalDate;
import java.util.Objects;

public class Persoon implements Comparable<Persoon> {
	private String naam, voornaam;
	private LocalDate geboorteDatum;
	
	public Persoon(String naam, String voornaam, LocalDate geboorteDatum) {
		if (naam == null || voornaam == null || geboorteDatum == null){
			throw new IllegalArgumentException();
		}
		this.naam = naam;
		this.voornaam = voornaam;
		this.geboorteDatum = geboorteDatum;
	}

	public String getNaam() {
		return naam;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public LocalDate getGeboorteDatum() {
		return geboorteDatum;
	}
	
	
	public String toString(){
		return this.naam + " "   + this.voornaam + " " + this.geboorteDatum.getDayOfMonth()+"-"+this.geboorteDatum.getMonthValue()+"-"+this.geboorteDatum.getYear();
	}
	
	//TO DO vul de ontbrekende methodes aan
	// tip - personen zullen in volgorde van leeftijd worden bijgehouden in een TreeSet
	// ontbrekende methodes mogen gegenereerd worden in IntelliJ -> code->generate


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Persoon persoon = (Persoon) o;
		return Objects.equals(naam, persoon.naam) &&
				Objects.equals(voornaam, persoon.voornaam) &&
				Objects.equals(geboorteDatum, persoon.geboorteDatum);
	}

	@Override
	public int compareTo(Persoon p) {
		if (p == null) return 1;
		int terug = this.getGeboorteDatum().compareTo(p.getGeboorteDatum());
		if (terug == 0) terug = this.getNaam().compareTo(p.getNaam());
		if (terug == 0) terug = this.getVoornaam().compareTo(p.getVoornaam());
		return terug;
	}
	@Override
	public int hashCode() {
		return Objects.hash(naam, voornaam, geboorteDatum);
	}



}
