package com.spam.finnh.gamecollection.Battleship;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.spam.finnh.gamecollection.R;

public class Battleship_chooseBoat extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.battleship_chooseboat);
    }

    boolean boat;

    public void chooseBoat(View view) {
        boat = false;
        switch (view.getId()) {
            case R.id.blueTeam:
                boat = true;
                break;
            case R.id.redTeam:
                boat = true;

        }
        Intent intent;
        intent = new Intent(this, Countdown.class);
        intent.putExtra("com.spam.finnh.gamecollection.boat", boat);
        startActivity(intent);
    }
}