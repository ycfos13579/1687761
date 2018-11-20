package ca.cours5b5.youcefbokari.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import ca.cours5b5.youcefbokari.R;
import ca.cours5b5.youcefbokari.controleurs.Action;
import ca.cours5b5.youcefbokari.controleurs.ControleurAction;
import ca.cours5b5.youcefbokari.global.GCommande;


public class VMenuPrincipal extends Vue {

    private Button boutonParametres;
    private Action actionParametres;

    private Button boutonPartie;
    private Action actionPartie;

    private Button boutonConnexion;
    private Action actionConnexion;

    private static Button boutonPartieReseau;
    private Action actionPartieReseau;

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
    protected void onFinishInflate(){
        super.onFinishInflate();

        recupererControles();

        demanderActions();

        installerListeners();

    }


    private void recupererControles() {

        boutonParametres = findViewById(R.id.bouton_parametres);

        boutonPartie = findViewById(R.id.bouton_partie);

        boutonConnexion = findViewById(R.id.bouton_connexion);

        boutonPartieReseau = findViewById(R.id.bouton_jouerEnLigne);
    }

    private void demanderActions() {

        actionParametres = ControleurAction.demanderAction(GCommande.OUVRIR_MENU_PARAMETRES);

        actionPartie = ControleurAction.demanderAction(GCommande.DEMARRER_PARTIE);

        actionConnexion = ControleurAction.demanderAction(GCommande.OUVRIR_CONNEXION);

        actionPartieReseau = ControleurAction.demanderAction(GCommande.JOINDRE_OU_CREER_PARTIE_RESEAU);
    }


    private void installerListeners() {

        installerListenerParametres();

        installerListenerPartie();

        installerListenerConnexion();

        installerListenePartieReseau();

    }

    private void installerListenePartieReseau() {
        boutonPartieReseau.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                actionPartieReseau.executerDesQuePossible();
            }
        });
    }

    private void installerListenerPartie() {

        boutonPartie.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                actionPartie.executerDesQuePossible();
            }
        });

    }

    private void installerListenerParametres() {

        boutonParametres.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                actionParametres.executerDesQuePossible();
            }
        });

    }

    private void installerListenerConnexion() {

        boutonConnexion.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                actionConnexion.executerDesQuePossible();
            }
        });

    }

}
