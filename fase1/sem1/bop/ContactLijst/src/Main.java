public class App {
    public static void main(String[] args) {
        Contact contact1 = new Contact("veronique@hotmail.com",false,455);
        Contact contact2 = new Contact("tommeke@hotmail.com",true,13);
        Contact contact3 = new Contact("ansjovis@hotmail.com",false,55);

        Contactenlijst lijst1 = new Contactenlijst("Lijst 1", contact1, contact2, contact3);


        System.out.println("Contactenlijst = " + lijst1.getNaam() + "\n" +
                "-" + contact1.getInfo() + "\n" + "-" + contact2.getInfo() + "\n" + "-" + contact3.getInfo());

    }
}
