package cours5b5.oussamayoucefbokari.activites;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import cours5b5.oussamayoucefbokari.R;
import cours5b5.oussamayoucefbokari.vues.VParametres;

public class AMenuPrincipal extends Activite {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Button bParametres = this.findViewById(R.id.bouton_menu);

        bParametres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp();
            }
        });

    }

    public void temp() {

        Intent mnIntn = new Intent(this, AParametres.class);
        this.startActivity(mnIntn);
    }
}