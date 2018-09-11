package cours5b5.oussamayoucefbokari.activites;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Map;

import cours5b5.oussamayoucefbokari.R;
import cours5b5.oussamayoucefbokari.modeles.MParametres;
import cours5b5.oussamayoucefbokari.modeles.Modele;
import cours5b5.oussamayoucefbokari.serialisation.Jsonification;

import static cours5b5.oussamayoucefbokari.modeles.MParametres.instance;

public abstract class Activite extends AppCompatActivity {

    MParametres mParametres = new MParametres();

    static {
        Class metaDonnees = AMenuPrincipal.class;

        Log.d("MonMsg",Activite.class.getSimpleName()+"::static");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MonMsg",this.getClass().getSimpleName()+"::onCreate");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_parametres);
        //Log.d("MonMsg",this.getClass().getSimpleName()+"::onCreate");

        if(savedInstanceState != null){
            String json = savedInstanceState.getString("MaCle");
            Map<String, Object> objetJson = Jsonification.enObjetJson(json);
            instance.aPartirObjetJson(objetJson);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MonMsg",this.getClass().getSimpleName()+"::onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MonMsg",this.getClass().getSimpleName()+"::onPause");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.d("MonMsg", this.getClass().getSimpleName()+"::onSaveInstanceState");
        //outState.putString("","");

        Map<String, Object> objetJson = mParametres.enObjetJson();
        String json = Jsonification.enChaine(objetJson);
        outState.putString("MaCle", json);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MonMsg",this.getClass().getSimpleName()+"::onDestroy");
    }
}
