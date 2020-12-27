package ui;

import domain.Contact;
import domain.Contactlijst;

public class App {
    public static void main(String[] args) {
        Contactlijst lijst = new Contactlijst("Prive");

        Contact jim = new Contact("Jim@ucll", true);
        jim.addMails(10);
        lijst.addContact(jim);
        lijst.addContact(new Contact("David@hhh", false));
        lijst.addContact(new Contact("Sam@ucll", true));

        System.out.println(lijst.aantalFavorieten());
        System.out.println(lijst.meesteEmails().getEmail());
    }
}
