package com.example.e440.functional_navdrawer;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private NetworkManager networkManager;
    private CredentialsManager credentialsManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        networkManager = NetworkManager.getInstance(this);
        initializeDatabase();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();


                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();


                        if (menuItem.getItemId()==R.id.nav_new_form){
                            ft.replace(R.id.fragment_space, new NewFormFragment());

                        }
                        else if (menuItem.getItemId()==R.id.nav_view_forms){

                            ft.replace(R.id.fragment_space,new FormListFragment());

                        }

                        ft.commit();

                        return true;
                    }
                });
        credentialsManager=CredentialsManager.getInstance(this);



        if(credentialsManager.getToken()==null){

            launchLogin();
        }





    }

    public void launchLogin(){

        Intent intent = new Intent(this,Login.class);

        startActivityForResult(intent,1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Context context = getApplicationContext();
        setContentView(R.layout.activity_main);

        if (requestCode == 1) {  //is from login
            if(resultCode == Activity.RESULT_OK){

                CharSequence text = "Logueado con éxito";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                getForms();

            }
            if (resultCode == Activity.RESULT_CANCELED) {
                finish();
            }
        }




    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    void initializeDatabase(){
        DatabaseManager.formDatabase = Room.databaseBuilder(getApplicationContext(),
                FormDatabase.class, DatabaseManager.DATABASE_NAME).fallbackToDestructiveMigration()
                .build();
    }


    private void getForms(){
        networkManager.getForms(new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                System.out.println(response);

                try {
                    JSONArray resp = response.getJSONArray("0");
                    for(int i = 0 ; i < resp.length() ; i++){
                        JSONObject jo = resp.getJSONObject(i);

                        System.out.println(jo.toString());
                    }
                }
                catch(JSONException e) {

                    System.out.println(e.getMessage());
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO: Handle error
                System.out.println(error);
            }
        });
    }

}
