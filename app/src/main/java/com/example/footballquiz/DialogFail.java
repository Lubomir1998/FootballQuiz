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

    private Button b, levelList;
    private TextView textviewScore, failMaxPoints;

    private Quiz q;

    private int score1;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_fail, null);

        builder.setView(view);

        q = new Quiz();
        score1 = q.score;

        failMaxPoints = view.findViewById(R.id.failMaxpoints);
        failMaxPoints.setText("Max points 30");

        textviewScore = view.findViewById(R.id.level_score_);
        textviewScore.setText("Score: " + score1);

        b = view.findViewById(R.id.failedlevel);

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
                Intent intent = new Intent(getActivity(), Quiz.class);
                intent.putExtra("scorefail", 0);
                startActivity(intent);
            }
        });

        return builder.create();
    }


}
