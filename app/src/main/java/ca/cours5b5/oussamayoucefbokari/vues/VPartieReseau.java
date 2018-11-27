package ca.cours5b5.oussamayoucefbokari.vues;

import android.content.Context;
import android.util.AttributeSet;

import ca.cours5b5.oussamayoucefbokari.R;
import ca.cours5b5.oussamayoucefbokari.controleurs.ControleurObservation;
import ca.cours5b5.oussamayoucefbokari.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.oussamayoucefbokari.exceptions.ErreurObservation;
import ca.cours5b5.oussamayoucefbokari.modeles.MParametresPartie;
import ca.cours5b5.oussamayoucefbokari.modeles.MPartie;
import ca.cours5b5.oussamayoucefbokari.modeles.MPartieReseau;
import ca.cours5b5.oussamayoucefbokari.modeles.Modele;


public class VPartieReseau extends VPartie {


    private VGrille grille;


    public VPartieReseau(Context context) {
        super(context);
    }

    public VPartieReseau(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VPartieReseau(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected String getNomModele(){
        return MPartieReseau.class.getSimpleName();
    }

}
