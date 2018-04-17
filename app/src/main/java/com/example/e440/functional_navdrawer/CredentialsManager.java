package com.example.e440.myapplication;

import android.content.ContentProvider;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by e440 on 20-03-18.
 */

public class CredentialsManager {
    static String preferencesFileName = "Credentials";
    public SharedPreferences preferences;
    public CredentialsManager(Context context){
        this.preferences = context.getSharedPreferences(preferencesFileName, Context.MODE_PRIVATE);
    }



    String getUserName(){

        String user_name = this.preferences.getString("user", null);
        return user_name;
    }

    String getUserPassword(){
        String user_password = this.preferences.getString("password", null);
        return user_password;


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


