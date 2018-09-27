package cours5b5.oussamayoucefbokari.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;

import cours5b5.oussamayoucefbokari.R;
import cours5b5.oussamayoucefbokari.controleurs.ControleurObservation;
import cours5b5.oussamayoucefbokari.controleurs.interfaces.ListenerObservateur;
import cours5b5.oussamayoucefbokari.modeles.MParametresPartie;
import cours5b5.oussamayoucefbokari.modeles.MPartie;
import cours5b5.oussamayoucefbokari.modeles.Modele;

public class VPartie extends Vue {

    private VGrille grille;


    public VPartie(Context context) {
        super(context);
    }

    public VPartie(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VPartie(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        grille = findViewById(R.id.vue_grille);


        ControleurObservation.observerModele(MPartie.class.getSimpleName(), new ListenerObservateur() {
            @Override
            public void reagirNouveauModele(Modele modele) {

                MPartie partie = (MPartie) modele;

                MParametresPartie parametresPartie = partie.getParametres();

                int hauteur = parametresPartie.getHauteur();
                int largeur = parametresPartie.getLargeur();

                grille.creerGrille(hauteur, largeur);




            }

            @Override
            public void reagirChangementAuModele(Modele modele) {

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void initialiser(){

    }
    private void observerPartie(){

    }

    private MPartie getPartie(Modele modele){

        return null;
    }
    private void initialiserGrille(MPartie partie){

    }
}
