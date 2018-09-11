package cours5b5.oussamayoucefbokari.modeles;

import java.util.Map;

public abstract class Modele {

    public abstract void aPartirObjetJson(Map<String, Object> objectJson);

    public abstract Map<String, Object> enObjetJson();
}
