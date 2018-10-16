package cours5b5.oussamayoucefbokari.modeles;

import java.util.List;
import java.util.Map;

import cours5b5.oussamayoucefbokari.exceptions.ErreurDeSerialisation;
import cours5b5.oussamayoucefbokari.global.GCouleur;

public class MColonne extends Modele{

    private List<GCouleur> jetons;

    public MColonne(){

    }

    private List<GCouleur> getJetons(){

        return null;
    }

    public void placerJeton(GCouleur couleur){

    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objectJson) throws ErreurDeSerialisation{

    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurDeSerialisation{
        return null;
    }

}
