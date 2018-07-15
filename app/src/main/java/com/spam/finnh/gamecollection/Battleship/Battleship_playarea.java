package com.spam.finnh.gamecollection.Battleship;

import android.graphics.Point;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.spam.finnh.gamecollection.R;


public class Battleship_playarea extends AppCompatActivity {

    ConstraintLayout Layout;

    //How is playing (true = A --- false = b)
    boolean turn;

    //Array where boats are on the filed for reload
    int field_a[][];
    int field_b[][];
    int round;
    int letter;
    int number;

    //Type of the boat and boolean if a boat is choosen by the player
    int boatsLeft;
    boolean boatSelected = false;
    int boatType5Left = 1;
    int boatType4Left = 2;
    int boatType3Left = 3;
    int boatType2Left = 4;

    //Booleans for which boat was selected
    boolean boatType5 = false;
    boolean boatType4 = false;
    boolean boatType3 = false;
    boolean boatType2 = false;

    //Explanation of the int's in the fields:
    //0 = No boat
    //2 - 5 = boat
    //2 = destroyed boat
    int noBoat = 0;
    int fieldBoat2 = 2;
    int fieldBoat3 = 3;
    int fieldBoat4 = 4;
    int fieldBoat5 = 5;
    int destroyedBoat = 50;

    //Coordinates where you touch on the Screen
    float xLocation = 0;
    float yLocation = 0;

    //Max Coordinates on the screen (=resolution of the screen)
    float maxX;
    float maxY;

    //Calculated Positions in percentual values
    float XcalculatedPosition;
    float YcalculatedPosition;

    //Percentage position of box
    float xPercentage;
    float yPercentage;

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

