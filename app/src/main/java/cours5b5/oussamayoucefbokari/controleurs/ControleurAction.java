package cours5b5.oussamayoucefbokari.controleurs;

import java.util.Map;
import java.util.Set;

import cours5b5.oussamayoucefbokari.controleurs.interfaces.Fournisseur;
import cours5b5.oussamayoucefbokari.controleurs.interfaces.ListenerFournisseur;
import cours5b5.oussamayoucefbokari.global.GCommande;

public class ControleurAction {

    private static Map<GCommande, Action> actions;
    private static Set<Action> fileAttenteExecution;

    static {

    }

    public static Action demanderAction(GCommande commande){

        return null;
    }
    public static void fournirAction(Fournisseur fournisseur, GCommande commande, ListenerFournisseur listenerFournisseur){

    }
    static void executerDesQuePossible(Action action){

    }

    private static void executerActionExecutables(){

    }

    static boolean siActionExecutable(Action action){

        return false;
    }
    private static void lancerObservationSiApplicable(Action action){

    }

    private static synchronized void executerMaintenant(Action action){

        /*
         * BONUS: à quoi sert le synchronized?
         *
         */
    }



    private static void enregistrerFournisseur(Fournisseur fournisseur, GCommande commande, ListenerFournisseur listenerFournisseur){

    }

    private static void ajouterActionEnFileDAttente(Action action){

    }
}
