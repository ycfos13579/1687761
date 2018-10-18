package cours5b5.oussamayoucefbokari.controleurs;

import java.util.HashMap;
import java.util.Map;

import cours5b5.oussamayoucefbokari.controleurs.interfaces.ListenerFournisseur;
import cours5b5.oussamayoucefbokari.controleurs.interfaces.ListenerObservateur;
import cours5b5.oussamayoucefbokari.modeles.MParametres;
import cours5b5.oussamayoucefbokari.modeles.MParametresPartie;
import cours5b5.oussamayoucefbokari.modeles.MPartie;
import cours5b5.oussamayoucefbokari.modeles.Modele;

public class ControleurObservation {


    private static Map<Modele, ListenerObservateur> observations = new HashMap<>();

    public static MPartie partie;

    static {

    }

    public static void observerModele(String nomModele, final ListenerObservateur listenerObservateur){

        /*
         *   - on enregistre le listener dans le Map observations
         *   - on lance l'observation une première fois quand on reçoit le listener
         *
         */
        if (nomModele.equals(MParametres.class.getSimpleName())){
            observations.put(MParametres.instance, listenerObservateur);
            lancerUneNOuvelleObservation(MParametres.instance);
        }else if (nomModele.equals(MParametresPartie.class.getSimpleName())){

            partie = new MPartie(MParametres.instance.getParametresPartie().cloner());
            observations.put(partie, listenerObservateur);
           //listenerObservateur.reagirNouveauModele(partie);
            lancerUneNOuvelleObservation(partie);
        }
    }

    public static void lancerUneNOuvelleObservation(Modele modele){
        ListenerObservateur listenerObservateur = observations.get(modele);

        if (listenerObservateur != null) {

            listenerObservateur.reagirNouveauModele(modele);
        }
    }

    public static void lancerObservation(Modele modele){


        ListenerObservateur observateur = observations.get(modele);

        if(observateur != null){

            observateur.reagirChangementAuModele(modele);
        }


    }




}




