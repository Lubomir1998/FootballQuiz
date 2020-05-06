package com.example.footballquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AllLevelsActivity extends AppCompatActivity {

    Button l1, l2, l3, l4, l5, l6;
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

        l1 = findViewById(R.id.l1);
        l2 = findViewById(R.id.l2);
        l3 = findViewById(R.id.l3);
        l4 = findViewById(R.id.l4);
        l5 = findViewById(R.id.l5);
        l6 = findViewById(R.id.l6);

        score1 = q.score;
        score2 = q2.score2;
        score3 = q3.score3;
        score4 = q4.score4;
        score5 = q5.score5;
        score6 = q6.score6;

        totalPoints = score1 + score2 + score3 + score4 + score5 + score6;

       if(totalPoints < 25){
           l2.setBackground(getResources().getDrawable(R.drawable.locked_level));
       }
       if(totalPoints < 55){
           l3.setBackground(getResources().getDrawable(R.drawable.locked_level));
       }
       if(totalPoints < 80){
           l4.setBackground(getResources().getDrawable(R.drawable.locked_level));
       }
       if(totalPoints < 105){
           l5.setBackground(getResources().getDrawable(R.drawable.locked_level));
       }
       if(totalPoints < 135){
           l6.setBackground(getResources().getDrawable(R.drawable.locked_level));
       }

    }

    public void Level_1(View view){
        startActivity(new Intent(getApplicationContext(), Quiz.class));
    }

    public void Level_2(View view){
        if(totalPoints > 25){
            startActivity(new Intent(getApplicationContext(), Quiz2.class));
        }
    }

    public void Level_3(View view){
        if(totalPoints > 55){
            startActivity(new Intent(getApplicationContext(), Quiz3.class));
        }
    }

    public void Level_4(View view){
        if(totalPoints > 80){
            startActivity(new Intent(getApplicationContext(), Quiz4.class));
        }

    }

    public void Level_5(View view){
        if(totalPoints > 105){
            startActivity(new Intent(getApplicationContext(), Quiz5.class));
        }

    }

    public void Level_6(View view){
        if(totalPoints > 135){
            startActivity(new Intent(getApplicationContext(), Quiz6.class));
        }

    }
}
