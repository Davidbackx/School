public class TestClass {
    private String naam;

    public TestClass (String n) {
        setNaam(n);
    }

    public void setNaam(String naam) {
        if (naam == null)throw new IllegalArgumentException();
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }
}
