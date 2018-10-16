package cours5b5.oussamayoucefbokari.vues;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import cours5b5.oussamayoucefbokari.global.GCouleur;

public class VCase extends AppCompatButton{
    public VCase(Context context) {
        super(context);
    }

    public VCase(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VCase(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public VCase(Context context, int rangee, int colonne){
        super(context);
        setText(colonne +", "+ rangee);
    }

    private void afficherJeton(GCouleur jeton){

    }
}
