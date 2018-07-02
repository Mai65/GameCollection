package com.spam.finnh.gamecollection.Connect4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.spam.finnh.gamecollection.Menues.MainActivity;
import com.spam.finnh.gamecollection.R;


public class Connect4_wonScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connect4_activity_wonscreen);

        Intent intent;
        intent = getIntent();
        boolean NobodyWon;
        NobodyWon = intent.getBooleanExtra("com.example.danielkerger.gamecollection.nobodyWon", false);
        TextView textfield;
        textfield = findViewById(R.id.textView);
        if (NobodyWon) {
            textfield.setText(R.string.draw);
        } else {
            boolean WhoWon;
            WhoWon = intent.getBooleanExtra("com.example.danielkerger.gamecollection.won", false);
            if (WhoWon) {
                textfield.setText(getString(R.string.player_red_won));
            } else {
                textfield.setText(getString(R.string.player_yellow_won));
            }
        }
    }

    public void playAgain(View view) {
        Intent intent;
        intent = new Intent(this, Connect4_playarea.class);
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