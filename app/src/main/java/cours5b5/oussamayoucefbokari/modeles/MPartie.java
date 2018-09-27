package cours5b5.oussamayoucefbokari.modeles;

import java.util.Map;

import cours5b5.oussamayoucefbokari.serialisation.AttributSerialisable;

public class MPartie extends Modele {

    @AttributSerialisable
    public MParametresPartie parametres;
    private final String __parametres = "parametres";

    public MPartie(MParametresPartie parametres){
        this.parametres = parametres;
    }

    public MParametresPartie getParametres() {
        return parametres;
    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objectJson) {

    }

    @Override
    public Map<String, Object> enObjetJson() {
        return null;
    }
}
