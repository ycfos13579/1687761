package cours5b5.oussamayoucefbokari.activites;

import android.os.Bundle;
import android.util.Log;

import java.util.Map;

import cours5b5.oussamayoucefbokari.R;
import cours5b5.oussamayoucefbokari.global.GConstantes;
import cours5b5.oussamayoucefbokari.modeles.MParametres;
import cours5b5.oussamayoucefbokari.serialisation.Jsonification;

public class APartie extends Activite{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null) {
            restaurerParametres(savedInstanceState);
        }
        setContentView(R.layout.activity_partie);
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        this.sauvegarderParametres(outState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private void restaurerParametres(Bundle savedInstanceState){
        String json = savedInstanceState.getString(GConstantes.maCle);

        Map<String, Object> objetJson = Jsonification.enObjetJson(json);

        mParametres.aPartirObjetJson(objetJson);

    }
    private void sauvegarderParametres(Bundle outState){
        Map<String, Object> objetJson = MParametres.instance.enObjetJson();

        String json = Jsonification.enChaine(objetJson);

        outState.putString(GConstantes.maCle, json);

    }

}
