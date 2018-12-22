package com.jzap.turingmachine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        List<Boolean> initalData = new ArrayList<>();
        initalData.add(false);
        initalData.add(true);
        initalData.add(true);

        TuringMachine t = new TuringMachine(State.A, initalData);
        int x = 0;
    }
}
