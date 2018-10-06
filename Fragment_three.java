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
public class Fragment_three extends Fragment {

    EditText updSid,updName,updAge;
    Button bt;
    public Fragment_three() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_three, container, false);
        final DBHandler dbHandler = new DBHandler(getContext());

        View v = inflater.inflate(R.layout.fragment_three, container, false);

        updSid = (EditText)v.findViewById(R.id.updSid);
        updName = (EditText)v.findViewById(R.id.updName);
        updAge = (EditText)v.findViewById(R.id.updAge);

        bt = (Button)v.findViewById(R.id.updBtn);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHandler.updateStudents(new Student(Integer.parseInt(updSid.getText().toString()),
                        updName.getText().toString(), Integer.parseInt(updAge.getText().toString())));

                Toast.makeText(getContext(), "Record "+updSid.getText()+" updated!", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
}
