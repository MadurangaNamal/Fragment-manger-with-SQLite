package com.example.user.app15;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_four extends Fragment {

        EditText delSid;
        Button b;
    public Fragment_four() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      //  return inflater.inflate(R.layout.fragment_four, container, false);
        final DBHandler dbHandler = new DBHandler(getContext());

        View v = inflater.inflate(R.layout.fragment_four, container, false);

        delSid = (EditText)v.findViewById(R.id.delSid);
        b = (Button)v.findViewById(R.id.delBtn);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHandler.deleteStudents(Integer.parseInt(delSid.getText().toString()));

                Toast.makeText(getContext(), "Record "+delSid.getText()+" deleted!", Toast.LENGTH_SHORT).show();
            }
        });
        return v;

    }
}
