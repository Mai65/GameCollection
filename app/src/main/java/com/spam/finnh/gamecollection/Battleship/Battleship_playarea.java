package com.spam.finnh.gamecollection.Battleship;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.spam.finnh.gamecollection.R;


public class Battleship_playarea extends AppCompatActivity {

    public boolean turn;
    public int field_a[][];
    public int field_b[][];
    public int round;
    int maxX = 0;
    int maxY = 0;
    int xLocation = 0;
    int yLocation = 0;


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
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            xLocation = (int) event.getX();
            yLocation = (int) event.getY();
            setBoats(null);
            String text = +xLocation + "und" + yLocation;
            Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        }
        return super.onTouchEvent(event);

    }

    public void Screen() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int maxX = size.x;
        int maxY = size.y;
    }

    public void setBoats(View view) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));

        if (xLocation < 100) {
            ImageView imageViewA1 = new ImageView(this);
            imageViewA1.setImageResource(R.drawable.battleship_blue);
            imageViewA1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));

            linearLayout.addView(imageViewA1);
            setContentView(linearLayout);
        } else {
            ImageView imageViewA2 = new ImageView(this);
            imageViewA2.setImageResource(R.drawable.battleship_red);
            imageViewA2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));

            linearLayout.addView(imageViewA2);
            setContentView(linearLayout);
        }
    }
}