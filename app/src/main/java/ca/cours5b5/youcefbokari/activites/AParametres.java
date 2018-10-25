package ca.cours5b5.youcefbokari.activites;

import android.os.Bundle;

import ca.cours5b5.youcefbokari.R;
import ca.cours5b5.youcefbokari.controleurs.ControleurModeles;
import ca.cours5b5.youcefbokari.controleurs.interfaces.Fournisseur;
import ca.cours5b5.youcefbokari.modeles.MParametres;

public class AParametres extends Activite implements Fournisseur{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);

    }

    @Override
    protected void onPause() {
        super.onPause();

        ControleurModeles.sauvegarderModele(MParametres.class.getSimpleName());

    }

}
