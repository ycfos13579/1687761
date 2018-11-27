package ca.cours5b5.oussamayoucefbokari.activites;


import android.os.Bundle;

import ca.cours5b5.oussamayoucefbokari.R;
import ca.cours5b5.oussamayoucefbokari.controleurs.ControleurAction;
import ca.cours5b5.oussamayoucefbokari.controleurs.ControleurModeles;
import ca.cours5b5.oussamayoucefbokari.controleurs.interfaces.Fournisseur;
import ca.cours5b5.oussamayoucefbokari.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.oussamayoucefbokari.global.GCommande;
import ca.cours5b5.oussamayoucefbokari.modeles.MParametres;
import ca.cours5b5.oussamayoucefbokari.modeles.MPartie;


public class AParametres extends Activite implements Fournisseur{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);

        fournirActions();

    }


    private void fournirActions() {

        ControleurAction.fournirAction(this,
                GCommande.EFFACER_PARTIE_COURANTE,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        ControleurModeles.detruireModele(MPartie.class.getSimpleName());

                    }
                });
    }

    @Override
    protected void onPause() {
        super.onPause();

        ControleurModeles.sauvegarderModele(MParametres.class.getSimpleName());

    }


}
