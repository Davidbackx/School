import java.time.LocalDate;

public class Persoon {
    private String naam;
    private LocalDate gebDatum;

    public Persoon(String naam, LocalDate gebDatum) {
        if (naam == null || gebDatum == null) throw new DomainException();
        this.naam = naam;
        this.gebDatum = gebDatum;
    }

    public String getNaam() {
        return naam;
    }

    public LocalDate getGebDatum() {
        return gebDatum;
    }

    public int leeftijd () {
        int jaar = LocalDate.now().getYear() - this.gebDatum.getYear();
        LocalDate verjaardag = LocalDate.of(LocalDate.now().getYear(), this.gebDatum.getMonth(), this.gebDatum.getDayOfMonth());
        if (verjaardag.isAfter(LocalDate.now())) jaar--;
        return jaar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persoon persoon = (Persoon) o;
        return naam.equals(persoon.naam) &&
                gebDatum.equals(persoon.gebDatum);
    }
}
