package ca.cours5b5.youcefbokari.donnees;

import android.os.Bundle;

import java.util.Map;


import ca.cours5b5.youcefbokari.exceptions.ErreurModele;
import ca.cours5b5.youcefbokari.modeles.Modele;
import ca.cours5b5.youcefbokari.serialisation.Jsonification;

public class SauvegardeTemporaire extends SourceDeDonnees {

    private Bundle bundle;

    public SauvegardeTemporaire(Bundle bundle){
        this.bundle = bundle;
    }

    @Override
    public void chargerModele(String cheminSauvegarde, final ListenerChargement listenerChargement) {

        if(bundle != null && bundle.containsKey(getCle(cheminSauvegarde))){

            String json = bundle.getString(getCle(cheminSauvegarde));

            Map<String, Object> objetJson = Jsonification.aPartirChaineJson(json);

            listenerChargement.reagirSucces(objetJson);

        }else{

            listenerChargement.reagirErreur(new ErreurModele("le chargement a partir de la sauveTemp a échoué"));

        }
    }

    @Override
    public void sauvegarderModele(String cheminSauvegarde, Map<String, Object> objetJson) {
        if(bundle != null){

            String json = Jsonification.enChaineJson(objetJson);
            bundle.putString(getCle(cheminSauvegarde), json);

        }
    }

    private String getCle(String cheminSauvegarde){

        return getNomModele(cheminSauvegarde);
    }

}