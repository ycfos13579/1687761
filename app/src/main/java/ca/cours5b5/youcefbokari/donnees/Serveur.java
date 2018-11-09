package ca.cours5b5.youcefbokari.donnees;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.util.Map;

import ca.cours5b5.youcefbokari.exceptions.ErreurSerialisation;
import ca.cours5b5.youcefbokari.modeles.Modele;

import static java.lang.System.err;

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
    public void chargerModele(final String cheminSauvegarde, final ListenerChargement listenerChargement){


        String chemin = cheminSauvegarde;
        DatabaseReference noeud = FirebaseDatabase.getInstance().getReference(chemin);
        noeud.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    Map<String, Object> objectJson = (Map<String, Object>) dataSnapshot.getValue();

                    listenerChargement.reagirSucces(objectJson);
                }else {
                    listenerChargement.reagirErreur(new ErreurSerialisation("Erreur de chargement"));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                listenerChargement.reagirErreur(databaseError.toException());

            }
        });


    }

    @Override
    public void detruireSauvegarde(String cheminSauvegarde){
        String chemin = cheminSauvegarde;
        DatabaseReference noeud = FirebaseDatabase.getInstance().getReference(chemin);
        noeud.removeValue();
    }

}