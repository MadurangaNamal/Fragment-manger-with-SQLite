package com.example.user.app15;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void FragBtn1Clicked(View view) {
        //step 6 code start
        FragmentManager mng = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = mng.beginTransaction();
        transaction.replace(R.id.detailsFragment, new Fragment_one());
        transaction.commit();
        //step 6 code end
    }
    public void FragBtn2Clicked(View view) {
        FragmentManager mng = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = mng.beginTransaction();
        transaction.replace(R.id.detailsFragment, new Fragment_two());
        transaction.commit();
    }
    public void FragBtn3Clicked(View view) {
        FragmentManager mng = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = mng.beginTransaction();
        transaction.replace(R.id.detailsFragment, new Fragment_three());
        transaction.commit();
    }

   public void FragBtn4Clicked(View view) {
        FragmentManager mng = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = mng.beginTransaction();
        transaction.replace(R.id.detailsFragment, new Fragment_four());
        transaction.commit();
    }
}
