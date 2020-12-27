package domain;

import java.util.*;

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
		Set<Contact> contacts = new TreeSet<>(contacten);
		contacts.retainAll(teVergelijken.getContacten());
		return new Adresboek(contacts);
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
		Set<Contact> contacts = new TreeSet<>(contacten);
		contacts.addAll(teVergelijken.getContacten());
		return new Adresboek(contacts);
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
		Set<Contact> contacts = new TreeSet<>(contacten);
		contacts.removeAll(teVergelijken.getContacten());
		return new Adresboek(contacts);
	}


	/**
	 * Voegt een contact toe aan het adresboek
	 *
	 * @param contact Het contact dat toegevoegd dient te worden.
	 * @return true wanneer het contact nog niet aanwezig is in het adresboek
	 */
	public boolean voegToe(Contact contact) {
		//TODO Vul de ontbrekende code in
		if (contact == null || contacten.contains(contact)) return false;
		contacten.add(contact);
		return true;
	}

	/**
	 * Verwijder alle contacten uit het adresboek met gegeven achternaam. Dit contact bevat de meegegegeven achternaam, voornaam en telefoonnummer.
	 * @param achternaam De achternaam van het contacten die moeten verwijderd worden uit het adresboek.
	 * @return aantal verwijderde contacten

	 */
	public int verwijder (String achternaam){
		//TODO Vul de ontbrekende code in
		int aantal = 0;
		Iterator it = contacten.iterator();
		while (it.hasNext()) {
			Contact next = (Contact) it.next();
			if (next.getAchternaam().equals(achternaam)) {
				aantal++;
				it.remove();
			}
		}
		return aantal;
	}

	/**
	 * toString
	 */
	@Override
	public String toString(){
		String output ="";
		output+="Aantal contacten:"+getContacten().size()+"\n";
		Iterator<Contact>it = getContacten().iterator();
		while (it.hasNext()){
			Contact contact = it.next();
			output+=contact.toString()+"\n";
		}
		return output;
	}
}

