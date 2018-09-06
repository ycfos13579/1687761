package cours5b5.oussamayoucefbokari.activites;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import cours5b5.oussamayoucefbokari.R;

public abstract class Activite extends AppCompatActivity {
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
        //Log.d("MonMsg",this.getClass().getSimpleName()+"::onCreate");
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
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MonMsg",this.getClass().getSimpleName()+"::onDestroy");
    }
}
