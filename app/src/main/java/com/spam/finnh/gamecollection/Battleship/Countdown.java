package com.spam.finnh.gamecollection.Battleship;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.spam.finnh.gamecollection.R;

public class Countdown extends AppCompatActivity {
    private TextView time;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.battleship_countdown);
        time = findViewById(R.id.battleship_timer);
        start();
    }

    public void start() {

        time.setText(R.string.number_six);

        countDownTimer = new CountDownTimer(6 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time.setText("" + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                startGame();
            }
        };
         countDownTimer.start();
    }

    public void startGame() {
        Intent intent;
        intent = new Intent(this, Battleship_playarea.class);
        startActivity(intent);
    }
    //#h
}