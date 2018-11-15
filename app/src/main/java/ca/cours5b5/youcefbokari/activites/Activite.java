package ca.cours5b5.youcefbokari.activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ca.cours5b5.youcefbokari.controleurs.ControleurModeles;
import ca.cours5b5.youcefbokari.donnees.Disque;
import ca.cours5b5.youcefbokari.donnees.SauvegardeTemporaire;
import ca.cours5b5.youcefbokari.donnees.Serveur;
import ca.cours5b5.youcefbokari.modeles.MParametres;


public abstract class Activite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initialiserControleurModeles(savedInstanceState);
        initialiserApplication();

    }

    protected void initialiserControleurModeles(Bundle savedInstanceState) {

        ControleurModeles.setSequenceDeChargement(
                new SauvegardeTemporaire(savedInstanceState),
                Serveur.getInstance(),
                Disque.getInstance());


        
    }

    protected void initialiserApplication(){

        Disque.getInstance().setRepertoireRacine(getFilesDir());

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        /*ControleurModeles.sauvegarderModeleDansCetteSource(MParametres.class.getSimpleName(),
                new SauvegardeTemporaire(outState));*/
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

    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();

    }

}
