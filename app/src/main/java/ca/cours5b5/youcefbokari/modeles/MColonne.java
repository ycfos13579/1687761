package ca.cours5b5.youcefbokari.modeles;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ca.cours5b5.youcefbokari.exceptions.ErreurSerialisation;
import ca.cours5b5.youcefbokari.global.GCouleur;

public class MColonne extends Modele {

    private List<GCouleur> jetons;

    public MColonne(){

        jetons = new ArrayList<>();

    }

    public List<GCouleur> getJetons() {
        return jetons;
    }

    public void placerJeton(GCouleur couleur) {

        jetons.add(couleur);

    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation {

        throw new UnsupportedOperationException();

    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation {

        throw new UnsupportedOperationException();

    }

    public int nombreDeJetons() {
        return jetons.size();
    }

}
