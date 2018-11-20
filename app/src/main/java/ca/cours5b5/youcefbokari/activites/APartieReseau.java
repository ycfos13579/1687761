package ca.cours5b5.youcefbokari.activites;

import android.os.Bundle;

import ca.cours5b5.youcefbokari.R;
import ca.cours5b5.youcefbokari.controleurs.ControleurModeles;
import ca.cours5b5.youcefbokari.controleurs.interfaces.Fournisseur;
import ca.cours5b5.youcefbokari.modeles.MPartieReseau;
import ca.cours5b5.youcefbokari.controleurs.ControleurPartieReseau;

public class APartieReseau extends Activite implements Fournisseur{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_partie_reseau);

    }
    @Override
    protected void onResume()
    {
        super.onResume();

    }

    @Override
    protected void onPause()
    {
        super.onPause();
        ControleurPartieReseau.getInstance().detruireSauvegardeServeur();
        ControleurPartieReseau.getInstance().deconnecterDuServeur();


    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();

        ControleurModeles.detruireModele(MPartieReseau.class.getSimpleName());

    }
}
