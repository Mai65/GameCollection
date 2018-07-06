package com.spam.finnh.gamecollection.Battleship;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.spam.finnh.gamecollection.R;


public class Battleship_playarea extends AppCompatActivity {

    public boolean turn;
    public int field_a[][];
    public int field_b[][];
    public int round;

    public Battleship_playarea() {
        turn = false;
        round = 0;
        field_a = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; i < 10; i++) {
                field_a[i][j] = 0;
            }
        }

        field_b = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; i < 10; i++) {
                field_b[i][j] = 0;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.battleship_playarea_start_a);
    }

    public void setBoats(View view) {
        Button button = (Button) view;
        if (!button.isEnabled()) {
            return;
        }
        button.setEnabled(false);
        switch (view.getId()) {
            case R.id.button_A1:
                button.setText("X");
                break;
            case R.id.button_A2:
                button.setText("0");
                break;
        }
    }
}
