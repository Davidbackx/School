package domain.model;

public class Student {
	private String naam;
	private String voornaam;
	private int leeftijd;
	private String studierichting;
	
	public Student() {
	}

	public Student(String naam, String voornaam, int leeftijd, String studierichting) {
		setNaam(naam);
		setVoornaam(voornaam);
		setLeeftijd(leeftijd);
		setStudierichting(studierichting);
	}
	
	
	public String getNaam() {

		return naam;
	}
	public void setNaam(String naam) {
		if (naam.isEmpty() || naam == null) throw new IllegalArgumentException("Invalide naam");
		this.naam = naam;
	}
	public String getVoornaam() {

		return voornaam;
	}
	public void setVoornaam(String voornaam) {
		if (voornaam.isEmpty() || voornaam == null) throw new IllegalArgumentException("Invalide voornaam");
		this.voornaam = voornaam;
	}
	public int getLeeftijd() {
		return leeftijd;
	}
	public void setLeeftijd(int leeftijd) {
		if (leeftijd < 0 || leeftijd > 99) throw new IllegalArgumentException("Invalide leeftijd");
		this.leeftijd = leeftijd;
	}
	public String getStudierichting() {
		return studierichting;
	}
	public void setStudierichting(String studierichting) {
		if (studierichting.isEmpty() || studierichting == null) throw new IllegalArgumentException("Invalide studierichting");
		this.studierichting = studierichting;
	}
	
	public String format() {
		return getNaam()+" "+getVoornaam()+" ("+getLeeftijd()+" jaar): "+getStudierichting();
	}
	
	public boolean heeftNaam(String naam,String voornaam) {
		return naam.equals(this.getNaam()) && voornaam.equals(this.getVoornaam());
	}
	
}
