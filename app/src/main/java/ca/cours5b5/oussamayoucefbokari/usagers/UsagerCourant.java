package ca.cours5b5.oussamayoucefbokari.usagers;

import com.google.firebase.auth.FirebaseAuth;

import ca.cours5b5.oussamayoucefbokari.global.GConstantes;

public final class UsagerCourant {

    private UsagerCourant(){}

    public static boolean siUsagerConnecte(){
        return FirebaseAuth.getInstance().getUid() != null;
    }

    public static String getId(){

        if(siUsagerConnecte()){

            return FirebaseAuth.getInstance().getUid();

        }else{

            return GConstantes.ID_PAR_DEFAUT;

        }
    }

    public static boolean estCeUsagerCourant(String idJoueur) {
        return getId().equals(idJoueur);
    }


}
