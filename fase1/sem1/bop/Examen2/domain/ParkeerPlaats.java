public class ParkeerPlaats {
    private String code;
    private boolean isVrij;

    public ParkeerPlaats (String code) {
        if (code.length() < 3 || code == null) throw new IllegalArgumentException();
        this.code = code;
        isVrij = true;
    }

    public boolean beschikbaar () {
        return  isVrij;
    }

    /**
     * Geef code
     * @return vb: "-3*20" : String
     */
    public String geefCode() {
        return code;
    }

    public void zetBezet () {
        isVrij = false;
    }

    public void zetBeschikbaar () {
        isVrij = true;
    }

    /**
     * Geef het verdieping nummer van de plek.
     * @return
     */
    public int geefVerdiepingNummer () {
        String[] regexCode = code.split("\\*");
        return Integer.parseInt(regexCode[0]);
    }


    /**
     * Geef string vorm van Parkeerplaats.
     * @return Code en bezet of beschikbaar : String
     */
    public String geefStringVorm () {
        return "Parkeerplaats met code " + code + (beschikbaar() ? " is beschikbaar." : " is bezet." );
    }
}
