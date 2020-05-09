package com.example.footballquiz;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class DialogFail extends AppCompatDialogFragment {

    TextView fail;
    Button levelList, tryAgain;

    private Quiz q1;
    private Quiz2 q2;
    private Quiz3 q3;
    private Quiz4 q4;
    private Quiz5 q5;
    private Quiz6 q6;

    private int l1, l2, l3, l4, l5, l6;
    private int currentLevel;

    private DialogNextLevel d;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_fail, null);
        builder.setView(view);

       // TextView
        fail = view.findViewById(R.id.level_score_);

       // Buttons
        tryAgain = view.findViewById(R.id.failedlevel);
        levelList = view.findViewById(R.id.levelList);

        q1 = new Quiz();
        q2 = new Quiz2();
        q3 = new Quiz3();
        q4 = new Quiz4();
        q5 = new Quiz5();
        q6 = new Quiz6();


        d = new DialogNextLevel();

        // default value is -1 so there will be only one positive number(the number of level which we have failed)
        l1 = getArguments().getInt("one", -1);
        l2 = getArguments().getInt("two", -1);
        l3 = getArguments().getInt("three", -1);
        l4 = getArguments().getInt("four", -1);
        l5 = getArguments().getInt("five", -1);
        l6 = getArguments().getInt("six", -1);

        currentLevel = d.findMax(l1, l2, l3, l4, l5, l6);

        showPoints(fail, currentLevel);

        levelList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AllLevelsActivity.class));
                getActivity().overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_down);
            }
        });


        tryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentLevel == 1){
                    startActivity(new Intent(getActivity(), Quiz.class));
                    getActivity().overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                }
                else if(currentLevel == 2){
                    startActivity(new Intent(getActivity(), Quiz2.class));
                    getActivity().overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                }
                else if(currentLevel == 3){
                    startActivity(new Intent(getActivity(), Quiz3.class));
                    getActivity().overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                }
                else if(currentLevel == 4){
                    startActivity(new Intent(getActivity(), Quiz4.class));
                    getActivity().overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                }
                else if(currentLevel == 5){
                    startActivity(new Intent(getActivity(), Quiz5.class));
                    getActivity().overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                }
                else if(currentLevel == 6){
                    startActivity(new Intent(getActivity(), Quiz6.class));
                    getActivity().overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                }
            }
        });


        return builder.create();

    }

    public void showPoints(TextView t, int l){
        switch (l){
            case 1:
                t.setText("Score: " + String.valueOf(q1.score));
                break;
            case 2:
                t.setText("Score: " + String.valueOf(q2.score2));
                break;
            case 3:
                t.setText("Score: " + String.valueOf(q3.score3));
                break;
            case 4:
                t.setText("Score: " + String.valueOf(q4.score4));
                break;
            case 5:
                t.setText("Score: " + String.valueOf(q5.score5));
                break;
            case 6:
                t.setText("Score: " + String.valueOf(q6.score6));
                break;
        }
    }

}
