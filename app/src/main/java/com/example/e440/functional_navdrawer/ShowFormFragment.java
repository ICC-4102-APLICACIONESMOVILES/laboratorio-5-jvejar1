package com.example.e440.functional_navdrawer;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by e440 on 24-04-18.
 */

public class ShowFormFragment extends Fragment {

    View inflatedView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflatedView = inflater.inflate(R.layout.show_form_fragment, container, false);

        if (getArguments() != null) {
            String name = getArguments().getString("name");

            int fields = getArguments().getInt("fields");
            String created_at = getArguments().getString("created_at");


            TextView formNameTextView= inflatedView.findViewById(R.id.formNameTextView);
            formNameTextView.setText(name);
            TextView formFieldsTextView = inflatedView.findViewById(R.id.formFieldsTextView);
            formFieldsTextView.setText("Total fields: "+fields);
            TextView formDateTextView = inflatedView.findViewById(R.id.formDateTextView);
            formDateTextView.setText("Created at: "+created_at);

        }

        return inflatedView;

    }

    }
