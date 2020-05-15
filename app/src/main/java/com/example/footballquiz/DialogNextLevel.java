package com.example.footballquiz;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class DialogNextLevel extends AppCompatDialogFragment {

    private Button levelList;
    private TextView points, pointsMax;

    private Quiz q1;
    private Quiz2 q2;
    private Quiz3 q3;
    private Quiz4 q4;
    private Quiz5 q5;

    private int previousLevel;

    private int l1, l2, l3, l4, l5;

    private DialogFail df;
    private AllLevelsActivity a;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_success, null);
        builder.setView(view);

        a = new AllLevelsActivity();
        df = new DialogFail();

        //TextView
        points = view.findViewById(R.id.level_score);
        pointsMax = view.findViewById(R.id.max_points);

        //Button
        levelList = view.findViewById(R.id.levelList);

        q1 = new Quiz();
        q2 = new Quiz2();
        q3 = new Quiz3();
        q4 = new Quiz4();
        q5 = new Quiz5();

     // default value is -1 so there will be only one positive number(the number of level which we have completed)
        l1 = getArguments().getInt("1", -1);
        l2 = getArguments().getInt("2", -1);
        l3 = getArguments().getInt("3", -1);
        l4 = getArguments().getInt("4", -1);
        l5 = getArguments().getInt("5", -1);

    // we are finding this number with the findMax method
        previousLevel = findMax(l1, l2, l3, l4, l5, -1);


     // set the text where the number of points is shown
        df.showPoints(points, pointsMax, previousLevel);

        loadUnlocked();

        levelList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // if level number previousLevel is completed and next level is unlocked then go directly there
                if(previousLevel == 5 && a.unlocked6){
                    startActivity(new Intent(getActivity(), Quiz6.class));
                    getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
                else if(previousLevel == 4 && a.unlocked5){
                    startActivity(new Intent(getActivity(), Quiz5.class));
                    getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
                else if(previousLevel == 3 && a.unlocked4){
                    startActivity(new Intent(getActivity(), Quiz4.class));
                    getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
                else if(previousLevel == 2 && a.unlocked3){
                    startActivity(new Intent(getActivity(), Quiz3.class));
                    getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
                else if(previousLevel == 1 && a.unlocked2){
                    startActivity(new Intent(getActivity(), Quiz2.class));
                    getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
                else {
                    Intent intent = new Intent(getActivity(), AllLevelsActivity.class);
                    startActivity(intent);
                    getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
            }
        });


        return builder.create();
    }

    // the sixth argument in this particular class is because we use it also in DialogFail.class where we need six arguments
    public int findMax(int a, int b, int c, int d, int e, int f){
        int max = 0;
        if(a  > 0){
            max = a;
        }
        else if(b > 0){
            max = b;
        }
        else if(c > 0){
            max = c;
        }
        else if(d > 0){
            max = d;
        }
        else if(e > 0){
            max = e;
        }
        else if(f > 0){
            max = f;
        }

        return max;
    }

    private void loadUnlocked(){
        SharedPreferences s = getActivity().getSharedPreferences(a.SHARED_PREFS, Context.MODE_PRIVATE);

        a.unlocked2 = s.getBoolean("a", false);
        a.unlocked3 = s.getBoolean("b", false);
        a.unlocked4 = s.getBoolean("c", false);
        a.unlocked5 = s.getBoolean("d", false);
        a.unlocked6 = s.getBoolean("e", false);
    }



}
