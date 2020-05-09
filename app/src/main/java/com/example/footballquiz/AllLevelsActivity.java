package com.example.footballquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AllLevelsActivity extends AppCompatActivity {

    Button l1, l2, l3, l4, l5, l6;
    private int score1, score2, score3, score4, score5, score6;
    private Quiz q;
    private Quiz2 q2;
    private Quiz3 q3;
    private Quiz4 q4;
    private Quiz5 q5;
    private Quiz6 q6;

    public boolean unlocked2, unlocked3, unlocked4, unlocked5, unlocked6;

    public static final String SHARED_PREFS = "shred_prefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_levels);

        l1 = findViewById(R.id.l1);
        l2 = findViewById(R.id.l2);
        l3 = findViewById(R.id.l3);
        l4 = findViewById(R.id.l4);
        l5 = findViewById(R.id.l5);
        l6 = findViewById(R.id.l6);

  // objects of classes
        q = new Quiz();
        q2 = new Quiz2();
        q3 = new Quiz3();
        q4 = new Quiz4();
        q5 = new Quiz5();
        q6 = new Quiz6();

  // we get the score from each level
        score1 = q.score;
        score2 = q2.score2;
        score3 = q3.score3;
        score4 = q4.score4;
        score5 = q5.score5;
       // score6 = i.getIntExtra("scoreLevel1", 0);

        load();

       if((score1 > 3) || unlocked2){
           unlocked2 = true;
           l2.setBackground(getResources().getDrawable(R.drawable.all_levels_buttons));
           saveProgress();
       }
       if((score2 > 3) || unlocked3){
           unlocked3 = true;
           l3.setBackground(getResources().getDrawable(R.drawable.all_levels_buttons));
           saveProgress();
       }
       if((score3 > 3) || unlocked4){
           unlocked4 = true;
           l4.setBackground(getResources().getDrawable(R.drawable.all_levels_buttons));
           saveProgress();
       }
       if((score4 > 3) || unlocked5){
           unlocked5 = true;
           l5.setBackground(getResources().getDrawable(R.drawable.all_levels_buttons));
           saveProgress();
       }
       if((score5 > 3) || unlocked6){
           unlocked6 = true;
           l6.setBackground(getResources().getDrawable(R.drawable.all_levels_buttons));
           saveProgress();
       }

    }

    public void Level_1(View view){
        startActivity(new Intent(getApplicationContext(), Quiz.class));
        overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_up);
    }

    public void Level_2(View view){
        if(unlocked2){
            Intent intent = new Intent(getApplicationContext(), Quiz2.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_up);
        }
        else{
            Toast.makeText(getApplicationContext(), "You haven't unlocked this level", Toast.LENGTH_SHORT).show();
        }
    }

    public void Level_3(View view){
        if(unlocked3){
            Intent intent = new Intent(getApplicationContext(), Quiz3.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_up);
        }
        else{
            Toast.makeText(getApplicationContext(), "You haven't unlocked this level", Toast.LENGTH_SHORT).show();
        }
    }

    public void Level_4(View view){
        if(unlocked4){
            Intent intent = new Intent(getApplicationContext(), Quiz4.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_up);
        }
        else{
            Toast.makeText(getApplicationContext(), "You haven't unlocked this level", Toast.LENGTH_SHORT).show();
        }
    }

    public void Level_5(View view){
        if(unlocked5){
            Intent intent = new Intent(getApplicationContext(), Quiz5.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_up);
        }
        else{
            Toast.makeText(getApplicationContext(), "You haven't unlocked this level", Toast.LENGTH_SHORT).show();
        }
    }

    public void Level_6(View view){
        if(unlocked6){
            Intent intent = new Intent(getApplicationContext(), Quiz6.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_up);
        }
        else{
            Toast.makeText(getApplicationContext(), "You haven't unlocked this level", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveProgress(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean("a", unlocked2);
        editor.putBoolean("b", unlocked3);
        editor.putBoolean("c", unlocked4);
        editor.putBoolean("d", unlocked5);
        editor.putBoolean("e", unlocked6);
        editor.apply();
    }

    public void load(){
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

        unlocked2 = sharedPreferences.getBoolean("a", false);
        unlocked3 = sharedPreferences.getBoolean("b", false);
        unlocked4 = sharedPreferences.getBoolean("c", false);
        unlocked5 = sharedPreferences.getBoolean("d", false);
        unlocked6 = sharedPreferences.getBoolean("e", false);
    }


}
