package com.spam.finnh.gamecollection.Menues;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.spam.finnh.gamecollection.Battleship.Battleship_playarea;
import com.spam.finnh.gamecollection.Connect4.Connect4_playarea;
import com.spam.finnh.gamecollection.Instructions.Battleship_instructions;
import com.spam.finnh.gamecollection.Instructions.Connect4_instructions;
import com.spam.finnh.gamecollection.Instructions.TicTacToe_instructions;
import com.spam.finnh.gamecollection.R;
import com.spam.finnh.gamecollection.TicTacToe.TicTacToe_playarea;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startTicTacToe(View view) {
        Intent intent;
        intent = new Intent(this, TicTacToe_playarea.class);
        startActivity(intent);
    }

    public void startConnect4(View view) {
        Intent intent;
        intent = new Intent(this, Connect4_playarea.class);
        startActivity(intent);
    }

    public void startBattleship(View view) {
        Intent intent;
        intent = new Intent(this, Battleship_playarea.class);
        startActivity(intent);
    }

    public void startSettings(View view) {
        Intent intent;
        intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void startHelp(View view) {
        Intent intent;
        intent = new Intent(this, Help.class);
        startActivity(intent);
    }

    public void startTicTacToeInstructions(View view) {
        Intent intent;
        intent = new Intent(this, TicTacToe_instructions.class);
        startActivity(intent);
    }

    public void startConnect4Instructions(View view) {
        Intent intent;
        intent = new Intent(this, Connect4_instructions.class);
        startActivity(intent);
    }

    public void startBattleshipInstructions(View view) {
        Intent intent;
        intent = new Intent(this, Battleship_instructions.class);
        startActivity(intent);
    }
}
