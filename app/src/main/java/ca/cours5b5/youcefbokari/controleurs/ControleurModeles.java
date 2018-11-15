package ca.cours5b5.youcefbokari.controleurs;


import android.util.Log;

import com.firebase.ui.auth.data.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.cours5b5.youcefbokari.controleurs.ControleurAction;
import ca.cours5b5.youcefbokari.controleurs.ControleurObservation;
import ca.cours5b5.youcefbokari.controleurs.interfaces.Fournisseur;
import ca.cours5b5.youcefbokari.controleurs.interfaces.ListenerGetModele;
import ca.cours5b5.youcefbokari.donnees.ListenerChargement;
import ca.cours5b5.youcefbokari.donnees.Serveur;
import ca.cours5b5.youcefbokari.donnees.SourceDeDonnees;
import ca.cours5b5.youcefbokari.exceptions.ErreurModele;
import ca.cours5b5.youcefbokari.global.GLog;
import ca.cours5b5.youcefbokari.modeles.MParametres;
import ca.cours5b5.youcefbokari.modeles.MParametresPartie;
import ca.cours5b5.youcefbokari.modeles.MPartie;
import ca.cours5b5.youcefbokari.modeles.Modele;
import ca.cours5b5.youcefbokari.donnees.Disque;
import ca.cours5b5.youcefbokari.usagers.UsagerCourant;

public final class ControleurModeles {

    private ControleurModeles(){}

    private static Map<String, Modele> modelesEnMemoire;

    private static SourceDeDonnees[] sequenceDeChargement;

    private static List<SourceDeDonnees> listeDeSauvegardes;

    static {

        modelesEnMemoire = new HashMap<>();

        listeDeSauvegardes = new ArrayList<>();
        listeDeSauvegardes.add(Serveur.getInstance());
        listeDeSauvegardes.add(Disque.getInstance());


    }

    public static void setSequenceDeChargement(SourceDeDonnees... sequenceDeChargement){

        ControleurModeles.sequenceDeChargement = sequenceDeChargement;

    }

    public static void sauvegarderModeleDansCetteSource(String nomModele, SourceDeDonnees sourceDeDonnees) {

        Log.d("atelier12", nomModele + " : " + sourceDeDonnees);

        Modele modele = modelesEnMemoire.get(nomModele);

        if(modele != null){

            Map<String, Object> objetJson = modele.enObjetJson();

            sourceDeDonnees.sauvegarderModele(getCheminSauvegarde(nomModele), objetJson);

        }
    }

    static void getModele(final String nomModele, final ListenerGetModele listenerGetModele){

        Modele modele = modelesEnMemoire.get(nomModele);

        if(modele == null){

            creerModeleEtChargerDonnes(nomModele, new ListenerGetModele() {
                @Override
                public void reagirAuModele(Modele modele) {

                    listenerGetModele.reagirAuModele(modele);

                }

            });

        } else {

            listenerGetModele.reagirAuModele(modele);

        }

    }


   /* private static Modele chargerViaSequenceDeChargement(final String nomModele){

        creerModeleSelonNom(nomModele, new ListenerGetModele() {
            @Override
            public void reagirAuModele(Modele modele) {

            }
        });

        modelesEnMemoire.put(nomModele, modele);

        for(SourceDeDonnees sourceDeDonnees : sequenceDeChargement){

            Map<String, Object> objetJson = sourceDeDonnees.chargerModele(nomModele, new ListenerChargement() {
                @Override
                public void reagirSucces(Map<String, Object> objetJson) {

                }

                @Override
                public void reagirErreur(Exception e) {

                }
            });

            if(objetJson != null){

                modele.aPartirObjetJson(objetJson);
                break;

            }

        }

        return modele;
    }*/

    public static void sauvegarderModele(String nomModele) throws ErreurModele {

        Log.d("atelier12", nomModele);

        for(SourceDeDonnees source : listeDeSauvegardes){

            sauvegarderModeleDansCetteSource(nomModele, source);

        }

    }


    private static void creerModeleSelonNom(String nomModele, final ListenerGetModele listenerGetModele) throws ErreurModele {

        if(nomModele.equals(MParametres.class.getSimpleName())){

            listenerGetModele.reagirAuModele(new MParametres());
            Log.d("atelier12", "CreerModeleSelonNom1");

        }else if(nomModele.equals(MPartie.class.getSimpleName())){

            getModele(MParametres.class.getSimpleName(), new ListenerGetModele() {
                @Override
                public void reagirAuModele(Modele modele) {

                    MParametres mParametres = (MParametres)  modele;


                    MPartie mPartie = new MPartie(mParametres.getParametresPartie());

                    listenerGetModele.reagirAuModele(mPartie);
                    Log.d("atelier12", "CreerModeleSelonNom");
                }
            });


        }else{

            throw new ErreurModele("Modèle inconnu: " + nomModele);

        }
    }

