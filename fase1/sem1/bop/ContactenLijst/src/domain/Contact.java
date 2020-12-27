package domain;

public class Contact {
    private String email;
    private boolean isFavoriet;
    private int aantalEmails;

    public Contact (String email, boolean isFavoriet) {
        if (!email.contains("@") || email == null) throw new IllegalArgumentException();
        this.email = email;
        this.isFavoriet = isFavoriet;
    }

    public void addMails (int x){
        if (x <= 0) throw new IllegalArgumentException();
        aantalEmails += x;
    }

    public void resetMails () {
        aantalEmails = 0;
    }

    public String getEmail() {
        return email;
    }

    public int getAantalEmails() {
        return aantalEmails;
    }

    public boolean isFavoriet() {
        return isFavoriet;
    }
}
