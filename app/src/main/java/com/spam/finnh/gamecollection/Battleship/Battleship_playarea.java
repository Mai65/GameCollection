package com.spam.finnh.gamecollection.Battleship;

import android.graphics.Point;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.spam.finnh.gamecollection.R;


public class Battleship_playarea extends AppCompatActivity {

    ConstraintLayout Layout;
    public boolean turn;
    public int field_a[][];
    public int field_b[][];
    public int round;
    float xLocation = 0;
    float yLocation = 0;
    float maxX;
    float maxY;
    float XcalculatedPosition;
    float YcalculatedPosition;

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
        Layout = findViewById(R.id.layout);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //Get the onTouch coordinates
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            xLocation = event.getX();
            yLocation = event.getY();
            Screen();
            setBoats(null);
            String text = +XcalculatedPosition + "und" + YcalculatedPosition;
            Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        }
        return super.onTouchEvent(event);
    }

    public void Screen() {
        // 10x10 Kästchen
        // x Start bei 0,10 Ende bei 0,97 -> 0,08 pro Kästchen
        // y Start bei 0,25 Ende bei 0,78 -> 0,055 pro Kästchen
        // 0,08% auf x/y-Achse pro Kästchen
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        maxX = size.x;
        maxY = size.y;
        XcalculatedPosition = (xLocation / maxX);
        YcalculatedPosition = (yLocation / maxY);
    }

    public void setBoats(View view) {

        if (XcalculatedPosition > 0.1 && XcalculatedPosition < 0.19 && YcalculatedPosition > 0.25 && YcalculatedPosition < 0.305) {
            ImageView imageViewA1 = new ImageView(this);
            imageViewA1.setImageResource(R.drawable.battleship_blue);

            imageViewA1.setX(maxX*XcalculatedPosition);
            imageViewA1.setY(maxY*YcalculatedPosition);
            imageViewA1.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT));

            Layout.addView(imageViewA1);
            setContentView(Layout);

        } else if(XcalculatedPosition > 0.19 && XcalculatedPosition < 0.27 && YcalculatedPosition > 0.25 && YcalculatedPosition < 0.305){
            ImageView imageViewA1 = new ImageView(this);
            imageViewA1.setImageResource(R.drawable.battleship_red);

            imageViewA1.setX(maxX*XcalculatedPosition);
            imageViewA1.setY(maxY*YcalculatedPosition);
            imageViewA1.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT));

            Layout.addView(imageViewA1);
            setContentView(Layout);
        }
    }
}