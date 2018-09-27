package cours5b5.oussamayoucefbokari.activites;

import android.os.Bundle;
import android.util.Log;

import java.util.Map;

import cours5b5.oussamayoucefbokari.R;
import cours5b5.oussamayoucefbokari.global.GConstantes;
import cours5b5.oussamayoucefbokari.serialisation.Jsonification;

public class APartie extends Activite{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null) {
            restaurerParametres(savedInstanceState);
        }
        setContentView(R.layout.activity_partie);
    }
    private void restaurerParametres(Bundle savedInstanceState){
        String json = savedInstanceState.getString(GConstantes.maCle);

        Map<String, Object> objetJson = Jsonification.enObjetJson(json);

        mParametres.aPartirObjetJson(objetJson);

        //Log.d("Atelier05", this.getClass().getSimpleName() + "::restaurerParametres, " + "clé:" + GConstantes.maCle);
        //Log.d("Atelier05", this.getClass().getSimpleName() + "::restaurerParametres, " + "json:\n" + json);
    }

}
