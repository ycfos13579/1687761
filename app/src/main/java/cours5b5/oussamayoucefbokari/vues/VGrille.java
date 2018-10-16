package cours5b5.oussamayoucefbokari.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

import cours5b5.oussamayoucefbokari.global.GCouleur;
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
            this.addView(new VEntete(this.getContext(), i), getMiseEnPageEntete(i));
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

    private void demanderActionEntete(){

    }

    private void installerListenerEnTete(VEntete entete, final int colonne){

    }

    void afficherJetons(MGrille grille){

    }

    private void afficherJeton(int colonne, int rangee, GCouleur jeton){

    }

}
