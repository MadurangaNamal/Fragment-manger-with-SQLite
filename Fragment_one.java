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
public class Fragment_one extends Fragment {

    EditText inserttSid,insertName,insertAge;
    Button btn;
    public Fragment_one() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_one, container, false);

        final DBHandler dbHandler=new DBHandler(getContext());

        View v = inflater.inflate(R.layout.fragment_one, container, false);

        inserttSid = (EditText)v.findViewById(R.id.insertSid);
        insertName = (EditText)v.findViewById(R.id.insertName);
        insertAge = (EditText)v.findViewById(R.id.insertAge);

        btn = (Button)v.findViewById(R.id.insertBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHandler.addStudent(new Student(Integer.parseInt(inserttSid.getText().toString()),
                        insertName.getText().toString(), Integer.parseInt(insertAge.getText().toString())));

                Toast.makeText(getContext(), "Record "+inserttSid.getText()+" added!", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
        //step 15 code end
    }

}
