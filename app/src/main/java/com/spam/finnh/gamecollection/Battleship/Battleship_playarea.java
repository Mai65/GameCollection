package com.spam.finnh.gamecollection.Battleship;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.spam.finnh.gamecollection.R;


public class Battleship_playarea extends AppCompatActivity {

    public boolean turn;
    public int field[][];
    public int round;

    public Battleship_playarea() {
        turn = false;
        round = 0;
        field = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; i < 10; i++) {
                field[i][j] = 0;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.battleship_playarea_start_a);
    }
}
