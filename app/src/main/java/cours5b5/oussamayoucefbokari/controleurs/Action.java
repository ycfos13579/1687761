package cours5b5.oussamayoucefbokari.controleurs;

import android.util.Log;

import cours5b5.oussamayoucefbokari.controleurs.interfaces.Fournisseur;
import cours5b5.oussamayoucefbokari.controleurs.interfaces.ListenerFournisseur;

public class Action {

    Fournisseur fournisseur;

    ListenerFournisseur listenerFournisseur;

    Object[] args;

    public void setArguments(Object... args){
        this.args = args;
    }

    public void executerDesQuePossible(){
        Log.d("atelier07", "Action.executerDesQuePossible");
        ControleurAction.executerDesQuePossible(this);

    }
    Action cloner(){
        Action actionClone = new Action();

        if (args != null){
            actionClone.args  = args.clone();
        }

        actionClone.fournisseur = fournisseur;
        actionClone.listenerFournisseur = listenerFournisseur;

        return actionClone;
    }
}
