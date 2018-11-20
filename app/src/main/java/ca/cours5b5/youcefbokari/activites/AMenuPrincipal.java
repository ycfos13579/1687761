package ca.cours5b5.youcefbokari.activites;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.firebase.ui.auth.AuthUI;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.youcefbokari.R;
import ca.cours5b5.youcefbokari.controleurs.ControleurAction;
import ca.cours5b5.youcefbokari.controleurs.interfaces.Fournisseur;
import ca.cours5b5.youcefbokari.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.youcefbokari.global.GCommande;
import ca.cours5b5.youcefbokari.global.GConstantes;
import ca.cours5b5.youcefbokari.modeles.MPartieReseau;

import static ca.cours5b5.youcefbokari.global.GConstantes.CONST_CONNEXION;

public class AMenuPrincipal extends Activite implements Fournisseur {


        List<AuthUI.IdpConfig> fournisseursDeConnexion = new ArrayList<>();

    @Override
    protected void initialiserApplication() {
        super.initialiserApplication();
        fournisseursDeConnexion.add(new AuthUI.IdpConfig.GoogleBuilder().build());
        fournisseursDeConnexion.add(new AuthUI.IdpConfig.EmailBuilder().build());
        fournisseursDeConnexion.add(new AuthUI.IdpConfig.PhoneBuilder().build());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        fournirActions();

    }

    private void fournirActions() {

        fournirActionOuvrirMenuParametres();

        fournirActionDemarrerPartie();

        fournirActionConnexion();

        fournirActionJoindreOuCreerPartieReseau();

    }

    private void fournirActionJoindreOuCreerPartieReseau() {
        ControleurAction.fournirAction(this,
                GCommande.JOINDRE_OU_CREER_PARTIE_RESEAU,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {
                        transitionPartieReseau();
                    }
                });
    }

    private void transitionPartieReseau() {
        Intent intentionPartieReseau = new Intent(this, APartieReseau.class);
        intentionPartieReseau.putExtra(MPartieReseau.class.getSimpleName(), GConstantes.FIXME_JSON_PARTIE_RESEAU);
        startActivity(intentionPartieReseau);
    }

    private void fournirActionConnexion(){
        ControleurAction.fournirAction(this,
                GCommande.OUVRIR_CONNEXION,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        connexion();

                    }
                });

    }

    private void fournirActionOuvrirMenuParametres() {

        ControleurAction.fournirAction(this,
                GCommande.OUVRIR_MENU_PARAMETRES,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        transitionParametres();

                    }
                });
    }

    private void fournirActionDemarrerPartie() {

        ControleurAction.fournirAction(this,
                GCommande.DEMARRER_PARTIE,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        transitionPartie();

                    }
                });
    }

    private void transitionParametres(){

        Intent intentionParametres = new Intent(this, AParametres.class);
        startActivity(intentionParametres);

    }

    private void transitionPartie(){

        Intent intentionParametres = new Intent(this, APartie.class);
        startActivity(intentionParametres);

    }
    private void connexion(){

        Intent intentionConnexion = AuthUI.getInstance().createSignInIntentBuilder()
                                        .setAvailableProviders(fournisseursDeConnexion).build();
        this.startActivityForResult(intentionConnexion, CONST_CONNEXION);
    }

    @Override
    protected void onActivityResult(int requestCode, int resulCode, Intent data){

        if (requestCode == CONST_CONNEXION){
            if (resulCode == RESULT_OK){
                Log.d("atelier11", "Connexion réussie");
            }else{
                Log.d("atelier11", "Connexion échouée");
            }
        }
    }

}
