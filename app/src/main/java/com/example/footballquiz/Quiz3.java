package com.example.footballquiz;

import androidx.appcompat.app.AppCompatActivity;

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

public class Quiz3 extends AppCompatActivity {
    private DbHelper helper= new DbHelper(this);

    private ImageView questionImg;
    private RadioGroup radioGroup;
    private RadioButton option_A, option_B, option_C, option_D;
    private Button confirm;

    private ColorStateList defaultColors;

    private List<Question> listOfQuestions;

    private Question currentQuestion;

    private int score, questionCount, totalQuestions;
    private boolean answered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);

        questionImg = findViewById(R.id.question_image3);
        radioGroup = findViewById(R.id.radiogr3);
        option_A = findViewById(R.id.optionA3);
        option_B = findViewById(R.id.optionB3);
        option_C = findViewById(R.id.optionC3);
        option_D = findViewById(R.id.optionD3);
        confirm = findViewById(R.id.confirm3);

        defaultColors = option_A.getTextColors();

        listOfQuestions = helper.getQuestionsForExactLevel(Question.LEVEL_3);

        totalQuestions = listOfQuestions.size();

        Collections.shuffle(listOfQuestions);

        showNextQuestion();

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!answered){
                    if(option_A.isChecked() || option_B.isChecked() || option_C.isChecked() || option_D.isChecked()){
                        checkAnswer();
                    }else{
                        Toast.makeText(Quiz3.this, "Please, select an answer!", Toast.LENGTH_SHORT).show();
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
        }else{
            Toast.makeText(this, "Quiz finished", Toast.LENGTH_SHORT).show();
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
        option_A.setTextColor(getResources().getColor(R.color.red));
        option_B.setTextColor(getResources().getColor(R.color.red));
        option_C.setTextColor(getResources().getColor(R.color.red));
        option_D.setTextColor(getResources().getColor(R.color.red));

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
}