    private static void creerModeleEtChargerDonnes(final String nomModele, final ListenerGetModele listenerGetModele){
        Log.d("atelier12", "CreerModeleEtChargerDonnées");
        creerModeleSelonNom(nomModele, new ListenerGetModele() {

            @Override
            public void reagirAuModele(Modele modele) {

                modelesEnMemoire.put(nomModele, modele);

                chargerDonnees(modele, nomModele, new ListenerGetModele() {

                    @Override
                    public void reagirAuModele(Modele modele) {

                        listenerGetModele.reagirAuModele(modele);

                    }

                });

                listenerGetModele.reagirAuModele(modele);

            }

        });

    }

    private static void chargerDonnees(Modele modele,
                                       String nomModele,
                                       ListenerGetModele listenerGetModele) {

        GLog.donnees(modele, nomModele);

        chargementViaSequence(modele, getCheminSauvegarde(nomModele), listenerGetModele, 0);
    }

    private static void chargementViaSequence(Modele modele,
                                              String cheminDeSauvegarde,
                                              ListenerGetModele listnerGetModele,
                                              int indiceSourceCourante){
        Log.d("atelier12", "ChargementViaSequences");

        if(indiceSourceCourante == sequenceDeChargement.length){
            terminerChargement(modele, listnerGetModele);
        }else{
            chargemenetViaSourceCouranteOuSuivante(modele, cheminDeSauvegarde, listnerGetModele, indiceSourceCourante);
        }

    }

    private static void chargemenetViaSourceCouranteOuSuivante(final Modele modele,
                                                               final String cheminDeSauvegarde,
                                                               final ListenerGetModele listenerGetModele,
                                                               final int indiceSourceCourante){

        sequenceDeChargement[indiceSourceCourante].chargerModele(cheminDeSauvegarde, new ListenerChargement() {
            @Override
            public void reagirSucces(Map<String, Object> objetJson) {

                GLog.donnees("Success", modele, cheminDeSauvegarde, indiceSourceCourante, sequenceDeChargement[indiceSourceCourante]);

                terminerChargementAvecDonnees(objetJson, modele, listenerGetModele);

            }

            @Override
            public void reagirErreur(Exception e) {

                GLog.donnees("Erreur", modele, cheminDeSauvegarde, indiceSourceCourante, sequenceDeChargement[indiceSourceCourante], e.getMessage());

                e.printStackTrace();

                chargementViaSourceSuivante(modele, cheminDeSauvegarde, listenerGetModele, indiceSourceCourante);
            }
        });
    }

    private static void terminerChargementAvecDonnees(Map<String, Object> objectJson, Modele modele, ListenerGetModele listenerGetModele){
        Log.d("atelier12", "terminerCahargement");

        modele.aPartirObjetJson(objectJson);

        terminerChargement(modele, listenerGetModele);

    }

    private static void terminerChargement (Modele modele, ListenerGetModele listenerGetModele){
        Log.d("atelier12", "terminerChargement");

        GLog.donnees(modele);

        listenerGetModele.reagirAuModele(modele);
    }

    private static void chargementViaSourceSuivante(Modele modele,
                                                    String cheminDeSauvegarde,
                                                    ListenerGetModele listenerGetModele,
                                                    int indiceSourceCourante){
        chargementViaSequence(modele, cheminDeSauvegarde, listenerGetModele, indiceSourceCourante + 1);
        Log.d("atelier12", "ChargementViaSourceSuivante");

    }
    public static void detruireModele(String nomModele) {
        Log.d("atelier12", "detruireModele");
        Modele modele = modelesEnMemoire.get(nomModele);

        if(modele != null){
            ControleurObservation.detruireObservation(modele);

            modelesEnMemoire.remove(nomModele);

            if(modele instanceof Fournisseur){

                ControleurAction.oublierFournisseur((Fournisseur) modele);

            }
        }
    }

    private static String getCheminSauvegarde(String nomModele){

        return nomModele+"/"+ UsagerCourant.getId();
    }

}
