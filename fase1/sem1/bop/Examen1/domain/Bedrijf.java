import java.util.ArrayList;

public class Bedrijf {
    private Double[] tarieven;
    private ArrayList<Chauffeur> chauffeurs;

    public  Bedrijf (Double[] tarieven){
        for (double d : tarieven){
            if (d < 0) throw new IllegalArgumentException();
        }
        if (tarieven[0] <= tarieven[1] || tarieven[1] <= tarieven[2]) throw new IllegalArgumentException();
        this.tarieven = tarieven;
        this.chauffeurs = new ArrayList<>();
    }

    public void voegChauffeurToe (Chauffeur chauffeur){
        chauffeurs.add(chauffeur);
        chauffeur.setTarieven(tarieven);
    }

    public ArrayList<Chauffeur> geefChauffeursKlaarVoorVolgendeRit () {
        ArrayList<Chauffeur> lijst = new ArrayList<>();
        for (Chauffeur c : chauffeurs){
            if (c.klaarVoorVolgendeRit()) lijst.add(c);
        }
        return lijst;
    }


    public String geefTicket(String naam){
        String uit = "Tarieven = [" + tarieven[0] + ", " + tarieven[1] + ", " + tarieven[2] + "]\n";
        boolean gevonden = false;
        for (int i = 0 ; i < this.chauffeurs.size() && !gevonden; i++){
            if (this.chauffeurs.get(i).getNaam().equals(naam)){
                uit+= this.chauffeurs.get(i).toString();
                gevonden = true;
            }
        }
        if (!gevonden) throw new IllegalArgumentException("Er is geen chauffeur met naam " + naam);
        return uit;
    }
}
