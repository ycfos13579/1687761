package ca.cours5b5.youcefbokari.donnees;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;

public class Serveur extends SourceDeDonnees{

    private Serveur(){

    }

    public static Serveur getInstance(){

        return new Serveur();
    }

    @Override
    public void sauvegarderModele(String cheminSauvegarde, Map<String, Object> objectJson){

        String chemin = cheminSauvegarde;
        DatabaseReference noeud = FirebaseDatabase.getInstance().getReference(chemin);
        noeud.setValue(objectJson);
    }

    @Override
    public Map<String, Object> chargerModele(String cheminSauvegarde){

        return null;
    }

    @Override
    public void detruireSauvegarde(String cheminSauvegarde){
        String chemin = cheminSauvegarde;
        DatabaseReference noeud = FirebaseDatabase.getInstance().getReference(chemin);
        noeud.removeValue();
    }

}
