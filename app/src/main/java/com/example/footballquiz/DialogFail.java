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

    Button b;
    TextView textviewScore;

    Quiz q;

    int score1;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_fail, null);

        builder.setView(view);

        q = new Quiz();
        score1 = q.score;

        textviewScore = view.findViewById(R.id.level1_score_);
        textviewScore.setText("Score: " + score1);

        b = view.findViewById(R.id.failedlevel1);

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
