package com.spam.finnh.gamecollection.Settings;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class changeAppearance extends AppCompatActivity{

        @SuppressLint("ResourceAsColor")
        public void changeBackgroundColour(View someView) {

            View root = someView.getRootView();
            someView.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_bright));

        }


}
