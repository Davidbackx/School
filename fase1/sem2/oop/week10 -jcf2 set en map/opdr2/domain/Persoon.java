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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((geboorteDatum == null) ? 0 : geboorteDatum.hashCode());
		result = prime * result + ((naam == null) ? 0 : naam.hashCode());
		result = prime * result + ((voornaam == null) ? 0 : voornaam.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
		return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persoon other = (Persoon) obj;
		if (geboorteDatum == null) {
			if (other.geboorteDatum != null)
				return false;
		} else if (!geboorteDatum.equals(other.geboorteDatum))
			return false;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equals(other.naam))
			return false;
		if (voornaam == null) {
			if (other.voornaam != null)
				return false;
		} else if (!voornaam.equals(other.voornaam))
			return false;
		return true;
	}

	@Override
	public int compareTo(Persoon o) {
		if (o == null) return 1;
		int i = this.getGeboorteDatum().compareTo(o.getGeboorteDatum());
		if (i != 0) return i;
		else {
			i = this.getNaam().compareTo(o.getNaam());
			if (i != 0) return i;
			else return this.getVoornaam().compareTo(o.getVoornaam());
		}
	}
}
