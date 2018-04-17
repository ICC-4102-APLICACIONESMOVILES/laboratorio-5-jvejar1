package com.example.e440.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        Intent intent = getIntent();

    }

    public void returnToMain(){
        Intent returnIntent = new Intent();
        setResult(Activity.RESULT_OK,returnIntent);
        finish();

    }


    public void loginButtonClick(View view){
        Context context = getApplicationContext();
        //Get the user and password to check if they are valids

        EditText userEditText = (EditText) findViewById(R.id.userEditText);
        String user = userEditText.getText().toString();

        EditText passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        String password = passwordEditText.getText().toString();


        //
        Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher mat = pattern.matcher(user);

        if(mat.matches() && password.trim().length()>0){

            System.out.println("Valid email address");

            CredentialsManager credentialsManager = new CredentialsManager(context);
            credentialsManager.saveCredentials(user,password);
            returnToMain();

        }else{

            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context,"Campos invalidos",duration);
            toast.show();
        }


        //

        //Assuming that the inputs are valid,store the data to shared preferences



    }



    public void validateCredentials(View view){

    }

    @Override
    public void onBackPressed() {
        Intent returnIntent = new Intent();
        setResult(Activity.RESULT_CANCELED,returnIntent);
        finish();

    }





}

