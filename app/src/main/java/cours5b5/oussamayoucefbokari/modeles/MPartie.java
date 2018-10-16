package cours5b5.oussamayoucefbokari.modeles;

import java.util.Map;

import cours5b5.oussamayoucefbokari.controleurs.interfaces.Fournisseur;
import cours5b5.oussamayoucefbokari.global.GCouleur;
import cours5b5.oussamayoucefbokari.serialisation.AttributSerialisable;

public class MPartie extends Modele implements Fournisseur{

    @AttributSerialisable
    public MParametresPartie parametres;
    private final String __parametres = "parametres";
    private MGrille grille;
    private GCouleur couleurCourante;

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

    public MGrille getGrille() {
        return grille;
    }

    private void initialiserCouleurCourante(){

    }
    private void fournirActionPlacerJeton(){

    }

    protected void jouerCoup(int colonne){}

    private void prochaineCouleurcourante(){}

}
