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

public class DialogFail3 extends AppCompatDialogFragment {

    private Button b;
    private TextView textviewScore, failMaxPoints;

    private Quiz q;
    private Quiz2 q2;
    private Quiz3 q3;

    private int score1, score2, score3;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_fail, null);

        builder.setView(view);

        q = new Quiz();
        q2 = new Quiz2();
        q3 = new Quiz3();

        score1 = q.score;
        score2 = q2.score2;
        score3 = q3.score3;

        failMaxPoints = view.findViewById(R.id.failMaxpoints);
        failMaxPoints.setText("Max points: 90");

        int total3 = score1 + score2 + score3;
        textviewScore = view.findViewById(R.id.level_score_);
        textviewScore.setText("Score: " + total3);

        b = view.findViewById(R.id.failedlevel);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Quiz3.class);
                startActivity(intent);
            }
        });

        return builder.create();
    }


}