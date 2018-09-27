package com.example.laitianbing.rvadater_master;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void simpleAdapter(View view) {
        SimpleActivity.start(this);
    }

    public void multiAdapter(View view) {
        MultiTypeActivity.start(this);
    }

    public void otherAdapter(View view) {
        ExtraActivity.start(this);
    }
}
