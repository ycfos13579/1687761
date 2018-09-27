package cours5b5.oussamayoucefbokari.controleurs.interfaces;

import cours5b5.oussamayoucefbokari.modeles.Modele;

public interface ListenerObservateur {

    public void reagirNouveauModele(Modele modele);

    public abstract void reagirChangementAuModele(Modele modele);

}
