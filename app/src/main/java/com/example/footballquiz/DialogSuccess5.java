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

public class DialogSuccess5 extends AppCompatDialogFragment {

    private Button b, levelList;
    private TextView textviewScore, maxpoints;

    private Quiz q;
    private Quiz2 q2;
    private Quiz3 q3;
    private Quiz4 q4;
    private Quiz5 q5;

    private int score, score2, score3, score4, score5;
    static int total5;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_success, null);

        builder.setView(view);

        q = new Quiz();
        q2 = new Quiz2();
        q3 = new Quiz3();
        q4 = new Quiz4();
        q5 = new Quiz5();

        score = q.score;
        score2 = q2.score2;
        score3 = q3.score3;
        score4 = q4.score4;
        score5 = q5.score5;

        maxpoints = view.findViewById(R.id.max_points);
        maxpoints.setText("Max points: 150");

        total5 = score + score2 + score3 + score4;
        textviewScore = view.findViewById(R.id.level_score);
        textviewScore.setText("Score: " + total5);

        b = view.findViewById(R.id.goToNextLevel);

        levelList = view.findViewById(R.id.levelList);

        levelList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AllLevelsActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_down);
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Quiz6.class);
                intent.putExtra("scoreLevel5", total5);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        return builder.create();
    }
}
