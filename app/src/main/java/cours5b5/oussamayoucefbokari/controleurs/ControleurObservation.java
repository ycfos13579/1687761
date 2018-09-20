package cours5b5.oussamayoucefbokari.controleurs;

import java.util.Map;

import cours5b5.oussamayoucefbokari.controleurs.interfaces.ListenerFournisseur;
import cours5b5.oussamayoucefbokari.controleurs.interfaces.ListenerObservateur;
import cours5b5.oussamayoucefbokari.modeles.Modele;

public class ControleurObservation {


    private static Map<Modele, ListenerObservateur> observations;

    static {

    }


    public static void observerModele(String nomModele, final ListenerObservateur listenerObservateur){

        /*
         *   - on enregistre le listener dans le Map observations
         *   - on lance l'observation une première fois quand on reçoit le listener
         *
         *   Note: pour l'instant il y a un seul modèle, le nomModele est ignoré (FIXME atelier07!)
         *
         *   BONUS: pourquoi le modèle est identifié par son nom? (et pas son objet comme dans le Map?)
         *
         */
    }
    public static void lancerObservation(Modele modele){
    /*
     * sera appelé par le ControleurAction après une action!
     *
     */
    }
}



