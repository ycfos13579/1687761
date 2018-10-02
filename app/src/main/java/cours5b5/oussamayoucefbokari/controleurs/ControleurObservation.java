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

    private static MPartie partie = new MPartie(new MParametresPartie());

    static {

    }


    public static void observerModele(String nomModele, final ListenerObservateur listenerObservateur){

        /*
         *   - on enregistre le listener dans le Map observations
         *   - on lance l'observation une première fois quand on reçoit le listener
         *
         */

        observations.put(MParametres.instance, listenerObservateur);

        partie = new MPartie(MParametres.instance.getParametresPartie().cloner());

        listenerObservateur.reagirNouveauModele(partie);





    }





    }




