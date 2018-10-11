package cours5b5.oussamayoucefbokari.modeles;

import android.util.Log;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import cours5b5.oussamayoucefbokari.global.GConstantes;
import cours5b5.oussamayoucefbokari.serialisation.AttributSerialisable;

public class MParametres extends Modele{

    static {
        Log.d("MonMsg", MParametres.class.getSimpleName()+"::static");

    }

    public static MParametres instance = new MParametres();

    @AttributSerialisable
    public MParametresPartie parametresPartie = new MParametresPartie();
    private String __parametresPartie = "parametresPartie";

    private List<Integer> choixHauteur;
    private List<Integer> choixLargeur;
    private List<Integer> choixPourGagner;

    @AttributSerialisable
    public Integer hauteur;
    private final String __hauteur = "hauteur";

    @AttributSerialisable
    public Integer largeur;
    private final String __largeur = "largeur";

    @AttributSerialisable
    public Integer pourGagner;
    private final String __pourGagner = "pourGagner";

    public MParametres() {
        genererListesDeChoix();
    }

    private void genererListesDeChoix() {
        genererListeChoixHauteur();
        genererListeChoixLargeur();
        genererListeChoixPourGagner();

        setHauteur(GConstantes.HAUTEUR_DEFAULT);
        setLargeur(GConstantes.LARGEUR_DEFAULT);
        setPourGagner(GConstantes.GAGNER_DEFAULT);
    }
    private void genererListeChoixHauteur() {
        choixHauteur = genererListeChoix(GConstantes.HAUTEUR_MIN, GConstantes.HAUTEUR_MAX);
    }

    private void genererListeChoixLargeur() {
        choixLargeur = genererListeChoix(GConstantes.LARGEUR_MIN, GConstantes.LARGEUR_MAX);
    }

    private void genererListeChoixPourGagner() {
        choixPourGagner = genererListeChoix(GConstantes.GAGNER_MIN, GConstantes.GAGNER_MAX);
    }
    private List<Integer> genererListeChoix(int min, int max) {
        List<Integer> listeChoix = new ArrayList();

        for(int i = min; i <= max; ++i) {
            listeChoix.add(new Integer(i));
        }
        return listeChoix;
    }



    public List<Integer> getChoixHauteur() {
        return choixHauteur;
    }

    public List<Integer> getChoixLargeur() {
        return choixLargeur;
    }

    public List<Integer> getChoixPourGagner() {
        return choixPourGagner;
    }

    public MParametresPartie getParametresPartie() {


        return this.parametresPartie;
    }

    public void setHauteur(Integer hauteur) {
        this.hauteur = hauteur;
    }

    public void setLargeur(Integer largeur) {
        this.largeur = largeur;
    }

    public void setPourGagner(Integer pourGagner) {
        this.pourGagner = pourGagner;
    }

    public Integer getHauteur() {
        return hauteur;
    }

    public Integer getLargeur() {
        return largeur;
    }

    public Integer getPourGagner() {
        return pourGagner;
    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) {

            for(Map.Entry<String, Object> entry: enObjetJson().entrySet()) {
                String cle = entry.getKey();

                if (cle.equals(__hauteur)) {
                    setHauteur(Integer.valueOf(((String)entry.getValue())));
                } else  if (cle.equals(__largeur)) {
                    setLargeur(Integer.valueOf(((String)entry.getValue())));
                } else {
                    setPourGagner(Integer.valueOf(((String)entry.getValue())));
                }
            }
           /* if (cle.equals(__parametresPartie)) {

                parametresPartie = new MParametresPartie();

                parametresPartie.aPartirObjetJson((Map<String, Object>) entry.getValue());

            }*/

    }

    @Override
    public Map<String, Object> enObjetJson() {

        Map<String, Object> objetJson = new HashMap<>();

        objetJson.put(__hauteur,getHauteur().toString());
        objetJson.put(__largeur, getLargeur().toString());
        objetJson.put(__pourGagner, getPourGagner().toString());

        return objetJson;



        // objetJson.put(__parametresPartie, parametresPartie.enObjetJson());

    }

}