        //Check if a boat has been choosen by the player
        if (boatSelected) {

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
            }
        } else {

            //Toast out an error, that no boat has been choosen before touching the playarea
            String noBoatSelected = getString(R.string.noBoatSelected);
            Toast.makeText(this, noBoatSelected, Toast.LENGTH_LONG).show();
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
        width = (float) ((maxX * 0.19) - (maxX * 0.1));
        height = (float) ((maxY * 0.305) - (maxY * 0.25));
    }

    public void setBoats(View view) {

        if (XcalculatedPosition > 0.1 && XcalculatedPosition < 0.19 && YcalculatedPosition > 0.25 && YcalculatedPosition < 0.305) {
            ImageView imageViewA1 = new ImageView(this);

            //Set the correct box with the letter and number
            letter = 0;
            number = 0;

            //Set the percentages of the box
            xPercentage = (float) 0.11;
            yPercentage = (float) 0.26;
            checkTurn(imageViewA1);

        } else if (XcalculatedPosition > 0.19 && XcalculatedPosition < 0.27 && YcalculatedPosition > 0.25 && YcalculatedPosition < 0.305) {
            ImageView imageViewA2 = new ImageView((this));

            //Set the correct box with the letter and number
            letter = 0;
            number = 1;

            //Set the percentages of the box
            xPercentage = (float) 0.19;
            yPercentage = (float) 0.26;
            checkTurn(imageViewA2);

        } else if (XcalculatedPosition > 0.27 && XcalculatedPosition < 0.35 && YcalculatedPosition > 0.25 && YcalculatedPosition < 0.305) {
            ImageView imageViewA3 = new ImageView((this));

            //Set the correct box with the letter and number
            letter = 0;
            number = 2;

            //Set the percentages of the box
            xPercentage = (float) 0.27;
            yPercentage = (float) 0.26;
            checkTurn(imageViewA3);

        } else if (XcalculatedPosition > 0.35 && XcalculatedPosition < 0.43 && YcalculatedPosition > 0.25 && YcalculatedPosition < 0.305) {
            ImageView imageViewA4 = new ImageView((this));

            //Set the correct box with the letter and number
            letter = 0;
            number = 3;

            //Set the percentages of the box
            xPercentage = (float) 0.35;
            yPercentage = (float) 0.26;
            checkTurn(imageViewA4);
        }
    }

    public void createBoat(ImageView imageView) {
        //Create a new boat and get the kind of boat
        if (boatType2) {
            imageView.setImageResource(R.drawable.schlauchboot_oben);
            if (turn) {
                field_a[letter][number] = fieldBoat2;
            } else {
                field_b[letter][number] = fieldBoat2;
            }
            boatType2 = false;

        } else if (boatType3) {
            imageView.setImageResource(R.drawable.schlauchboot_unten);
            if (turn) {
                field_a[letter][number] = fieldBoat3;
            } else {
                field_b[letter][number] = fieldBoat3;
            }
            boatType3 = false;

        } else if (boatType4) {
            imageView.setImageResource(R.drawable.battleship_red);
            if (turn) {
                field_a[letter][number] = fieldBoat4;
            } else {
                field_b[letter][number] = fieldBoat4;
            }
            boatType4 = false;

        } else if (boatType5) {
            imageView.setImageResource(R.drawable.battleship_blue);
            if (turn) {
                field_a[letter][number] = fieldBoat4;
            } else {
                field_b[letter][number] = fieldBoat4;
            }
            boatType5 = false;
        }

        //Set the coordinates of the boat (top-left corner has to be used)
        imageView.setX((xPercentage * maxX));
        imageView.setY((yPercentage * maxY));

        //Set the width and height of the boat with the variables of ImageSize()
        imageView.setLayoutParams(new RelativeLayout.LayoutParams((int) width,
                (int) height));

        //Add the ImageView to the Layout
        Layout.addView(imageView);
        setContentView(Layout);

    }

    public void completeBoat() {
        if (boatType2) {
            boatType2 = false;
        } else if (boatType3) {
            boatType3 = false;
        } else if (boatType4) {
            boatType4 = false;
        } else if (boatType5) {
            boatType5 = false;
        }
    }

    public void checkTurn(ImageView imageView) {
        //Check who's turn is
        if (turn) {
            //Check if there is already something on the box
            if (field_a[letter][number] != noBoat) {
                //Generate Toast with Error message "Occupied Field"
                String fieldOccupied = getString(R.string.field_occupied);
                Toast.makeText(this, fieldOccupied, Toast.LENGTH_LONG).show();
                //Let the player choose another box
            } else {
                createBoat(imageView);
            }
        } else {
            if (field_b[letter][number] != noBoat) {
                //Generate Toast with Error message "Occupied Field"
                String fieldOccupied = getString(R.string.field_occupied);
                Toast.makeText(this, fieldOccupied, Toast.LENGTH_LONG).show();
                //Let the player choose another box
            } else {
                createBoat(imageView);
            }
        }
    }

    public void selectType(View view) {
        //Create Button and String (= which boast has been choosen)
        String whichBoat;
        ImageButton button = (ImageButton) view;

        //Change the button id depending on which type has been choosen
        switch (view.getId()) {
            case R.id.five:
                //Size of the boat
                boatsLeft = 5;
                boatSelected = true;
                boatType5 = true;

                //Toast out which type has been choosen
                whichBoat = getString(R.string.five_boat);
                Toast.makeText(this, whichBoat, Toast.LENGTH_LONG).show();
                boatType5Left--;

                //Check if the maximum of boats are placed
                if (boatType5Left == 0) {
                    button.setEnabled(false);
                }
                break;

            case R.id.four:
                //Size of the boat
                boatsLeft = 4;
                boatSelected = true;
                boatType4 = true;

                //Toast out which type has been choosen
                whichBoat = getString(R.string.four_boat);
                Toast.makeText(this, whichBoat, Toast.LENGTH_LONG).show();
                boatType4Left--;

                //Check if the maximum of boats are placed
                if (boatType4Left == 0) {
                    button.setEnabled(false);
                }
                break;


            case R.id.three:

                //Size of the boat
                boatsLeft = 3;
                boatSelected = true;
                boatType3 = true;

                //Toast out which type has been choosen
                whichBoat = getString(R.string.three_boat);
                Toast.makeText(this, whichBoat, Toast.LENGTH_LONG).show();
                boatType3Left--;

                //Check if the maximum of boats are placed
                if (boatType3Left != 0) {
                    button.setEnabled(false);
                }
                break;

            case R.id.two:

                //Size of the boat
                boatsLeft = 2;
                boatSelected = true;
                boatType2 = true;

                //Toast out which type has been choosen
                whichBoat = getString(R.string.two_boat);
                Toast.makeText(this, whichBoat, Toast.LENGTH_LONG).show();
                boatType2Left--;

                //Check if the maximum of boats are placed
                if (boatType2Left != 0) {
                    button.setEnabled(false);
                }
                break;
        }
    }

    public void blinkAnimation(ImageView imageView) {
        Animation animation = new AlphaAnimation(1, 0);
        animation.setDuration(1000);
        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(Animation.REVERSE);
        imageView.startAnimation(animation);
    }

    public void removeBoat(View view) {
        String removeBoat = getString(R.string.remove_boat);
        Toast.makeText(this, removeBoat,Toast.LENGTH_LONG).show();

        if()
    }
}



