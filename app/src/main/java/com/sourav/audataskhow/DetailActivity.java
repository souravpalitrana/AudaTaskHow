package com.sourav.audataskhow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

public class DetailActivity extends AppCompatActivity {
    FragmentView fragment;
    FrameLayout frame;


    boolean firstFragmentStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        frame = (FrameLayout) findViewById(R.id.frame_main1);

        if (frame == null || savedInstanceState == null) {
            fragment = new FragmentView();
            getSupportFragmentManager().beginTransaction().add(R.id.frame_main1, fragment).commit();
            firstFragmentStatus = true;
        }


    }

}