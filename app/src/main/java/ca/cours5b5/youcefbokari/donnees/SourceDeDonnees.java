package ca.cours5b5.youcefbokari.donnees;

import java.util.Map;


public abstract class SourceDeDonnees {

    public abstract Map<String, Object> chargerModele(final String cheminSauvegarde);

    public abstract void sauvegarderModele(final String cheminSauvegarde, final Map<String, Object> objetJson);

    public void detruireSauvegarde(String cheminSauvegarde){}

    protected String getNomModele(String cheminSauvegarde){

        String chaine = cheminSauvegarde;
        String [] splitChaine = chaine.split("/");
        String nomModele = splitChaine[0];
        //String chaineId = splitChaine[1];

        return nomModele;
    }

}
