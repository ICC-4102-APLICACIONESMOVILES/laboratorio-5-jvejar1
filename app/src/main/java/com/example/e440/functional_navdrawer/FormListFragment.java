package com.example.e440.functional_navdrawer;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by e440 on 09-04-18.
 */


public class FormListFragment extends Fragment {
    Form[] allForms;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.view_forms, container, false);


        Thread thread = new Thread(){
            public void run(){

                allForms =DatabaseManager.formDatabase.daoAccess().fetchAllForms();

                   }
        };
        thread.start();
        try
        {
            thread.join();
        }catch(InterruptedException ie)
        {
            //Log message if required.
        }

        final ListView formsListView = rootView.findViewById(R.id.formsListView);

        /* List<String> formsArray =  new ArrayList<>();

        for (Form form:allForms
                ) {
            formsArray.add("Name: "+form.getFormName()+"\nCategory: "+ form.getFormCategory()+"\nComment: "+form.getFormComment());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,formsArray);

        formsListView.setAdapter(adapter);*/

        ListAdapter customAdapter = new ListAdapter(getContext(), R.layout.form_list_item, Arrays.asList(allForms));
        formsListView.setAdapter(customAdapter);
        formsListView.setClickable(true);
        formsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                // When clicked, show a toast with the TextView text
                int selectedFormId = (int)formsListView.getItemIdAtPosition(position);
                int a  = 5;

                 }
        });
        return rootView;

    }



}
