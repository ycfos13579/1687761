package cours5b5.oussamayoucefbokari.modeles;

import java.util.List;
import java.util.Map;

import cours5b5.oussamayoucefbokari.exceptions.ErreurDeSerialisation;
import cours5b5.oussamayoucefbokari.global.GCouleur;

public class MGrille extends Modele {


    private List<MColonne> colonnes;

    public MGrille(int largeur){

    }

    private void initialiserColonnes(int largeur){

    }

    public List<MColonne> getColonnes(){

        return null;
    }

    public void placerJeton(int colonne, GCouleur couleur){

    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objectJson) throws ErreurDeSerialisation {

    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurDeSerialisation {
        return null;
    }
}
