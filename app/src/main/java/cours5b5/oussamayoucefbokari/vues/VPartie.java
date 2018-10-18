package cours5b5.oussamayoucefbokari.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import cours5b5.oussamayoucefbokari.R;
import cours5b5.oussamayoucefbokari.controleurs.ControleurObservation;
import cours5b5.oussamayoucefbokari.controleurs.interfaces.ListenerObservateur;
import cours5b5.oussamayoucefbokari.modeles.MParametres;
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
        this.initialiser();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void initialiser(){
        this.grille = findViewById(R.id.vue_grille);
        this.observerPartie();
    }
    private void observerPartie(){
        Log.d("atelier07", "VPartie$1.observerPartie");

        ControleurObservation.observerModele(MPartie.class.getSimpleName(), new ListenerObservateur() {
            @Override
            public void reagirNouveauModele(Modele modele) {

                MPartie partie = getPartie(modele);

                initialiserGrille(partie);

            }

            @Override
            public void reagirChangementAuModele(Modele modele) {
                Log.d("atelier07", "VPartie$1.reagirChangementAuModele");
                miseAJourGrille(getPartie(modele));

            }
        });

    }

    private void miseAJourGrille(MPartie partie){
        this.grille.afficherJetons(partie.getGrille());


    }

    private MPartie getPartie(Modele modele){

        return (MPartie) modele;
    }
    private void initialiserGrille(MPartie partie){
        this.grille.creerGrille(partie.getParametres().getHauteur(), partie.getParametres().getLargeur());
    }
}
