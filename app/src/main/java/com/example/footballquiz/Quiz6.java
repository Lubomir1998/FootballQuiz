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

public class Quiz6 extends AppCompatActivity {

    private DbHelper helper= new DbHelper(this);

    private ImageView questionImg;
    private RadioGroup radioGroup;
    private RadioButton option_A, option_B, option_C, option_D;
    private Button confirm;

    private ColorStateList defaultColors;

    static List<Question> listOfQuestions6;

    private Question currentQuestion;

    static int score6;
    private int questionCount, totalQuestions;
    private boolean answered;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz6);

        score6 = 0;

        questionImg = findViewById(R.id.question_image6);
        radioGroup = findViewById(R.id.radiogr6);
        option_A = findViewById(R.id.optionA6);
        option_B = findViewById(R.id.optionB6);
        option_C = findViewById(R.id.optionC6);
        option_D = findViewById(R.id.optionD6);
        confirm = findViewById(R.id.confirm6);

        defaultColors = option_A.getTextColors();

        listOfQuestions6 = helper.getQuestionsForExactLevel(Question.LEVEL_6);

        totalQuestions = listOfQuestions6.size();

        Collections.shuffle(listOfQuestions6);

        showNextQuestion();

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!answered){
                    if(option_A.isChecked() || option_B.isChecked() || option_C.isChecked() || option_D.isChecked()){
                        checkAnswer();
                    }else{
                        Toast.makeText(Quiz6.this, "Please, select an answer!", Toast.LENGTH_SHORT).show();
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
            currentQuestion = listOfQuestions6.get(questionCount);
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
            // 173
            if(score6 >= 4) {
                finishLevel_6();
            }else{
                level6_fail();
            }
        }
    }

    private void checkAnswer() {
        answered = true;

        RadioButton selectedAnswer = findViewById(radioGroup.getCheckedRadioButtonId());
        int givenAnswer = radioGroup.indexOfChild(selectedAnswer) + 1;

        if (givenAnswer == currentQuestion.getAnswer()) {
            score6++;
            selectedAnswer.setTextColor(getResources().getColor(R.color.green));
        }
        else {
            selectedAnswer.setTextColor(getResources().getColor(R.color.red));
        }

        confirm.setText("Next");
    }

    private void finishLevel_6(){
        FinishQuizDialog finishQuizDialog = new FinishQuizDialog();
        finishQuizDialog.show(getSupportFragmentManager(), "Tag6");
    }

    private void level6_fail(){
        Bundle bundle = new Bundle();
        bundle.putInt("six", 6);
        DialogFail dialogFail = new DialogFail();
        dialogFail.setArguments(bundle);
        dialogFail.show(getSupportFragmentManager(), "Tag6_");
    }

    public void backToMainMenu6(View view){
        ReturnToMenu r = new ReturnToMenu();
        r.show(getSupportFragmentManager(), "!f");
    }

}
