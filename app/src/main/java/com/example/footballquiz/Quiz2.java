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

public class Quiz2 extends AppCompatActivity {
    private DbHelper helper= new DbHelper(this);

    private ImageView questionImg;
    private RadioGroup radioGroup;
    private RadioButton option_A, option_B, option_C, option_D;
    private Button confirm;

    private ColorStateList defaultColors;

    static List<Question> listOfQuestions2;

    private Question currentQuestion;

    static int score2;
    private int questionCount, totalQuestions;
    private boolean answered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);

        score2 = 0;


        questionImg = findViewById(R.id.question_image2);
        radioGroup = findViewById(R.id.radiogr2);
        option_A = findViewById(R.id.optionA2);
        option_B = findViewById(R.id.optionB2);
        option_C = findViewById(R.id.optionC2);
        option_D = findViewById(R.id.optionD2);
        confirm = findViewById(R.id.confirm2);

        defaultColors = option_A.getTextColors();

        listOfQuestions2 = helper.getQuestionsForExactLevel(Question.LEVEL_2);

        totalQuestions = listOfQuestions2.size();

        Collections.shuffle(listOfQuestions2);

        showNextQuestion();

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!answered){
                    if(option_A.isChecked() || option_B.isChecked() || option_C.isChecked() || option_D.isChecked()){
                        checkAnswer();
                    }else{
                        Toast.makeText(Quiz2.this, "Please, select an answer!", Toast.LENGTH_SHORT).show();
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
            currentQuestion = listOfQuestions2.get(questionCount);
            byte[] bb = currentQuestion.getQuestion();

            questionImg.setImageResource(ByteBuffer.wrap(bb).getInt());
            option_A.setText(currentQuestion.getOptionA());
            option_B.setText(currentQuestion.getOptionB());
            option_C.setText(currentQuestion.getOptionC());
            option_D.setText(currentQuestion.getOptionD());

            answered = false;
            questionCount++;
            confirm.setText("Confirm");
        }else{ // 55
            if(score2 >= 4) {
                finishLevel_2();
            }else{
                level2_fail();
            }
        }
    }

    private void checkAnswer() {
        answered = true;

        RadioButton selectedAnswer = findViewById(radioGroup.getCheckedRadioButtonId());
        int givenAnswer = radioGroup.indexOfChild(selectedAnswer) + 1;

        if (givenAnswer == currentQuestion.getAnswer()) {
            score2++;
            selectedAnswer.setTextColor(getResources().getColor(R.color.green));
        }
        else {
            selectedAnswer.setTextColor(getResources().getColor(R.color.red));
        }

        confirm.setText("Next");
    }

    private void finishLevel_2(){
        Bundle bundle = new Bundle();
        bundle.putInt("2", 2);
        DialogNextLevel dialogNextLevel = new DialogNextLevel();
        dialogNextLevel.setArguments(bundle);
        dialogNextLevel.show(getSupportFragmentManager(), "Tag2");
    }

    private void level2_fail(){
        Bundle bundle = new Bundle();
        bundle.putInt("two", 2);
        DialogFail dialogFail = new DialogFail();
        dialogFail.setArguments(bundle);
        dialogFail.show(getSupportFragmentManager(), "Tag2_");
    }

    public void backToMainMenu2(View view){
        ReturnToMenu r = new ReturnToMenu();
        r.show(getSupportFragmentManager(), "!b");
    }

}
