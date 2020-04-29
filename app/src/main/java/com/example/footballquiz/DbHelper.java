package com.example.footballquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Quiz db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "quiz";

    public static final String column_id = "_ID";
    public static final String column_question = "question";
    public static final String column_optionA = "optionA";
    public static final String column_optionB = "optionB";
    public static final String column_optionC = "optionC";
    public static final String column_optionD = "optionD";
    public static final String column_answer = "answer";
    public static final String column_difficulty = "dificultyy";

    private SQLiteDatabase db;

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String level1 = "CREATE TABLE " + TABLE_NAME + " (" +
                column_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                column_question + " BLOB, " +
                column_optionA + " TEXT NOT NULL, " +
                column_optionB + " TEXT NOT NULL, " +
                column_optionC + " TEXT NOT NULL, " +
                column_optionD + " TEXT NOT NULL, " +
                column_answer + " INTEGER NOT NULL, " +
                column_difficulty + " TEXT);";

        db.execSQL(level1);

        fillQuestions();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestions(){

        // Level 1 ----------------------------------------------------------------------------------------------

        BigInteger Messi = BigInteger.valueOf(R.drawable.messi);
        Question messi = new Question(Messi.toByteArray(),
                "Ronaldinho", "Ronaldo", "Lionel Messi", "Diego Maradona", 3,
                Question.LEVEL_1);
        insertQuestions(messi);

        BigInteger CR7 = BigInteger.valueOf(R.drawable.cristianoronaldo);
        Question cr7 = new Question(CR7.toByteArray(),
                "Luis Figo", "Cristiano Ronaldo", "Neymar JR", "Wayne Rooney", 2,
                Question.LEVEL_1);
        insertQuestions(cr7);

        BigInteger Ramos = BigInteger.valueOf(R.drawable.ramos);
        Question ramos = new Question(Ramos.toByteArray(),
                "Raul", "Gerard Pique", "Sergio Ramos", "Carles Puyol", 3,
                Question.LEVEL_1);
        insertQuestions(ramos);

        BigInteger Kante = BigInteger.valueOf(R.drawable.kante);
        Question kante = new Question(Kante.toByteArray(),
                "N'golo Kante", "Paul Pogba", "Samuel Umtiti", "Antoine Griezmann", 1,
                Question.LEVEL_1);
        insertQuestions(kante);

        BigInteger Pogba = BigInteger.valueOf(R.drawable.pogba);
        Question pogba = new Question(Pogba.toByteArray(),
                "Paul Pogba", "Paolo Dybala", "Cristiano Ronaldo", "Douglas Costa", 1,
                Question.LEVEL_1);
        insertQuestions(pogba);

        BigInteger Dybala = BigInteger.valueOf(R.drawable.dybala);
        Question dybala = new Question(Dybala.toByteArray(),
                "Giorgio Chiellini", "Alessandro Del Piero", "Edinson Cavani", "Paolo Dybala", 4,
                Question.LEVEL_1);
        insertQuestions(dybala);

        BigInteger Coutinho = BigInteger.valueOf(R.drawable.coutinho);
        Question coutinho = new Question(Coutinho.toByteArray(),
               "Roberto Firmino", "Wesley Sneijder", "Arjen Robben", "Philippe Coutinho", 4,
               Question.LEVEL_1);
        insertQuestions(coutinho);

        BigInteger Hazard = BigInteger.valueOf(R.drawable.hazard);
        Question hazard = new Question(Hazard.toByteArray(),
                "Eden Hazard", "Thibaut Courtois", "Kevin de Bruyne", "Zinedine Zidane", 1,
                Question.LEVEL_1);
        insertQuestions(hazard);

        BigInteger Neymar = BigInteger.valueOf(R.drawable.neymar);
        Question neymar = new Question(Neymar.toByteArray(),
                "Neymar Jr", "Rivaldo", "Robinho", "Sergio Busquets", 1,
                Question.LEVEL_1);
        insertQuestions(neymar);

        BigInteger Salah = BigInteger.valueOf(R.drawable.salah);
        Question salah = new Question(Salah.toByteArray(),
                "Kostas Manolas", "Mohamed Salah", "Francesco Toti", "Gabriel Batistuta", 2,
                Question.LEVEL_1);
        insertQuestions(salah);

        // Level 2  ----------------------------------------------------------------------------------------------


    }

    public void insertQuestions(Question question){
        ContentValues cv = new ContentValues();
        cv.put(column_question, question.getQuestion());
        cv.put(column_optionA, question.getOptionA());
        cv.put(column_optionB, question.getOptionB());
        cv.put(column_optionC, question.getOptionC());
        cv.put(column_optionD, question.getOptionD());
        cv.put(column_answer, question.getAnswer());
        cv.put(column_difficulty, question.getDifficulty());

        db.insert(TABLE_NAME, null, cv);
    }

    public List getAllQuestions(){
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if(cursor.moveToFirst()){
            do{
                Question q = new Question();
                q.setQuestion(cursor.getBlob(cursor.getColumnIndex(column_question)));
                q.setOptionA(cursor.getString(cursor.getColumnIndex(column_optionA)));
                q.setOptionB(cursor.getString(cursor.getColumnIndex(column_optionB)));
                q.setOptionC(cursor.getString(cursor.getColumnIndex(column_optionC)));
                q.setOptionD(cursor.getString(cursor.getColumnIndex(column_optionD)));
                q.setAnswer(cursor.getInt(cursor.getColumnIndex(column_answer)));
                q.setDifficulty(cursor.getString(cursor.getColumnIndex(column_difficulty)));
                questionList.add(q);
            }while(cursor.moveToNext());
        }
        cursor.close();
        return questionList;
    }

    public List getQuestionsForExactLevel(String level){
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();

        String[] selectionArgs = new String[]{level};

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + column_difficulty + " = ?", selectionArgs);

        if(cursor.moveToFirst()){
            do{
                Question q = new Question();
                q.setQuestion(cursor.getBlob(cursor.getColumnIndex(column_question)));
                q.setOptionA(cursor.getString(cursor.getColumnIndex(column_optionA)));
                q.setOptionB(cursor.getString(cursor.getColumnIndex(column_optionB)));
                q.setOptionC(cursor.getString(cursor.getColumnIndex(column_optionC)));
                q.setOptionD(cursor.getString(cursor.getColumnIndex(column_optionD)));
                q.setAnswer(cursor.getInt(cursor.getColumnIndex(column_answer)));
                q.setDifficulty(cursor.getString(cursor.getColumnIndex(column_difficulty)));
                questionList.add(q);
            }while(cursor.moveToNext());
        }
        cursor.close();
        return questionList;
    }

}
