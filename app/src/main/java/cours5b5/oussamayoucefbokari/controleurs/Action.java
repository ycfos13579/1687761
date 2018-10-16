package cours5b5.oussamayoucefbokari.controleurs;

import cours5b5.oussamayoucefbokari.controleurs.interfaces.Fournisseur;
import cours5b5.oussamayoucefbokari.controleurs.interfaces.ListenerFournisseur;

public class Action {

    Fournisseur fournisseur;

    ListenerFournisseur listenerFournisseur;

    Object[] args;

    public void setArguments(Object... args){

    }

    public void executerDesQuePossible(){

        ControleurAction.executerDesQuePossible(this);

    }
    Action cloner(){
        return null;
    }
}
