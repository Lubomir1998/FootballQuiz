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

public class Quiz4 extends AppCompatActivity {

    private DbHelper helper= new DbHelper(this);

    private ImageView questionImg;
    private RadioGroup radioGroup;
    private RadioButton option_A, option_B, option_C, option_D;
    private Button confirm;

    private ColorStateList defaultColors;

    private List<Question> listOfQuestions;

    private Question currentQuestion;

    static int score4;
    private int questionCount, scoreFromPrevLevels, totalQuestions;
    private boolean answered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz4);

        score4 = 0;
        Intent intent = getIntent();
        scoreFromPrevLevels = intent.getIntExtra("scoreLevel3", 0 );

        Intent i = getIntent();
        scoreFromPrevLevels = i.getIntExtra("level4fail", scoreFromPrevLevels);

        questionImg = findViewById(R.id.question_image4);
        radioGroup = findViewById(R.id.radiogr4);
        option_A = findViewById(R.id.optionA4);
        option_B = findViewById(R.id.optionB4);
        option_C = findViewById(R.id.optionC4);
        option_D = findViewById(R.id.optionD4);
        confirm = findViewById(R.id.confirm4);

        defaultColors = option_A.getTextColors();

        listOfQuestions = helper.getQuestionsForExactLevel(Question.LEVEL_4);

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
                        Toast.makeText(Quiz4.this, "Please, select an answer!", Toast.LENGTH_SHORT).show();
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
            if((score4 + scoreFromPrevLevels) >= 105) {
                finishLevel_4();
            }else{
                level4_fail();
            }
        }
    }

    private void checkAnswer() {
        answered = true;

        RadioButton selectedAnswer = findViewById(radioGroup.getCheckedRadioButtonId());
        int givenAnswer = radioGroup.indexOfChild(selectedAnswer) + 1;

        if (givenAnswer == currentQuestion.getAnswer()) {
            score4++;
            selectedAnswer.setTextColor(getResources().getColor(R.color.green));
        }
        else {
            selectedAnswer.setTextColor(getResources().getColor(R.color.red));
        }

        confirm.setText("Next");
    }

    private void finishLevel_4(){
        DialogSuccess4 dialogSuccess = new DialogSuccess4();
        dialogSuccess.show(getSupportFragmentManager(), "Tag4");
    }

    private void level4_fail(){
        DialogFail4 dialogFail = new DialogFail4();
        dialogFail.show(getSupportFragmentManager(), "Tag4_");
    }


}

