package com.example.footballquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public class Quiz extends AppCompatActivity {
    private DbHelper helper= new DbHelper(this);

    private ImageView questionImg;
    private RadioGroup radioGroup;
    private RadioButton option_A, option_B, option_C, option_D;
    private Button confirm;

    private ColorStateList defaultColors;

    static List<Question> listOfQuestions;

    private Question currentQuestion;

    static int score;
    private int questionCount, totalQuestions;
    private boolean answered;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionImg = findViewById(R.id.question_image);
        radioGroup = findViewById(R.id.radiogr);
        option_A = findViewById(R.id.optionA);
        option_B = findViewById(R.id.optionB);
        option_C = findViewById(R.id.optionC);
        option_D = findViewById(R.id.optionD);
        confirm = findViewById(R.id.confirm);

        defaultColors = option_A.getTextColors();

        listOfQuestions = helper.getQuestionsForExactLevel(Question.LEVEL_1);

        totalQuestions = listOfQuestions.size();

        Collections.shuffle(listOfQuestions);

        score = 0;

        showNextQuestion();

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!answered){
                    if(option_A.isChecked() || option_B.isChecked() || option_C.isChecked() || option_D.isChecked()){
                        checkAnswer();
                    }else{
                        Toast.makeText(Quiz.this, "Please, select an answer!", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    showNextQuestion();
                }
            }
        });

    }

    private void showNextQuestion(){
        option_A.setTextColor(defaultColors);
        option_B.setTextColor(defaultColors);
        option_C.setTextColor(defaultColors);
        option_D.setTextColor(defaultColors);
        radioGroup.clearCheck();

        if(questionCount < totalQuestions) {
            currentQuestion = listOfQuestions.get(questionCount);
            byte[] bb = currentQuestion.getQuestion();

            questionImg.setImageResource(ByteBuffer.wrap(bb).getInt());
            option_A.setText(currentQuestion.getOptionA());
            option_B.setText(currentQuestion.getOptionB());
            option_C.setText(currentQuestion.getOptionC());
            option_D.setText(currentQuestion.getOptionD());

            answered = false;
            questionCount++;
            confirm.setText("Confirm");
        }else{// 25
            if(score >= 4) {
                finishLevel_1();
            }else{
                level1_fail();
            }
        }
    }

    private void checkAnswer() {
        answered = true;

        RadioButton selectedAnswer = findViewById(radioGroup.getCheckedRadioButtonId());
        int givenAnswer = radioGroup.indexOfChild(selectedAnswer) + 1;

        if (givenAnswer == currentQuestion.getAnswer()) {
            score++;

        }

        showSolution();
    }

    private void showSolution(){
        RadioButton selectedAnswer = findViewById(radioGroup.getCheckedRadioButtonId());
        int givenAnswer = radioGroup.indexOfChild(selectedAnswer) + 1;

        switch (givenAnswer){
            case 1:
                option_A.setTextColor(getResources().getColor(R.color.red));
                break;
            case 2:
                option_B.setTextColor(getResources().getColor(R.color.red));
                break;
            case 3:
                option_C.setTextColor(getResources().getColor(R.color.red));
                break;
            case 4:
                option_D.setTextColor(getResources().getColor(R.color.red));
                break;
        }


        switch (currentQuestion.getAnswer()){
            case 1:
                option_A.setTextColor(getResources().getColor(R.color.green));
                break;
            case 2:
                option_B.setTextColor(getResources().getColor(R.color.green));
                break;
            case 3:
                option_C.setTextColor(getResources().getColor(R.color.green));
                break;
            case 4:
                option_D.setTextColor(getResources().getColor(R.color.green));
                break;
        }
        confirm.setText("Next");
    }

    private void finishLevel_1(){
        Bundle bundle = new Bundle();
        bundle.putInt("1", 1);
        DialogNextLevel dialogNextLevel = new DialogNextLevel();
        dialogNextLevel.setArguments(bundle);
        dialogNextLevel.show(getSupportFragmentManager(), "Tag1");
    }

    private void level1_fail(){
        Bundle bundle = new Bundle();
        bundle.putInt("one", 1);
        DialogFail dialogFail = new DialogFail();
        dialogFail.setArguments(bundle);
        dialogFail.show(getSupportFragmentManager(), "Tag1_");
    }

    public void backToMainMenu(View view){
        ReturnToMenu r = new ReturnToMenu();
        r.show(getSupportFragmentManager(), "!a");
    }

}
