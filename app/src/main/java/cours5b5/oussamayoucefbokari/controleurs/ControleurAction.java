package cours5b5.oussamayoucefbokari.controleurs;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import cours5b5.oussamayoucefbokari.controleurs.interfaces.Fournisseur;
import cours5b5.oussamayoucefbokari.controleurs.interfaces.ListenerFournisseur;
import cours5b5.oussamayoucefbokari.controleurs.interfaces.ListenerObservateur;
import cours5b5.oussamayoucefbokari.global.GCommande;
import cours5b5.oussamayoucefbokari.modeles.MParametres;
import cours5b5.oussamayoucefbokari.modeles.Modele;

public class ControleurAction {

    private static Map<GCommande, Action> actions;
    private static Set<Action> fileAttenteExecution;

    static {
        Action actionHauteur = ControleurAction.demanderAction(GCommande.CHOISIR_HAUTEUR);
        Action actionLargeur = ControleurAction.demanderAction(GCommande.CHOISIR_LARGEUR);
        Action actionPourGagner = ControleurAction.demanderAction(GCommande.CHOISIR_POUR_GAGNER);
        actions = new HashMap<>();

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
        if (action.listenerFournisseur != null){
            //action.executerDesQuePossible();
            return true;
        }else{
            return false;
        }
    }



    private static synchronized void executerMaintenant(Action action){

        action.listenerFournisseur.executer();
    }

    private static void lancerObservationSiApplicable(Action action){
        if(Modele.class.isInstance(action.fournisseur)){
            ControleurObservation.lancerObservation(((Modele) action.fournisseur));

        }
    }



    private static void enregistrerFournisseur(Fournisseur fournisseur, GCommande commande, ListenerFournisseur listenerFournisseur){

        actions.get(commande).fournisseur = fournisseur;
        actions.get(commande).listenerFournisseur = listenerFournisseur;

    }

    private static void ajouterActionEnFileDAttente(Action action){
        action.cloner();
    }
}
