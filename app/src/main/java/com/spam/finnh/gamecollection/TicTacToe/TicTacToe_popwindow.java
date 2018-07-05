package com.spam.finnh.gamecollection.TicTacToe;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

import com.spam.finnh.gamecollection.Menues.MainActivity;
import com.spam.finnh.gamecollection.R;

public class TicTacToe_popwindow extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tictactoe_activity_wonscreen);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        changeColor(prefs);

        Intent intent;
        intent = getIntent();
        boolean NobodyWon;
        NobodyWon = intent.getBooleanExtra("com.example.danielkerger.gamecollection.nobodyWon", false);
        TextView textfield;
        textfield = findViewById(R.id.textView);
        if (NobodyWon) {
            textfield.setText(getString((R.string.draw)));
        } else {
            boolean WhoWon;
            WhoWon = intent.getBooleanExtra("com.example.danielkerger.gamecollection.won", false);
            if (WhoWon) {
                textfield.setText(getString(R.string.player_won_X));
            } else {
                textfield.setText(getString(R.string.player_won_0));
            }
        }
    }

    public void playAgain(View view) {
        Intent intent;
        intent = new Intent(this, TicTacToe_playarea.class);
        startActivity(intent);
        finish();
    }

    public void chooseGame(View view) {
        Intent intent;
        intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void changeColor(SharedPreferences sharedPreferences) {
        String selected = sharedPreferences.getString("colour", getString(R.string.color_white));
        if (selected.equalsIgnoreCase(getString(R.string.color_yellow))) {
            findViewById(R.id.button10).getRootView().setBackgroundColor(getResources().getColor(R.color.yellow));
        } else if (selected.equalsIgnoreCase(getString(R.string.color_blue))) {
            findViewById(R.id.button10).getRootView().setBackgroundColor(getResources().getColor(R.color.blue));
        } else if (selected.equalsIgnoreCase(getString(R.string.color_white))) {
            findViewById(R.id.button10).getRootView().setBackgroundColor(getResources().getColor(R.color.white));
        }
    }


}