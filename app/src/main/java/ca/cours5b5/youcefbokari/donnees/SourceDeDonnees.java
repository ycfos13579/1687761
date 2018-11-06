package ca.cours5b5.youcefbokari.donnees;

import java.util.Map;


public abstract class SourceDeDonnees {

    public abstract void chargerModele(final String cheminSauvegarde, final ListenerChargement listenerChargement);

    public abstract void sauvegarderModele(final String cheminSauvegarde, final Map<String, Object> objetJson);

    public void detruireSauvegarde(String cheminSauvegarde){}

    protected String getNomModele(String cheminSauvegarde){

        String chaine = cheminSauvegarde;
        String [] splitChaine = chaine.split("/");
        String nomModele = splitChaine[0];

        return nomModele;
    }

}
