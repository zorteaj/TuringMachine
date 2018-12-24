package com.jzap.turingmachine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
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

        HashMap<Boolean, Instruction<Boolean>> instructions = new HashMap<>();
        instructions.put(true, new Instruction<Boolean>(State.A, Action.WRITE, false));
        instructions.put(true, new Instruction<Boolean>(State.B, Action.NONE, null));
        instructions.put(false, new Instruction<Boolean>(State.A, Action.ERASE, null));
        instructions.put(false, new Instruction<Boolean>(State.B, Action.WRITE, true));

        TuringMachine t = new TuringMachine(State.A, initalData, instructions);
        int x = 0;
    }
}
