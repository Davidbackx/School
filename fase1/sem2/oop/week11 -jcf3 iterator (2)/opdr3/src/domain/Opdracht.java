package domain;

import java.util.Objects;

public class Opdracht  {
    private String vraag;
    private String antwoord;    
    private String categorie;
               
    public Opdracht(String vraag, String antwoord,String categorie){
    	this.vraag = vraag;
        this.antwoord = antwoord;
        this.categorie = categorie;        
    }
    
    public String getVraag() {
        return vraag;
    }

    public String getAntwoord() {
        return antwoord;
    }
   
    public String getCategorie() {
        return categorie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Opdracht opdracht = (Opdracht) o;
        return 
                Objects.equals(vraag, opdracht.vraag) &&
                Objects.equals(antwoord, opdracht.antwoord) &&               
                Objects.equals(categorie, opdracht.categorie);                
    }

    @Override
    public String toString() {
        String dezeOpdracht = "";              
        dezeOpdracht += "vraag: " + getVraag() + "\n";        
        dezeOpdracht += "antwoord: " + getAntwoord() + "\n";
        dezeOpdracht += "categorie: " + getCategorie() + "\n";
        dezeOpdracht += "---------------------------------------------";
        return dezeOpdracht;
    }    

    public boolean isJuisteAntwoord(String antwoord) {
        return antwoord != null
               && (!antwoord.trim().isEmpty())
               && antwoord.equals(this.getAntwoord());
    }
}
