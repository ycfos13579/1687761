package cours5b5.oussamayoucefbokari.activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Map;

import cours5b5.oussamayoucefbokari.R;
import cours5b5.oussamayoucefbokari.global.GConstantes;
import cours5b5.oussamayoucefbokari.modeles.MParametres;
import cours5b5.oussamayoucefbokari.serialisation.Jsonification;

public class AParametres extends Activite {
    static {
        Class metaDonnees = AMenuPrincipal.class;
        Log.d("MonMsg", AParametres.class.getSimpleName()+"::static");

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null) {
            restaurerParametres(savedInstanceState);
        }
        setContentView(R.layout.activity_parametres);
    }
    private void restaurerParametres(Bundle savedInstanceState){
        String json = savedInstanceState.getString(GConstantes.maCle);

        Map<String, Object> objetJson = Jsonification.enObjetJson(json);

        mParametres.aPartirObjetJson(objetJson);

        Log.d("Atelier05", this.getClass().getSimpleName() + "::restaurerParametres, " + "clé:" + GConstantes.maCle);
        Log.d("Atelier05", this.getClass().getSimpleName() + "::restaurerParametres, " + "json:\n" + json);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        this.sauvegarderParametres(outState);
    }

    private void sauvegarderParametres(Bundle outState){
        Map<String, Object> objetJson = MParametres.instance.enObjetJson();

        String json = Jsonification.enChaine(objetJson);

        outState.putString(GConstantes.maCle, json);

        Log.d("Atelier05", this.getClass().getSimpleName() + "::sauvegarderParametres, " + "clé:" + GConstantes.maCle);
        Log.d("Atelier05", this.getClass().getSimpleName() + "::sauvegarderParametres, " + "json:\n" + json);
    }

    private void messageAtelier2() {

        String orientation;
        if (this.getResources().getBoolean(R.bool.estPays)){
            orientation = "paysage";
        }else {
            orientation = "protrait";
        }

        Log.d("MonEtiquette",this.getResources().getString(R.string.BONJOUR)+" "+orientation +"!" );

    }
}
