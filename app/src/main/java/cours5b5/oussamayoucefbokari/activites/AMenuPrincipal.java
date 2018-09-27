package cours5b5.oussamayoucefbokari.activites;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import cours5b5.oussamayoucefbokari.R;
import cours5b5.oussamayoucefbokari.vues.VParametres;

public class AMenuPrincipal extends Activite {

    static {
        Class metaDonnees = AMenuPrincipal.class;
        Log.d("MonMsg", AMenuPrincipal.class.getSimpleName()+"::static");

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Button bParametres = this.findViewById(R.id.bouton_menu);
        Button bPartie = this.findViewById(R.id.bouton_jouer);
        bParametres.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                temp();
            }
        });

        bPartie.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                temp2();
            }
        });
    }



    public void temp() {

        Intent mnIntn = new Intent(this, AParametres.class);
        AMenuPrincipal.this.startActivity(mnIntn);
    }
    public void temp2() {

        Intent mnIntn = new Intent(this, APartie.class);
        AMenuPrincipal.this.startActivity(mnIntn);
    }

}



