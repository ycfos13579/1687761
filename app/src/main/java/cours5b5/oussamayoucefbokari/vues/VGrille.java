package cours5b5.oussamayoucefbokari.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

import cours5b5.oussamayoucefbokari.controleurs.Action;
import cours5b5.oussamayoucefbokari.controleurs.ControleurAction;
import cours5b5.oussamayoucefbokari.global.GCommande;
import cours5b5.oussamayoucefbokari.global.GCouleur;
import cours5b5.oussamayoucefbokari.modeles.MColonne;
import cours5b5.oussamayoucefbokari.modeles.MGrille;
import cours5b5.oussamayoucefbokari.modeles.MParametres;

public class VGrille extends GridLayout {

    public VGrille(Context context) {
        super(context);
    }

    public VGrille(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VGrille(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private int nombreRangees;

    private VCase[][] lesCases;

    private class Colonne extends ArrayList<VCase>{

    }
    private List<Colonne> colonnesDeCases = new ArrayList<>();

    private List<VEntete> entetes;

    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();
        Log.d("atelier07", "VGrille.onFinishInflate");

        this.creerGrille(MParametres.instance.getHauteur(), MParametres.instance.getLargeur());
    }




    private void initialiser(){
    }

    void creerGrille(int hauteur, int largeur){
        ajouterEnTetes(largeur);
        ajouterCases(hauteur, largeur);

    }
    private void initialiserColonnes(int largeur){

    }
    private void ajouterEnTetes(int largeur){

        for(int i=0;i<largeur;i++) {
            VEntete vEntete = new VEntete(this.getContext(), i);
            this.addView(vEntete, getMiseEnPageEntete(i));
            installerListenerEnTete(vEntete, i);
        }

    }
    private LayoutParams getMiseEnPageEntete(int colonne){
        int rangee = 0;

        float poidsColonne = 1;
        float poidsRangee = 3;

        Spec specRangee = GridLayout.spec(rangee, poidsRangee);
        Spec specColonne = GridLayout.spec(colonne, poidsColonne);

        LayoutParams mesParams = new LayoutParams(specRangee, specColonne);

        mesParams.width = 4;
        mesParams.height = 4;
        mesParams.setGravity(Gravity.FILL);


        mesParams.rightMargin = 2;
        mesParams.leftMargin = 0;

        return mesParams;
    }
    private void ajouterCases(int hauteur, int largeur){
        for(int i=0;i<hauteur;i++) {
            for (int j=0; j<largeur;j++){
                this.addView(new VCase(this.getContext(),j, i), getMiseEnPageCase(j, hauteur - i - 1));
            }
        }

    }
    private LayoutParams getMiseEnPageCase(int colonne, int rangee){

        float poidsColonne = 1;
        float poidsRangee = 1;

        Spec specRangee = GridLayout.spec(rangee+1, poidsRangee);
        Spec specColonne = GridLayout.spec(colonne, poidsColonne);

        LayoutParams mesParams = new LayoutParams(specRangee, specColonne);

        mesParams.width = 0;
        mesParams.height = 0;
        mesParams.setGravity(Gravity.FILL);


        mesParams.rightMargin = 2;
        mesParams.leftMargin = 0;

        return mesParams;

    }
    private void initialiserTableauDeCases(int hauteur, int largeur){

    }

    private Action demanderActionEntete(){

        Log.d("atelier07", "JOUER_COUP_ICI");
        return ControleurAction.demanderAction(GCommande.JOUER_COUP_ICI);
    }

    private void installerListenerEnTete(VEntete entete, final int colonne){
        Log.d("atelier07", "Listener pour chaque bouton en-tete");
        entete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("atelier07", "VGrille$1.onClick");
                Action action = demanderActionEntete();
                Log.d("atelier07", "Colonne est l'argument de l'action.");

                action.setArguments(colonne);
                Log.d("atelier07", "On execute l'action");
                action.executerDesQuePossible();
            }
        });

    }

    void afficherJetons(MGrille grille){

        List<MColonne> colonnes = grille.getColonnes();
        for (int i = 0; i < colonnes.size(); i++) {
            for (int j = 0; j < colonnes.get(i).getJetons().size(); j++) {
                afficherJeton(i, j, colonnes.get(i).getJetons().get(j));
            }
        }

    }

    private void afficherJeton(int colonne, int rangee, GCouleur jeton){
        colonnesDeCases.get(colonne).get(rangee).afficherJeton(jeton);
    }

}
