package cours5b5.oussamayoucefbokari.vues;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;

public abstract class Vue extends ConstraintLayout {


    public Vue(Context context) {
        super(context);
    }

    public Vue(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Vue(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected void onFinishInflate(){
        super.onFinishInflate();
    }

    public abstract void onItemSelected(AdapterView<?> parent, View view, int position, long id);

    public abstract void onNothingSelected(AdapterView<?> parent);
}
