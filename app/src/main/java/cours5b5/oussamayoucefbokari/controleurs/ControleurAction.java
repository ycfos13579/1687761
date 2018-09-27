package cours5b5.oussamayoucefbokari.controleurs;

import java.util.Map;
import java.util.Set;

import cours5b5.oussamayoucefbokari.controleurs.interfaces.Fournisseur;
import cours5b5.oussamayoucefbokari.controleurs.interfaces.ListenerFournisseur;
import cours5b5.oussamayoucefbokari.global.GCommande;
import cours5b5.oussamayoucefbokari.modeles.MParametres;

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

        Action actionHauteur = ControleurAction.demanderAction(GCommande.CHOISIR_HAUTEUR);

        // Une fois qu'on connais le choix de l'usager
        actionHauteur.setArguments(MParametres.instance.getChoixHauteur());
        actionHauteur.executerDesQuePossible();

        Action actionLargeur = ControleurAction.demanderAction(GCommande.CHOISIR_LARGEUR);

        // Une fois qu'on connais le choix de l'usager
        actionLargeur.setArguments(MParametres.instance.getChoixLargeur());
        actionLargeur.executerDesQuePossible();

        Action actionPourGagner = ControleurAction.demanderAction(GCommande.CHOISIR_POUR_GAGNER);

        // Une fois qu'on connais le choix de l'usager
        actionPourGagner.setArguments(MParametres.instance.getChoixPourGagner());
        actionPourGagner.executerDesQuePossible();
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
