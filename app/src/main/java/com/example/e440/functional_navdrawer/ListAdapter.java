package com.example.e440.functional_navdrawer;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by e440 on 10-04-18.
 */

public class ListAdapter extends ArrayAdapter {
    private int layoutResource;
    public ListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public ListAdapter(Context context, int resource, List<Form> items) {
        super(context, resource, items);
        this.layoutResource=resource;
        }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(layoutResource, null);
        }

        Form p =(Form)getItem(position);
        if (p != null) {
            TextView tt1 = (TextView) v.findViewById(R.id.formNameTextView);
            TextView tt2 = (TextView) v.findViewById(R.id.formCategoryTextView);
            TextView tt3 = (TextView) v.findViewById(R.id.formIdTextView);


            if (tt1 != null) {
                tt1.setText(p.getFormName());
            }

            if (tt2 != null) {
                tt2.setText(p.getFormCategory());
            }

            tt3.setText(p.getFormId()+".-");
            v.setId(p.getFormId());

        }

        return v;
    }

}
