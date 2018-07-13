package com.spam.finnh.gamecollection.Battleship;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;

import com.spam.finnh.gamecollection.R;

public class Battleship_chooseBoat extends AppCompatActivity {

    float xLocation = 0;
    float yLocation = 0;
    float maxX;
    float maxY;
    float XcalculatedPosition;
    float YcalculatedPosition;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.battleship_chooseboat);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //Get the onTouch coordinates
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            xLocation = event.getX();
            yLocation = event.getY();
            Screen();
            chooseBoat(null);
        }
        return super.onTouchEvent(event);
    }

    public void Screen() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        maxX = size.x;
        maxY = size.y;
        XcalculatedPosition = (xLocation / maxX);
        YcalculatedPosition = (yLocation / maxY);

    }
    public void chooseBoat(View view) {
        Intent intent;
        intent = new Intent(this, Countdown.class);
        if (XcalculatedPosition > 0 && XcalculatedPosition < 0.45 && YcalculatedPosition > 0.6 && YcalculatedPosition < 1) {
            intent.putExtra("boat", true);
            startActivity(intent);
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        } else if (XcalculatedPosition > 0.55 && XcalculatedPosition < 1 && YcalculatedPosition > 0.6 && YcalculatedPosition < 1) {
            intent.putExtra("boat", false);
            startActivity(intent);
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    }
}