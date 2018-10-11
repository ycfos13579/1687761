package cours5b5.oussamayoucefbokari.modeles;

import java.util.HashMap;
import java.util.Map;

import cours5b5.oussamayoucefbokari.exceptions.ErreurDeSerialisation;
import cours5b5.oussamayoucefbokari.global.GConstantes;
import cours5b5.oussamayoucefbokari.serialisation.AttributSerialisable;

public class MParametresPartie extends Modele{

    @AttributSerialisable
    public Integer hauteur;
    private final String __hauteur = "hauteur";

    @AttributSerialisable
    public Integer largeur;
    private final String __largeur = "largeur";

    @AttributSerialisable
    public Integer pourGagner;
    private final String __pourGagner = "pourGagner";

    public MParametresPartie(){
        this.setHauteur(GConstantes.HAUTEUR_DEFAULT);
        this.setHauteur(GConstantes.LARGEUR_DEFAULT);
        this.setPourGagner(GConstantes.GAGNER_DEFAULT);
        /*this.hauteur = MParametres.instance.getHauteur();
        this.largeur = MParametres.instance.getLargeur();
        this.pourGagner = MParametres.instance.getPourGagner();*/

    }
    public MParametresPartie cloner(){

        MParametresPartie parametresPartie = new MParametresPartie(MParametres.instance.hauteur,MParametres.instance.largeur,MParametres.instance.pourGagner);

        /*parametresPartie.setHauteur(this.hauteur);
        parametresPartie.setLargeur(this.largeur);
        parametresPartie.setPourGagner(this.pourGagner);
    */
        return parametresPartie;

    }
    public static MParametresPartie aPartirMparametres (MParametres mParametres){
        return mParametres.parametresPartie.cloner();

    }
    public MParametresPartie(int hauteur, int largeur, int pourGagner){
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.pourGagner = pourGagner;
    }
    public Integer getHauteur(){
        return hauteur;
    }
    public Integer getLargeur(){

        return largeur;
    }
    public Integer getPourGagner(){

        return pourGagner;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }
    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }
    public void setPourGagner(int pourGagner) {
        this.pourGagner = pourGagner ;
    }


    @Override
    public void aPartirObjetJson(Map<String, Object> objectJson) throws ErreurDeSerialisation {

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

    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurDeSerialisation{
        Map<String, Object> objetJson = new HashMap<>();

        objetJson.put(__hauteur,getHauteur().toString());
        objetJson.put(__largeur, getLargeur().toString());
        objetJson.put(__pourGagner, getPourGagner().toString());

        return objetJson;
    }
}
