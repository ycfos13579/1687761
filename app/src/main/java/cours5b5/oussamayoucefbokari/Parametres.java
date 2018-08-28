package cours5b5.oussamayoucefbokari;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Parametres extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);

        String orientation;
        if (this.getResources().getBoolean(R.bool.estPays)){
            orientation = "paysage";
        }else {
            orientation = "protrait";
        }

        Log.d("MonEtiquette",this.getResources().getString(R.string.BONJOUR)+" "+orientation +"!" );


        //Log.d("MonEtiquette","Bonjour");
    }
}
