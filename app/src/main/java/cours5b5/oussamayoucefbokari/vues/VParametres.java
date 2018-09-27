package cours5b5.oussamayoucefbokari.vues;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import cours5b5.oussamayoucefbokari.R;
import cours5b5.oussamayoucefbokari.activites.AMenuPrincipal;
import cours5b5.oussamayoucefbokari.modeles.MParametres;
import cours5b5.oussamayoucefbokari.modeles.MParametresPartie;

public class VParametres extends Vue implements AdapterView.OnItemSelectedListener {

    static {
        Class metaDonnees = AMenuPrincipal.class;
        Log.d("MonMsg", VParametres.class.getSimpleName()+"::static");

    }
    private ArrayAdapter<Integer> adapterHaut;
    private ArrayAdapter<Integer> adapterLarg;
    private ArrayAdapter<Integer> adapterGagner;
    private Spinner spinnerHaut;
    private Spinner spinnerLarg;
    private Spinner spinnerGagner;

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

        initialiseSpinners();

        initialiseAdapteurs();

        setAdapters();

        remplirAdapters();

        spinnersPosition();
    }

    private void initialiseAdapteurs() {
        adapterHaut = new ArrayAdapter<>(getContext(),
                R.layout.support_simple_spinner_dropdown_item);
        adapterLarg = new ArrayAdapter<>(getContext(),
                R.layout.support_simple_spinner_dropdown_item);
        adapterGagner = new ArrayAdapter<>(getContext(),
                R.layout.support_simple_spinner_dropdown_item);
    }

    private void initialiseSpinners() {
        spinnerHaut = findViewById(R.id.spinHaut);
        spinnerLarg = findViewById(R.id.spinLarge);
        spinnerGagner = findViewById(R.id.spinGagner);

        spinnerHaut.setOnItemSelectedListener(this);
        spinnerLarg.setOnItemSelectedListener(this);
        spinnerGagner.setOnItemSelectedListener(this);
    }

    private void setAdapters() {
        spinnerHaut.setAdapter(adapterHaut);
        spinnerLarg.setAdapter(adapterLarg);
        spinnerGagner.setAdapter(adapterGagner);
    }

    private void remplirAdapters() {
        adapterHaut.addAll(MParametres.instance.getChoixHauteur());
        adapterLarg.addAll(MParametres.instance.getChoixLargeur());
        adapterGagner.addAll(MParametres.instance.getChoixPourGagner());
    }

    private void spinnersPosition() {
        spinnerHaut.setSelection(adapterHaut.getPosition(MParametres.instance.getHauteur()));
        spinnerLarg.setSelection(adapterLarg.getPosition(MParametres.instance.getLargeur()));
        spinnerGagner.setSelection(adapterGagner.getPosition(MParametres.instance.getPourGagner()));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner spinner = (Spinner) parent;
        Integer choix = (Integer)parent.getAdapter().getItem(parent.getSelectedItemPosition());

        if(spinner.getId() == R.id.spinHaut) {
            MParametres.instance.setHauteur(choix);
        } else if(spinner.getId() == R.id.spinLarge) {
            MParametres.instance.setLargeur(choix);
        } else {
            MParametres.instance.setPourGagner(choix);
        }
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
