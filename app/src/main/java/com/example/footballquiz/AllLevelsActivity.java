package com.example.footballquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AllLevelsActivity extends AppCompatActivity {

    private int score1, score2, score3, score4, score5, score6;
    int totalPoints;
    private Quiz q;
    private Quiz2 q2;
    private Quiz3 q3;
    private Quiz4 q4;
    private Quiz5 q5;
    private Quiz6 q6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_levels);

        q = new Quiz();
        q2 = new Quiz2();
        q3 = new Quiz3();
        q4 = new Quiz4();
        q5 = new Quiz5();
        q6 = new Quiz6();

        score1 = q.score;
        score2 = q2.score2;
        score3 = q3.score3;
        score4 = q4.score4;
        score5 = q5.score5;
        score6 = q6.score6;

        totalPoints = score1 + score2 + score3 + score4 + score5 + score6;

    }

    public void Level_1(View view){
        startActivity(new Intent(getApplicationContext(), Quiz.class));
    }

    public void Level_2(View view){
        if(totalPoints < 2){
            // level locked
        }
        else{
            startActivity(new Intent(getApplicationContext(), Quiz2.class));
        }
    }

    public void Level_3(View view){
        if(totalPoints < 6){
            // level locked
        }
        else{
            startActivity(new Intent(getApplicationContext(), Quiz3.class));
        }
    }

    public void Level_4(View view){
        if(totalPoints < 8){
            // level locked
        }
        else{
            startActivity(new Intent(getApplicationContext(), Quiz4.class));
        }

    }

    public void Level_5(View view){
        if(totalPoints < 10){
            // level locked
        }
        else{
            startActivity(new Intent(getApplicationContext(), Quiz5.class));
        }

    }

    public void Level_6(View view){
        if(totalPoints < 12){
            // level locked
        }
        else{
            startActivity(new Intent(getApplicationContext(), Quiz6.class));
        }

    }
}
