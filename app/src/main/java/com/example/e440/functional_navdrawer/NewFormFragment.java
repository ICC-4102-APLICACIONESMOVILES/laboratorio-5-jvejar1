package com.example.e440.functional_navdrawer;



/**
 * Created by e440 on 27-03-18.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.DateTimeKeyListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewFormFragment extends Fragment {
    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    View rootView ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        rootView = inflater.inflate(R.layout.new_form, parent, false);
        Spinner spinner1 =rootView.findViewById(R.id.formCategorySpinner);
        List<String> spinnerArray =  new ArrayList<>();
        spinnerArray.add("Encuesta");
        spinnerArray.add("Inspeccion");
        spinnerArray.add("Reporte");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(),android.R.layout.simple_spinner_dropdown_item,spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);

        Button submitFormButton = rootView.findViewById(R.id.submitFormButton);
        submitFormButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText formNameEditText = rootView.findViewById(R.id.formNameEditText);
                EditText formCommentEditText = rootView.findViewById(R.id.formCommentEditText);
                Spinner formCategorySpinner = rootView.findViewById(R.id.formCategorySpinner);

                final String formCategory = formCategorySpinner.getSelectedItem().toString();
                final String formName = formNameEditText.getText().toString();
                final String formComment = formCommentEditText.getText().toString();
                final String formDate = (new Date()).toString();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Form form =new Form();
                        form.setFormName(formName);
                        form.setFormComment(formComment);
                        form.setFormCategory(formCategory);
                        form.setFormDateText(formDate);
                        DatabaseManager.formDatabase.daoAccess () . insertOnlySingleForm (form);

                        Form[] allForms =DatabaseManager.formDatabase.daoAccess().fetchAllForms();
                        int a =5;

                    }
                }) .start();
            }
        });

        return rootView;
    }


    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
    }


}

