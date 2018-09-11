package cours5b5.oussamayoucefbokari.modeles;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;
import java.util.Map;

import cours5b5.oussamayoucefbokari.R;
import cours5b5.oussamayoucefbokari.global.GConstantes;
import cours5b5.oussamayoucefbokari.serialisation.AttributSerialisable;

public class MParametres extends Modele{

    public static MParametres instance;

    @AttributSerialisable
    public Integer hauteur;
    private final String __hauteur = "hauteur";

    @AttributSerialisable
    public Integer largeur;
    private final String __largeur = "largeur";

    @AttributSerialisable
    public Integer pourGagner;
    private final String __pourGagner = "pourGagner";

    public List<Integer> getChoixHauteur(){
        return null;
    }
    public List<Integer> getChoixLargeur(){
        return null;
    }
    public List<Integer> getChoixPourGagner(){
        return null;
    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objectJson) {

    }

    @Override
    public Map<String, Object> enObjetJson() {
        return null;
    }

}
