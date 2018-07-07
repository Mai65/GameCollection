package com.spam.finnh.gamecollection.Battleship;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.spam.finnh.gamecollection.R;

public class Battleship_chooseBoat extends AppCompatActivity {

    boolean boat;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.battleship_chooseboat);
    }

    public void chooseBoat(View view) {
        Intent intent;
        intent = new Intent(this, Countdown.class);
        boat = false;
        switch (view.getId()) {
            case R.id.blueTeam:
                intent.putExtra("boat", true);
                break;
            case R.id.redTeam:
                intent.putExtra("boat", false);
                break;
                }
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}