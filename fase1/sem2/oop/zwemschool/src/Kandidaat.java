import java.time.LocalDate;
import java.time.LocalDateTime;

public class Kandidaat extends Persoon {
    private LocalDateTime aanmelding;
    private boolean inNiveaugroep;


    public Kandidaat(String naam, LocalDate gebDatum) {
        super(naam, gebDatum);
        inNiveaugroep = false;
        aanmelding = LocalDateTime.now();
    }

    public LocalDateTime getAanmelding() {
        return aanmelding;
    }

    public boolean getInNiveaugroep () {
        return inNiveaugroep;
    }

    public void setInNiveaugroep(boolean inNiveaugroep) {
        this.inNiveaugroep = inNiveaugroep;
    }
}
