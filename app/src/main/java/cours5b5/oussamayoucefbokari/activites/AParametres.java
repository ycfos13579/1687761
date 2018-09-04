package cours5b5.oussamayoucefbokari.activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import cours5b5.oussamayoucefbokari.R;

public class AParametres extends Activite {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_parametres);

            String orientation;
            if (this.getResources().getBoolean(R.bool.estPays)){
                orientation = "paysage";
            }else {
                orientation = "protrait";
            }

            Log.d("MonEtiquette",this.getResources().getString(R.string.BONJOUR)+" "+orientation +"!" );


        } catch (Exception e) {
            Log.d("MonEtiquette",e.toString());
        }
    }
}
