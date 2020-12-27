package domain;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Deze klasse stelt een adresboek voor.
 */
public class Adresboek {

	private Set<Contact> contacten;
	

	/**
	 * Constructor voor het leeg adresboek.
	 */
	public Adresboek() {
		this(new LinkedHashSet<Contact>());
	}
	
	/**
	 * Constructor voor een adresboek met gegeven contacten.
	 * 
	 * @param contacten De contacten voor het adresboek
	 */
	public Adresboek(Set<Contact> contacten) {
		this.contacten = contacten;
	}

	/**
	 * Retourneert de contacten het het adresboek.
	 * 
	 * @return De contacten van het adresboek
	 */
	private Set<Contact> getContacten() {
		return contacten;
	}


	/**
	 * Geeft een adresboek-object terug, met daarin de gemeenschappelijke contacten van het adresboek, vergeleken
	 * met het adresboek dat als parameter meegegeven wordt.
	 * 
	 * @param teVergelijken Het adresboek waarmee vergeleken wordt.
	 * @return Het adresboek met gemeenschappelijke contacten.
	 */
	public Adresboek gemeenschappelijkeContacten(Adresboek teVergelijken){
		//TODO Vul de ontbrekende code in
		Set<Contact> contacten = new TreeSet<Contact>(this.getContacten());
		contacten.retainAll(teVergelijken.getContacten());
		return new Adresboek(contacten);
	}
	
	/**
	 * Geeft een adresboek-object terug, waarin alle vrienden van het huidige adresboek en het meegegeven adresboek staan.
	 * Er staan geen dubbels in.
	 * 
	 * @param teVergelijken Het adresboek waarmee vergeleken wordt.
	 * @return Het adresboek waarin alle contacten van de samengevoegde adresboeken staan, zonder dubbels.
	 */
	public Adresboek gezamelijkeContacten(Adresboek teVergelijken) {
		//TODO Vul de ontbrekende code in
		Set<Contact> contacten = new TreeSet<Contact>(this.getContacten());
		contacten.addAll(teVergelijken.getContacten());
		return new Adresboek(contacten);
	}
	
	/**
	 * Geeft een adresboek-object terug, waarin alle vrienden van het huidige adresboek 
	 * die niet voorkomen in het meegegeven adresboek.
	 * 
	 * @param teVergelijken Het adresboek waarmee vergeleken wordt.
	 * @return Het adresboek waarin de contacten staan die dit adresboek wel heeft het het meegegeven adresboek niet.
	  */
	public Adresboek verschillendeContacten (Adresboek teVergelijken){
		//TODO Vul de ontbrekende code in
		Set <Contact> contacten = new TreeSet<Contact>(this.getContacten());
		contacten.removeAll(teVergelijken.getContacten());
		return new Adresboek(contacten);
	}
	

	/**
	 * Voegt een contact toe aan het adresboek
	 * 
	 * @param contact Het contact dat toegevoegd dient te worden.
	 * @return true wanneer het contact nog niet aanwezig is in het adresboek
	 */
	public boolean voegToe(Contact contact) {
		//TODO Vul de ontbrekende code in
		if (this.contacten.contains(contact)) return false;
		getContacten().add(contact);
		return true;
	}
	
	/**
	 * Verwijder alle contacten uit het adresboek met gegeven achternaam. Dit contact bevat de meegegegeven achternaam, voornaam en telefoonnummer.
	 * @param achternaam De achternaam van het contacten die moeten verwijderd worden uit het adresboek.
	 * @return aantal verwijderde contacten

	 */
	public int verwijder (String achternaam){
		//TODO Vul de ontbrekende code in
		Iterator<Contact> contactIterator = getContacten().iterator();
		int aantal = 0;
		while (contactIterator.hasNext()) {
			Contact next = contactIterator.next();
			if (next.getAchternaam().equals(achternaam)){
				contactIterator.remove();
				aantal++;
			}
		}
		return aantal;
	}
	
	/**
	 * toString
	 */
	@Override
	public String toString(){
		//TODO Vul de ontbrekende code in
		Iterator<Contact> it = getContacten().iterator();
		String output = "Aantal contracten: " + getContacten().size() + "\n";
		while (it.hasNext()) {
			Contact next = it.next();
			output += next.toString() + "\n";
		}
		return output;
	}	
}