package com.spam.finnh.gamecollection.TicTacToe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.spam.finnh.gamecollection.R;

public class TicTacToe_playarea extends AppCompatActivity {
    public boolean turn;
    public int field[][];
    public int round;

    public TicTacToe_playarea() {
        turn = false;
        round = 0;
        field = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; i < 3; i++) {
                field[i][j] = 0;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tictactoe_activity_playarea);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        changeColor(prefs);
    }

    public void touched(View view) {
        Button button = (Button) view;
        if (!button.isEnabled()) {
            return;
        }
        button.setEnabled(false);
        switch (view.getId()) {
            case R.id.button1:
                if (turn) {
                    button.setText("X");
                    field[0][0] = 1;
                } else {
                    button.setText("0");
                    field[0][0] = 2;
                }
                break;
            case R.id.button12:
                if (turn) {
                    button.setText("X");
                    field[0][1] = 1;
                } else {
                    button.setText("0");
                    field[0][1] = 2;
                }
                break;
            case R.id.button13:
                if (turn) {
                    button.setText("X");
                    field[0][2] = 1;
                } else {
                    button.setText("0");
                    field[0][2] = 2;
                }
                break;
            case R.id.button14:
                if (turn) {
                    button.setText("X");
                    field[1][0] = 1;
                } else {
                    button.setText("0");
                    field[1][0] = 2;
                }
                break;
            case R.id.button15:
                if (turn) {
                    button.setText("X");
                    field[1][1] = 1;
                } else {
                    button.setText("0");
                    field[1][1] = 2;
                }
                break;
            case R.id.button16:
                if (turn) {
                    button.setText("X");
                    field[1][2] = 1;
                } else {
                    button.setText("0");
                    field[1][2] = 2;
                }
                break;
            case R.id.button7:
                if (turn) {
                    button.setText("X");
                    field[2][0] = 1;
                } else {
                    button.setText("0");
                    field[2][0] = 2;
                }
                break;
            case R.id.button8:
                if (turn) {
                    button.setText("X");
                    field[2][1] = 1;
                } else {
                    button.setText("0");
                    field[2][1] = 2;
                }
                break;
            case R.id.button9:
                if (turn) {
                    button.setText("X");
                    field[2][2] = 1;
                } else {
                    button.setText("0");
                    field[2][2] = 2;
                }
                break;
        }
        check();
        turn = !turn;
        round++;
        if (round >= 9) {
            nobodyWon();
        }
    }

    private void check() {
        checkRow();
        checkColumn();
        checkDiagonal();
    }

    public void checkRow() {

        if (field[0][0] != 0 && field[0][1] == field[0][0] && field[0][2] == field[0][0]) {
            won();
        }

        if (field[1][0] != 0 && field[1][1] == field[1][0] && field[1][2] == field[1][0]) {
            won();
        }
        if (field[2][0] != 0 && field[2][1] == field[2][0] && field[2][2] == field[2][0]) {
            won();
        }

    }

    public void checkColumn() {
        if (field[0][0] != 0 && field[1][0] == field[0][0] && field[2][0] == field[0][0]) {
            won();
        }
        if (field[0][1] != 0 && field[1][1] == field[0][1] && field[2][1] == field[0][1]) {
            won();
        }
        if (field[0][2] != 0 && field[1][2] == field[0][2] && field[2][2] == field[0][2]) {
            won();
        }

    }

    public void checkDiagonal() {
        if (field[0][0] != 0 && field[1][1] == field[0][0] && field[2][2] == field[0][0]) {
            won();
        }
        if (field[2][0] != 0 && field[1][1] == field[2][0] && field[0][2] == field[2][0]) {
            won();
        }
    }

    private void nobodyWon() {
        Intent intent;
        intent = new Intent(this, TicTacToe_popwindow.class);
        intent.putExtra("com.example.danielkerger.gamecollection.nobodyWon", true);
        startActivity(intent);
        finish();
    }

    public void won() {
        Intent intent;
        intent = new Intent(this, TicTacToe_popwindow.class);
        intent.putExtra("com.example.danielkerger.gamecollection.won", turn);
        startActivity(intent);
        finish();
    }

    private void changeColor(SharedPreferences sharedPreferences) {
        String selected = sharedPreferences.getString("colour", getString(R.string.color_white));
        if (selected.equalsIgnoreCase(getString(R.string.color_yellow))) {
            findViewById(R.id.imageView).getRootView().getRootView().setBackgroundColor(getResources().getColor(R.color.yellow));
        } else if (selected.equalsIgnoreCase(getString(R.string.color_blue))) {//wtf
            findViewById(R.id.imageView).getRootView().setBackgroundColor(getResources().getColor(R.color.blue));
        } else if (selected.equalsIgnoreCase(getString(R.string.color_white))) {
            findViewById(R.id.button1).getRootView().setBackgroundColor(getResources().getColor(R.color.white));
        }
    }
}