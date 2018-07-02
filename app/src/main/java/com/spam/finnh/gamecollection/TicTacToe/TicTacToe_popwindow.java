package com.spam.finnh.gamecollection.TicTacToe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.spam.finnh.gamecollection.Menues.MainActivity;
import com.spam.finnh.gamecollection.R;

public class TicTacToe_popwindow extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tictactoe_activity_wonscreen);

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


}