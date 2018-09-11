package cours5b5.oussamayoucefbokari.vues;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import cours5b5.oussamayoucefbokari.R;
import cours5b5.oussamayoucefbokari.activites.AMenuPrincipal;
import cours5b5.oussamayoucefbokari.global.GConstantes;

public class VParametres extends ConstraintLayout implements Vue{

    static {
        Class metaDonnees = AMenuPrincipal.class;
        Log.d("MonMsg", VParametres.class.getSimpleName()+"::static");

    }

    public VParametres(Context context) {
        super(context);
    }

    public VParametres(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VParametres(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();

        Log.d("MonMsg", this.getClass().getSimpleName()+"::onFinishInflate");

        Spinner spinHaut = this.findViewById(R.id.spinHaut);
        ArrayAdapter<Integer> adapter1 = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        spinHaut.setAdapter(adapter1);

        int haut_def = -1;
        for (int i = GConstantes.HAUTEUR_MIN; i <= GConstantes.HAUTEUR_MAX; i++){
            if (i == GConstantes.HAUTEUR_DEFAULT) {
                haut_def = adapter1.getCount();
            }
            adapter1.add(i);
        }
        // GConstante.HAUTEUR_DEFAUT - GConstante.HAUTEUR_MIN
        spinHaut.setSelection(haut_def);

        Spinner spinLarge = this.findViewById(R.id.spinLarge);
        ArrayAdapter<Integer> adapter2 = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        spinLarge.setAdapter(adapter2);

        int larg_def = -1;
        for (int i = GConstantes.LARGEUR_MIN; i <= GConstantes.LARGEUR_MAX; i++){
            if (i == GConstantes.LARGEUR_DEFAULT) {
                larg_def = adapter2.getCount();
            }
            adapter2.add(i);
        }

        spinLarge.setSelection(larg_def);

        Spinner spinGagner = this.findViewById(R.id.spinGagner);
        ArrayAdapter<Integer> adapter3 = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        spinGagner.setAdapter(adapter3);

        int gagne_def = -1;
        for (int i = GConstantes.GAGNER_MIN; i <= GConstantes.GAGNER_MAX; i++){
            if (i == GConstantes.GAGNER_DEFAULT) {
                gagne_def = adapter3.getCount();
            }
            adapter3.add(i);
        }

        spinGagner.setSelection(gagne_def);

    }
}
