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
    int totalPoints;
    private DialogSuccess q;
    private DialogSuccess2 q2;
    private DialogSuccess3 q3;
    private DialogSuccess4 q4;
    private DialogSuccess5 q5;
    private Quiz6 q6;

    boolean unlocked2, unlocked3, unlocked4, unlocked5, unlocked6;

    public static final String SHARED_PREFS = "shred_prefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_levels);

        q = new DialogSuccess();
        q2 = new DialogSuccess2();
        q3 = new DialogSuccess3();
        q4 = new DialogSuccess4();
        q5 = new DialogSuccess5();
        q6 = new Quiz6();

        l1 = findViewById(R.id.l1);
        l2 = findViewById(R.id.l2);
        l3 = findViewById(R.id.l3);
        l4 = findViewById(R.id.l4);
        l5 = findViewById(R.id.l5);
        l6 = findViewById(R.id.l6);

        score1 = q.total1;
        score2 = q2.total2;
        score3 = q3.total3;
        score4 = q4.total4;
        score5 = q5.total5;
       // score6 = i.getIntExtra("scoreLevel1", 0);

        totalPoints = score1 + score2 + score3 + score4 + score5 + score6;

        load();

// real num is 25
       if((totalPoints > 5) || unlocked2){
           unlocked2 = true;
           l2.setBackground(getResources().getDrawable(R.drawable.all_levels_buttons));
           saveProgress();
       }  // real num is 55
       if((totalPoints > 55) || unlocked3){
           unlocked3 = true;
           l3.setBackground(getResources().getDrawable(R.drawable.all_levels_buttons));
           saveProgress();
       }
       if((totalPoints > 80) || unlocked4){
           unlocked4 = true;
           l4.setBackground(getResources().getDrawable(R.drawable.all_levels_buttons));
           saveProgress();
       }
       if((totalPoints > 105) || unlocked5){
           unlocked5 = true;
           l5.setBackground(getResources().getDrawable(R.drawable.all_levels_buttons));
           saveProgress();
       }
       if((totalPoints > 135) || unlocked6){
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
            startActivity(new Intent(getApplicationContext(), Quiz2.class));
            overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_up);
        }
        else{
            Toast.makeText(getApplicationContext(), "You need 25 points to unlock this level", Toast.LENGTH_SHORT).show();
        }
    }

    public void Level_3(View view){
        if(unlocked3){
            startActivity(new Intent(getApplicationContext(), Quiz3.class));
            overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_up);
        }
        else{
            Toast.makeText(getApplicationContext(), "You need 55 points to unlock this level", Toast.LENGTH_SHORT).show();
        }
    }

    public void Level_4(View view){
        if(unlocked4){
            startActivity(new Intent(getApplicationContext(), Quiz4.class));
            overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_up);
        }
        else{
            Toast.makeText(getApplicationContext(), "You need 80 points to unlock this level", Toast.LENGTH_SHORT).show();
        }
    }

    public void Level_5(View view){
        if(unlocked5){
            startActivity(new Intent(getApplicationContext(), Quiz5.class));
            overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_up);
        }
        else{
            Toast.makeText(getApplicationContext(), "You need 105 points to unlock this level", Toast.LENGTH_SHORT).show();
        }
    }

    public void Level_6(View view){
        if(unlocked6){
            startActivity(new Intent(getApplicationContext(), Quiz6.class));
            overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_up);
        }
        else{
            Toast.makeText(getApplicationContext(), "You need 135 points to unlock this level", Toast.LENGTH_SHORT).show();
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

    private void load(){
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

        unlocked2 = sharedPreferences.getBoolean("a", false);
        unlocked3 = sharedPreferences.getBoolean("b", false);
        unlocked4 = sharedPreferences.getBoolean("c", false);
        unlocked5 = sharedPreferences.getBoolean("d", false);
        unlocked6 = sharedPreferences.getBoolean("e", false);
    }


}
