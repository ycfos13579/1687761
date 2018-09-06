package cours5b5.oussamayoucefbokari.vues;

import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import cours5b5.oussamayoucefbokari.R;
import cours5b5.oussamayoucefbokari.activites.AMenuPrincipal;

public class VMenuPrincipal extends ConstraintLayout implements Vue  {

    static {
        Class metaDonnees = AMenuPrincipal.class;
        Log.d("MonMsg", VMenuPrincipal.class.getSimpleName()+"::static");

    }



    public VMenuPrincipal(Context context) {
        super(context);
    }

    public VMenuPrincipal(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VMenuPrincipal(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.d("MonMsg", this.getClass().getSimpleName()+"::onFinishInflate");
    }
}
