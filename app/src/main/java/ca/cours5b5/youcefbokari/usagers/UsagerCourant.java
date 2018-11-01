package ca.cours5b5.youcefbokari.usagers;

import com.firebase.ui.auth.data.model.User;
import com.google.firebase.auth.FirebaseAuth;

import ca.cours5b5.youcefbokari.activites.AMenuPrincipal;

public class UsagerCourant {

    public  static boolean siUsagerConnecte(){
        boolean connecte = false;
        if (FirebaseAuth.getInstance().getCurrentUser()!= null){
            connecte = true;
        }
        return connecte;
    }

    public static String getId(){

    String userId = FirebaseAuth.getInstance().getUid();

    return userId;
    }
}
