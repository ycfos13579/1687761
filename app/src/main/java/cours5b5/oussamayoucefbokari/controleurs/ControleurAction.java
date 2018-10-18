package cours5b5.oussamayoucefbokari.controleurs;

import android.util.Log;

import java.util.HashMap;
import java.util.LinkedHashSet;
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
        fileAttenteExecution = new LinkedHashSet<>();
        actions = new HashMap<>();
        for (GCommande commande: GCommande.values()) {
            actions.put(commande, new Action());
        }

    }

    public static Action demanderAction(GCommande commande){

        return actions.get(commande);
    }
    public static void fournirAction(Fournisseur fournisseur, GCommande commande, ListenerFournisseur listenerFournisseur){
        enregistrerFournisseur(fournisseur, commande, listenerFournisseur);
        executerActionExecutables();
    }
    static void executerDesQuePossible(Action action){
        Log.d("atelier07", "ControleurAction.executerDesQuePossible");
        ajouterActionEnFileDAttente(action);
        executerActionExecutables();

    }

    private static void executerActionExecutables(){

        Log.d("atelier07", "ControleurAction.executerActionsExecutables");
        for (Action action : fileAttenteExecution) {
            if (siActionExecutable(action)){
                fileAttenteExecution.remove(action);
                executerMaintenant(action);
                lancerObservationSiApplicable(action);
            }
        }
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
        Log.d("atelier07", "ControleurAction.executerMaintenant");
        action.listenerFournisseur.executer(action.args);
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

        fileAttenteExecution.add(action.cloner());
    }
}
