package com.example.e440.functional_navdrawer;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by e440 on 20-03-18.
 */

public class CredentialsManager {
    static CredentialsManager credentialsManager;
    static String preferencesFileName = "Credentials";
    public SharedPreferences preferences;
    public CredentialsManager(Context context){
        this.preferences = context.getSharedPreferences(preferencesFileName, Context.MODE_PRIVATE);
    }

    static synchronized CredentialsManager getInstance(Context context){


        if (credentialsManager==null){

            credentialsManager =new CredentialsManager(context);
        }
        return credentialsManager;

    }



    String getUserName(){

        String user_name = this.preferences.getString("user", null);
        return user_name;
    }

    String getUserPassword(){
        String user_password = this.preferences.getString("password", null);
        return user_password;


    }
    String getToken(){

        String token = this.preferences.getString("token", null);
        return token;

    }

    void saveToken(String token){

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("token", token);

    }

    void saveCredentials(String user_name, String user_password){

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user", user_name);
        editor.putString("password",user_password);
        editor.commit();


    }

    void destroyCredentials(){

        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
    }
}


