package ca.cours5b5.oussamayoucefbokari.activites;

import android.os.Bundle;

import ca.cours5b5.oussamayoucefbokari.R;
import ca.cours5b5.oussamayoucefbokari.controleurs.ControleurAction;
import ca.cours5b5.oussamayoucefbokari.controleurs.ControleurModeles;
import ca.cours5b5.oussamayoucefbokari.controleurs.interfaces.Fournisseur;
import ca.cours5b5.oussamayoucefbokari.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.oussamayoucefbokari.global.GCommande;
import ca.cours5b5.oussamayoucefbokari.modeles.MPartie;

public class APartie extends Activite implements Fournisseur {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partie);

        fournirActionTerminerPartie();

    }


    private void fournirActionTerminerPartie() {

        ControleurAction.fournirAction(this,
                GCommande.TERMINER_PARTIE,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        quitterCetteActivite();

                    }
                });
    }


    @Override
    protected void onPause() {
        super.onPause();
        sauvegarderPartie();
    }


    protected void sauvegarderPartie(){
        ControleurModeles.sauvegarderModele(MPartie.class.getSimpleName());
    }


}