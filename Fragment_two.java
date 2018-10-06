package com.example.user.app15;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_two extends Fragment {

ListView listStudents;
    ArrayAdapter adp;
    public Fragment_two() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    //   return inflater.inflate(R.layout.fragment_two, container, false);
        final DBHandler dbHandler = new DBHandler(getContext());

        View v = inflater.inflate(R.layout.fragment_two, container, false);

        listStudents = (ListView)v.findViewById(R.id.listStudents);

        dbHandler.getAllStudents();
        adp = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, dbHandler.getAllStudents());
        listStudents.setAdapter(adp);

        return v;
    }
}
