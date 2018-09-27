package cours5b5.oussamayoucefbokari.vues;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

public class VEntete extends AppCompatButton {
    public VEntete(Context context) {
        super(context);
    }

    public VEntete(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VEntete(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private int colonne;

    public VEntete(Context context, int colonne){
        super(context);
        this.colonne =colonne;
        setText(colonne+"");
    }
}
