package com.jzap.turingmachine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TuringMachineUI {

    TuringMachine mTuringMachine;

    TextView l2Text;
    TextView l1Text;
    TextView middleText;
    TextView r1Text;
    TextView r2Text;

    Button leftButton;
    Button rightButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        initTuringMachine();
    }

    private void initUI() {
        l2Text = findViewById(R.id.l2_text);
        l1Text = findViewById(R.id.l1_text);
        middleText = findViewById(R.id.middle_text);
        l2Text = findViewById(R.id.l2_text);
        r1Text = findViewById(R.id.r1_text);
        r2Text = findViewById(R.id.r2_text);

        leftButton = findViewById(R.id.left_button);
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTuringMachine.moveHead(Direction.LEFT);
                updateTape();
            }
        });

        rightButton = findViewById(R.id.right_button);
        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTuringMachine.moveHead(Direction.RIGHT);
                updateTape();
            }
        });
    }

    private void initTuringMachine() {
        List<Boolean> initalData = new ArrayList<>();
        initalData.add(false);
        initalData.add(true);
        initalData.add(true);

        HashMap<Boolean, HashMap<State, Instruction<Boolean>>> instructions = new HashMap<>();

        HashMap<State, Instruction<Boolean>> trueInstructions = new HashMap<>();
        HashMap<State, Instruction<Boolean>> falseInstructions = new HashMap<>();
        HashMap<State, Instruction<Boolean>> blankInstructions = new HashMap<>();

        trueInstructions.put(State.A, new Instruction<Boolean>(Action.WRITE, false, State.HALT, Direction.RIGHT));
        trueInstructions.put(State.B, new Instruction<Boolean>(Action.WRITE, false, State.HALT, Direction.RIGHT));
        falseInstructions.put(State.A, new Instruction<Boolean>(Action.WRITE, true, State.B, Direction.RIGHT));
        falseInstructions.put(State.B, new Instruction<Boolean>(Action.WRITE, true, State.HALT, Direction.RIGHT));
        blankInstructions.put(State.A, new Instruction<Boolean>(Action.NONE, null, State.HALT, Direction.RIGHT));
        blankInstructions.put(State.B, new Instruction<Boolean>(Action.WRITE, true, State.HALT, Direction.RIGHT));

        instructions.put(true, trueInstructions);
        instructions.put(false, falseInstructions);
        instructions.put(null, blankInstructions);

        mTuringMachine = new TuringMachine(State.A, initalData, instructions, this);

        updateTape();

        mTuringMachine.run();
    }

    public void updateTape() {
        String middleValue = "";
        if(mTuringMachine.getTape().getCurrentCell().data != null) {
            middleValue = mTuringMachine.getTape().getCurrentCell().data.toString();
        }
        middleText.setText(middleValue);

        String l1Value = "";
        Tape.Node l1Cell = mTuringMachine.getTape().getCurrentCell().previous;
        if(l1Cell != null && l1Cell.data != null) {
            l1Value = l1Cell.data.toString();
        }
        l1Text.setText(l1Value);

        String l2Value = "";
        if(l1Cell != null) {
            Tape.Node l2Cell =l1Cell.previous;
            if(l2Cell != null && l2Cell.data != null) {
                l2Value = l2Cell.data.toString();
            }
        }
        l2Text.setText(l2Value);

        String r1Value = "";
        Tape.Node r1Cell = mTuringMachine.getTape().getCurrentCell().next;
        if(r1Cell != null && r1Cell.data != null) {
            r1Value = r1Cell.data.toString();
        }
        r1Text.setText(r1Value);

        String r2Value = "";
        if(r1Cell != null) {
            Tape.Node r2Cell = r1Cell.next;
            if(r2Cell != null && r2Cell.data!= null) {
                r2Value = r2Cell.data.toString();
            }
        }
        r2Text.setText(r2Value);
    }

}
