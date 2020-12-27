public class Contact {
    private String email;
    private Boolean favoriet;
    private int aantalMails;

    public Contact(String emailContact, Boolean favorietContact, int aantalMailsContact){
        setEmail(emailContact);
        setFavoriet(favorietContact);
        setAantalMails(aantalMailsContact);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFavoriet(Boolean favoriet) {
        this.favoriet = favoriet;
    }

    public void setAantalMails(int aantalMails) {
        this.aantalMails = aantalMails;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getFavoriet() {
        return favoriet;
    }

    public int getAantalMails() {
        return aantalMails;
    }
    public void verhoogAantalMails(int aantalMailsVerhogenMet) {
        aantalMails += aantalMailsVerhogenMet;
    }

    public void resetAantalMails() {
        aantalMails = 0;
    }

    public String getInfo () {
        if (getFavoriet()==true) {
            return (getEmail() +";" + " aantal verstuurde mails: " +getAantalMails() + ";" +" Favoriet ");
        }
        else {
            return (getEmail() + ";" +" " + "aantal verstuurde mails: " + getAantalMails());
        }
    }
}
