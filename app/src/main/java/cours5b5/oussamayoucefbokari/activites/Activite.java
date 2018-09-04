package cours5b5.oussamayoucefbokari.activites;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import cours5b5.oussamayoucefbokari.R;

public abstract class Activite extends AppCompatActivity {

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //code pour sauvegarder des données.
        outState.putString("","");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
