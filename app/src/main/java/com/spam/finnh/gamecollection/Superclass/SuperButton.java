package com.spam.finnh.gamecollection.Superclass;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.widget.Button;

import com.spam.finnh.gamecollection.R;

public class SuperButton {


    public void addButton(Button Buttons[], String Text, int Textsize, String ButtonID, Context context, ConstraintLayout layout) {
        int buttonCount = 0;
        //Eigenschaften des Buttons
        Buttons[buttonCount] = new Button(context);
        Button button = Buttons[buttonCount];
        button.setTextSize(Textsize);
        button.setText(Text);

        //Initialisierung vom Layout
        layout = layout.findViewById(R.id.);

        ButtonID += buttonCount;

        int resID = getResources().getIdentifier(ButtonID, "id", getPackageName());
        button.setId(resID);

        //Layout wird angewendet
        layout.addView(button);
        setContentView(layout);

        //Initalisierung vom Set
        ConstraintSet set = new ConstraintSet();

        set.constrainHeight(button.getId(), (int) getResources().getDisplayMetrics().density * 47);
        set.constrainWidth(button.getId(), (int) getResources().getDisplayMetrics().density * 45);


        set.connect(button.getId(), ConstraintSet.TOP, R.id.guideline_h, ConstraintSet.TOP, 16);
        set.connect(button.getId(), ConstraintSet.LEFT, guideLine, ConstraintSet.RIGHT, 0);
        set.applyTo(layout);

        buttonCount++;
    }
}