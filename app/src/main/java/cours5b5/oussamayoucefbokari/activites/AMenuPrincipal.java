package cours5b5.oussamayoucefbokari.activites;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cours5b5.oussamayoucefbokari.R;
import cours5b5.oussamayoucefbokari.vues.VParametres;

public class AMenuPrincipal extends Activite {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);

        Button boutParametres = this.findViewById(R.id.button);

        boutParametres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
