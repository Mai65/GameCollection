package com.spam.finnh.gamecollection.Connect4;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import com.spam.finnh.gamecollection.R;


public class Connect4_playarea extends AppCompatActivity {
    byte buttonCount;
    Button Buttons[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connect4_activity_playarea);
        buttonCount = 0;
        Buttons = new Button[56];
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        changeColor(prefs);
    }


    public void fall(View view) {
        Button button;
        button = (Button) view;

        float bottomOfScreen = getResources().getDisplayMetrics().heightPixels -2000;
        button.animate()
                .translationY(bottomOfScreen)
                .setInterpolator(new AccelerateInterpolator())
                .setDuration(250);
    }

    public void addButton(int guideLine) {
        //Eigenschaften des Buttons
        Buttons[buttonCount] = new Button(this);
        Button button = Buttons[buttonCount];
        button.setTextSize(8);
        button.setText("I\nV");

        //Initialisierung vom Layout
        ConstraintLayout layout = findViewById(R.id.activity);

        String buttonID = "Button_Connect4_playarea" + buttonCount;

        int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
        button.setId(resID);

        //Layout wird angewendet
        layout.addView(button);
        setContentView(layout);

        //Initalisierung vom Set
        ConstraintSet set = new ConstraintSet();

        set.constrainHeight(button.getId(),  ((int) getResources().getDisplayMetrics().density * 47));
        set.constrainWidth(button.getId(),  ((int) getResources().getDisplayMetrics().density * 45));


        set.connect(button.getId(), ConstraintSet.TOP, R.id.guideline_h, ConstraintSet.TOP, 16);
        set.connect(button.getId(), ConstraintSet.LEFT, guideLine, ConstraintSet.RIGHT, 0);
        set.applyTo(layout);

        buttonCount++;
        fall(button);

    }

    public void touched(View view) {
        switch (view.getId()) {
            case (R.id.button15):
                addButton(R.id.guideline2);
                fall(view);
                break;
            case (R.id.button16):
                addButton((R.id.guideline3));
                break;
            case (R.id.button17):
                addButton(R.id.guideline4);
                break;
            case (R.id.button13):
                addButton(R.id.guideline5);
                break;
            case (R.id.button14):
                addButton((R.id.guideline6));
                break;
            case (R.id.button11):
                addButton(R.id.guideline7);
                break;
            case (R.id.button12):
                addButton(R.id.guideline8);
                break;

        }
    }

    private void changeColor(SharedPreferences sharedPreferences) {
        String selected = sharedPreferences.getString("colour", getString(R.string.color_white));
        if (selected.equalsIgnoreCase(getString(R.string.color_yellow))) {
            findViewById(R.id.button16).getRootView().setBackgroundColor(getResources().getColor(R.color.yellow));
        } else if (selected.equalsIgnoreCase(getString(R.string.color_blue))) {
            findViewById(R.id.button16).getRootView().setBackgroundColor(getResources().getColor(R.color.blue));
        } else if (selected.equalsIgnoreCase(getString(R.string.color_white))) {
            findViewById(R.id.button16).getRootView().setBackgroundColor(getResources().getColor(R.color.white));
        }
    }


}