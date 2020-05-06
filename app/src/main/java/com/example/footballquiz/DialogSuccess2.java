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

public class DialogSuccess2 extends AppCompatDialogFragment {

    private Button b, levelList;
    private TextView textviewScore, maxpoints;

    private Quiz q;
    private Quiz2 q2;

    private int score, score2, total2;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_success, null);

        builder.setView(view);

        q = new Quiz();
        q2 = new Quiz2();

        score = q.score;
        score2 = q2.score2;

        maxpoints = view.findViewById(R.id.max_points);
        maxpoints.setText("Max points: 60");

        total2 = score + score2;
        textviewScore = view.findViewById(R.id.level_score);
        textviewScore.setText("Score: " + total2);

        b = view.findViewById(R.id.goToNextLevel);

        levelList = view.findViewById(R.id.levelList);

        levelList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AllLevelsActivity.class);
                startActivity(intent);
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Quiz3.class);
                intent.putExtra("scoreLevel2", total2);
                startActivity(intent);
            }
        });

        return builder.create();
    }


}
