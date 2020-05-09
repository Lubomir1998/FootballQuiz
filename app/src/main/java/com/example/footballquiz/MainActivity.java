package com.example.footballquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button start, allLevels;
    private AllLevelsActivity a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.startQuiz);
        allLevels = findViewById(R.id.allLevels);

        a = new AllLevelsActivity();

        loadUnlockedLevels();

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // checking if levels are unlocked
                // so we can start quiz from the last level you have reached
                if(a.unlocked6){
                    goToLevel(6);
                }
                else if(a.unlocked5){
                    goToLevel(5);
                }
                else if(a.unlocked4){
                    goToLevel(4);
                }
                else if(a.unlocked3){
                    goToLevel(3);
                }
                else if(a.unlocked2){
                    goToLevel(2);
                }else{
                    goToLevel(1);
                }
            }
        });

        allLevels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AllLevelsActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });


    }

    private void goToLevel(int level){
        switch(level){
            case 6:
                Intent intent6 = new Intent(MainActivity.this, Quiz6.class);
                startActivity(intent6);
                overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_up);
                break;
            case 5:
                Intent intent5 = new Intent(MainActivity.this, Quiz5.class);
                startActivity(intent5);
                overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_up);
                break;
            case 4:
                Intent intent4 = new Intent(MainActivity.this, Quiz4.class);
                startActivity(intent4);
                overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_up);
                break;
            case 3:
                Intent intent3 = new Intent(MainActivity.this, Quiz3.class);
                startActivity(intent3);
                overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_up);
                break;
            case 2:
                Intent intent2 = new Intent(MainActivity.this, Quiz2.class);
                startActivity(intent2);
                overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_up);
                break;
            default:
                Intent intent = new Intent(MainActivity.this, Quiz.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_up);
                break;
        }

    }

    private void loadUnlockedLevels(){
        SharedPreferences s = getSharedPreferences(a.SHARED_PREFS, MODE_PRIVATE);

        a.unlocked2 = s.getBoolean("a", false);
        a.unlocked3 = s.getBoolean("b", false);
        a.unlocked4 = s.getBoolean("c", false);
        a.unlocked5 = s.getBoolean("d", false);
        a.unlocked6 = s.getBoolean("e", false);
    }

}
