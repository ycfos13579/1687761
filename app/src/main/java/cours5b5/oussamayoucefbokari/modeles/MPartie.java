package cours5b5.oussamayoucefbokari.modeles;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cours5b5.oussamayoucefbokari.controleurs.ControleurAction;
import cours5b5.oussamayoucefbokari.controleurs.interfaces.Fournisseur;
import cours5b5.oussamayoucefbokari.controleurs.interfaces.ListenerFournisseur;
import cours5b5.oussamayoucefbokari.global.GCommande;
import cours5b5.oussamayoucefbokari.global.GCouleur;
import cours5b5.oussamayoucefbokari.serialisation.AttributSerialisable;

public class MPartie extends Modele implements Fournisseur{

    @AttributSerialisable
    public MParametresPartie parametres;
    private final String __parametres = "parametres";
    private MGrille grille;
    private GCouleur couleurCourante;
    public List<Integer> coups;

    private final String __coups = "coups";

    public MPartie(MParametresPartie parametres){

        this.parametres = parametres;
        this.coups = new ArrayList<>();

        Log.d("atelier08","construiction de mpartie");
        this.grille = new MGrille(parametres.getLargeur());
        fournirActionPlacerJeton();
        initialiserCouleurCourante();
    }

    public MParametresPartie getParametres() {

        return this.parametres;
    }

    public MGrille getGrille() {
        return this.grille;
    }

    private void initialiserCouleurCourante() {
        couleurCourante = GCouleur.JAUNE;
    }

    private void fournirActionPlacerJeton(){
        Log.d("atelier07", "MPartie.fournirActionPlacerJeton");

        ControleurAction.fournirAction(this, GCommande.JOUER_COUP_ICI, new ListenerFournisseur() {
            @Override
            public void executer(Object... args) {
                Log.d("atelier07", "jouerCoup");
                jouerCoup((int) args[0]);
            }
        });
    }

    protected void jouerCoup(int colonne){
        Log.d("atelier07", "Code qui insère un jeton dans la grille.");
        this.coups.add(colonne);
        this.grille.placerJeton(colonne, couleurCourante);
        prochaineCouleurCourante();
    }

    private void prochaineCouleurCourante(){
        if (couleurCourante == GCouleur.ROUGE) {
            couleurCourante = GCouleur.JAUNE;
        } else if (couleurCourante == GCouleur.JAUNE) {
            couleurCourante = GCouleur.ROUGE;
        }
    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objectJson) {

    }

    @Override
    public Map<String, Object> enObjetJson() {
        return null;
    }



}
