package cours5b5.oussamayoucefbokari.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

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

    private class Colonne extends ArrayList<VCase>{

    }
    private List<Colonne> colonnesDeCases = new ArrayList<>();

    private List<VEntete> entetes;

    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();
        this.creerGrille(4,2);
    }



    private void initialiser(){}

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
        float poidsRangee = 1;

        Spec specRangee = GridLayout.spec(rangee, poidsRangee);
        Spec specColonne = GridLayout.spec(colonne, poidsColonne);

        LayoutParams mesParams = new LayoutParams(specRangee, specColonne);

        mesParams.width = 0;
        mesParams.height = 0;
        mesParams.setGravity(Gravity.FILL);


        mesParams.rightMargin = 2;
        mesParams.leftMargin = 2;

        return mesParams;
    }
    private void ajouterCases(int hauteur, int largeur){

    }
    private LayoutParams getMiseEnPageCase(int colonne){

        return null;
    }

}
