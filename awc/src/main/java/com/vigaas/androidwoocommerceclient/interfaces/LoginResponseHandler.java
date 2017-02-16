package com.vigaas.androidwoocommerceclient.interfaces;

/**
 * Created by damandeep on 09/01/17.
 */

public interface LoginResponseHandler {
    void onLoginSucess(int userId, String name, String avatarUrl);
    void onLoginError();
}
