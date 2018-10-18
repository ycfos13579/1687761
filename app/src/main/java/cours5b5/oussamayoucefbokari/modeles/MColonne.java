package cours5b5.oussamayoucefbokari.modeles;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cours5b5.oussamayoucefbokari.exceptions.ErreurDeSerialisation;
import cours5b5.oussamayoucefbokari.global.GCouleur;

public class MColonne extends Modele{

    private List<GCouleur> jetons;

    public MColonne(){
        jetons = new ArrayList<>();
    }

    public List<GCouleur> getJetons(){

        return jetons;
    }

    public void placerJeton(GCouleur couleur){
        jetons.add(couleur);
    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objectJson) throws ErreurDeSerialisation{

    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurDeSerialisation{
        return null;
    }
}