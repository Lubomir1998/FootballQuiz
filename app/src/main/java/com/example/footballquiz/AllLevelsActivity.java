package com.example.footballquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AllLevelsActivity extends AppCompatActivity {

    private int score1, score2, score3;
    int totalPoints;
    private Quiz q;
    private Quiz2 q2;
    private Quiz3 q3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_levels);

        q = new Quiz();
        q2 = new Quiz2();
        q3 = new Quiz3();

        score1 = q.score;
        score2 = q2.score2;
        score3 = q3.score3;

        totalPoints = score1 + score2 + score3;

    }

    public void Level_1(View view){
        startActivity(new Intent(getApplicationContext(), Quiz.class));
    }

    public void Level_2(View view){
        if(totalPoints < 7){
            // level locked
        }
        else{
            startActivity(new Intent(getApplicationContext(), Quiz2.class));
        }
    }

    public void Level_3(View view){
        if(totalPoints < 55){
            // level locked
        }
        else{
            startActivity(new Intent(getApplicationContext(), Quiz3.class));
        }
    }

    public void Level_4(View view){

    }

    public void Level_5(View view){

    }

    public void Level_6(View view){

    }
}
