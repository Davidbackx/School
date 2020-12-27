public class Contactenlijst {
    private String naam;
    private Contact contact1, contact2, contact3;


    public Contactenlijst(String naamContactenLijst, Contact c1, Contact c2, Contact c3) {
        setNaam(naamContactenLijst);
        contact1 = c1;
        contact2 = c2;
        contact3 = c3;

    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public String berekenMeesteMails () {
        int contact = Math.max(Math.max(contact1.getAantalMails(), contact2.getAantalMails()), contact3.getAantalMails());
        if (contact == contact1.getAantalMails()) return contact1.getEmail();
        if (contact ==  contact2.getAantalMails()) return contact2.getEmail();
        if (contact ==  contact3.getAantalMails()) return contact3.getEmail();
        return null;
    }
}
