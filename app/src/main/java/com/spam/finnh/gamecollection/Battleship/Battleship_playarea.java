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

    //Array where boats are on the filed for reload
    public boolean turn;
    public int field_a[][];
    public int field_b[][];
    public int round;

    //Coordinates where you touch on the Screen
    float xLocation = 0;
    float yLocation = 0;

    //Max Coordinates on the screen (=resolution of the screen)
    float maxX;
    float maxY;

    //Calculated Positions in percentual values
    float XcalculatedPosition;
    float YcalculatedPosition;

    //Attributes of the boats
    float height;
    float width;

    public Battleship_playarea() {
        turn = false;
        round = 0;

        //Field of player A (10/10)
        field_a = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; i < 10; i++) {
                field_a[i][j] = 0;
            }
        }

        //Field of player B (10/10)
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

        //Read the Layout of the player
        Layout = findViewById(R.id.layout);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //Get the onTouch coordinates
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            xLocation = event.getX();
            yLocation = event.getY();

            //Get the max sizes
            Screen();

            //Set the width/height of the images
            ImageSize();

            //Set the boats in the Layout
            setBoats(null);

            //Toast out the Coordinates
            String text = +XcalculatedPosition + "und" + YcalculatedPosition;
            Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        }
        return super.onTouchEvent(event);
    }

    public void Screen() {
        //Preferences of all screens
        //10x10 lines
        //x start at 0,10, finish at 0,97 -> 0,08 per box
        //y start at 0,25 finish at 0,78 -> 0,055 per box

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        maxX = size.x;
        maxY = size.y;

        //Calculate the percentage values
        XcalculatedPosition = (xLocation / maxX);
        YcalculatedPosition = (yLocation / maxY);
    }

    public void ImageSize() {
        //set the boat size in relation to the screen size
        width = (float) ((maxX*0.19)-(maxX*0.1));
        height = (float) ((maxY*0.305)- (maxY*0.25));
    }

    public void setBoats(View view) {

        if (XcalculatedPosition > 0.1 && XcalculatedPosition < 0.19 && YcalculatedPosition > 0.25 && YcalculatedPosition < 0.305) {

            //Create a new boat and get the colour of the boat
            ImageView imageViewA1 = new ImageView(this);
            imageViewA1.setImageResource(R.drawable.battleship_blue);

            //Set the coordinates of the boat (top-left corner has to be used)
            imageViewA1.setX((float) (0.11*maxX));
            imageViewA1.setY((float) (0.26*maxY));

            //Set the width and height of the boat with the variables of ImageSize()
            imageViewA1.setLayoutParams(new RelativeLayout.LayoutParams((int) width,
                    (int) height));

            //Add the ImageView to the Layout
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