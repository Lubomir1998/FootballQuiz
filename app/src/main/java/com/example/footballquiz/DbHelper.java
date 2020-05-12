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

    //Questions are different levels and some are commented in debuging purposes
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
                Question.LEVEL_2);
        insertQuestions(dybala);


        BigInteger Coutinho = BigInteger.valueOf(R.drawable.coutinho);
        Question coutinho = new Question(Coutinho.toByteArray(),
               "Roberto Firmino", "Wesley Sneijder", "Arjen Robben", "Philippe Coutinho", 4,
               Question.LEVEL_2);
        insertQuestions(coutinho);

        BigInteger Hazard = BigInteger.valueOf(R.drawable.hazard);
        Question hazard = new Question(Hazard.toByteArray(),
                "Eden Hazard", "Thibaut Courtois", "Kevin de Bruyne", "Zinedine Zidane", 1,
                Question.LEVEL_2);
        insertQuestions(hazard);

        BigInteger Neymar = BigInteger.valueOf(R.drawable.neymar);
        Question neymar = new Question(Neymar.toByteArray(),
                "Neymar Jr", "Rivaldo", "Robinho", "Sergio Busquets", 1,
                Question.LEVEL_2);
        insertQuestions(neymar);

        BigInteger Salah = BigInteger.valueOf(R.drawable.salah);
        Question salah = new Question(Salah.toByteArray(),
                "Kostas Manolas", "Mohamed Salah", "Francesco Toti", "Gabriel Batistuta", 2,
                Question.LEVEL_2);
        insertQuestions(salah);

        BigInteger Neuer = BigInteger.valueOf(R.drawable.neuer);
        Question neuer = new Question(Neuer.toByteArray(),
                "Manuel Neuer", "Oliver Kahn", "Marc Andre ter Stegen", "Franz Beckenbauer", 1,
                Question.LEVEL_3);
        insertQuestions(neuer);

        BigInteger James = BigInteger.valueOf(R.drawable.james);
        Question james = new Question(James.toByteArray(),
                "Cesc Fabregas", "Juan Cuadrado", "James Rodriguez", "David Ospina", 3,
                Question.LEVEL_3);
        insertQuestions(james);

        BigInteger Costa = BigInteger.valueOf(R.drawable.costa);
        Question costa = new Question(Costa.toByteArray(),
                "David Silva", "Koke", "Fernando Torres", "Diego Costa", 4,
                Question.LEVEL_3);
        insertQuestions(costa);

        BigInteger Modric = BigInteger.valueOf(R.drawable.modric);
        Question modric = new Question(Modric.toByteArray(),
                "Samir Handanovic", "Luca Modric", "Mario Mandzukic", "Ivan Rakitic", 2,
                Question.LEVEL_3);
        insertQuestions(modric);

        BigInteger Mbape = BigInteger.valueOf(R.drawable.mbape);
        Question mbape = new Question(Mbape.toByteArray(),
                "Kylian M'bappe", "Antoine Griezmann", "Bernardo Silva", "Blaise Matuidi", 1,
                Question.LEVEL_3);
        insertQuestions(mbape);

        BigInteger Icardi = BigInteger.valueOf(R.drawable.icardi);
        Question icardi = new Question(Icardi.toByteArray(),
                "Edinson Cavani", "Fabio Quagliarella", "Neymar Jr", "Mauro Icardi", 4,
                Question.LEVEL_4);
        insertQuestions(icardi);

        // Level 2  ----------------------------------------------------------------------------------------------

        BigInteger Lacazaet = BigInteger.valueOf(R.drawable.lacazet);
        Question lacazet = new Question(Lacazaet.toByteArray(),
                "Robin van Persie", "Nicolas Anelka", "Alexandre Lacazette", "Patric Viera", 3,
                Question.LEVEL_4);
        insertQuestions(lacazet);

        BigInteger Matuidi = BigInteger.valueOf(R.drawable.matuidi);
        Question matuidi = new Question(Matuidi.toByteArray(),
                "Kylian M'bappe", "Marco Verratti", "Paul Pogba", "Blaise Matuidi", 4,
                Question.LEVEL_4);
        insertQuestions(matuidi);

        BigInteger Tadic = BigInteger.valueOf(R.drawable.tadic);
        Question tadic = new Question(Tadic.toByteArray(),
                "Frankie de Jong", "Nemanja Matic", "Dusan Tadic", "Branislav Ivanovic", 3,
                Question.LEVEL_4);
        insertQuestions(tadic);

        BigInteger Lukaku = BigInteger.valueOf(R.drawable.lukaku);
        Question lukaku = new Question(Lukaku.toByteArray(),
                "Jordan Lukaku", "Romelu Lukaku", "Juan Mata", "Ross Barkley", 2,
                Question.LEVEL_4);
        insertQuestions(lukaku);

        BigInteger Son = BigInteger.valueOf(R.drawable.son);
        Question son = new Question(Son.toByteArray(),
                "Son Heung-min", "Harry Kane", "Dimitar Berbatov", "Kevin Folnad", 1,
                Question.LEVEL_5);
        insertQuestions(son);

        BigInteger Kane = BigInteger.valueOf(R.drawable.kane);
        Question kane = new Question(Kane.toByteArray(),
                "Frank Lampard", "Jamie Vardy", "Dany Rose", "Harry Kane", 4,
                Question.LEVEL_5);
        insertQuestions(kane);

        BigInteger Willian = BigInteger.valueOf(R.drawable.willian);
        Question willian = new Question(Willian.toByteArray(),
                "Fernandinho", "Douglas Costa", "Willian", "Juan Bernard", 3,
                Question.LEVEL_5);
        insertQuestions(willian);

        BigInteger Insigne = BigInteger.valueOf(R.drawable.insigne);
        Question insigne = new Question(Insigne.toByteArray(),
                "Lorenzo Insigne", "Jorginho", "Marek Hamsik", "Marco Verati", 1,
                Question.LEVEL_5);
        insertQuestions(insigne);

        BigInteger Verratti = BigInteger.valueOf(R.drawable.veratti);
        Question verratti = new Question(Verratti.toByteArray(),
                "Marco Verratti", "Ciro Immobile", "Edinson Cavani", "Lorenzo Insigne", 1,
                Question.LEVEL_5);
        insertQuestions(verratti);

        BigInteger Alba = BigInteger.valueOf(R.drawable.alba);
        Question alba = new Question(Alba.toByteArray(),
                "David Villa", "Sergio Busquets", "Andres Iniesta", "Jordi Alba", 4,
                Question.LEVEL_6);
        insertQuestions(alba);

        BigInteger Alonso = BigInteger.valueOf(R.drawable.alonso);
        Question alonso = new Question(Alonso.toByteArray(),
                "Juan Mata", "Fernando Torres", "Marcos Alonso", "David Silva", 3,
                Question.LEVEL_6);
        insertQuestions(alonso);

        BigInteger Perisic = BigInteger.valueOf(R.drawable.perisic);
        Question perisic = new Question(Perisic.toByteArray(),
                "Ivan Perisic", "Mario Mandzukic", "Robert Lewandowski", "Luca Modric", 1,
                Question.LEVEL_6);
        insertQuestions(perisic);

        BigInteger Higuain = BigInteger.valueOf(R.drawable.higuain);
        Question higuain = new Question(Higuain.toByteArray(),
                "Lorenzo Insigne", "Suso", "Gonzalo Higuain", "Edinson Cavani", 3,
                Question.LEVEL_6);
        insertQuestions(higuain);

        BigInteger Ibra = BigInteger.valueOf(R.drawable.ibra);
        Question ibra = new Question(Ibra.toByteArray(),
                "Zlatan Ibrahimovic", "Ronaldo", "Angel di Maria", "Samuel Eto'o", 1,
                Question.LEVEL_6);
        insertQuestions(ibra);

/*
        BigInteger Pjanic = BigInteger.valueOf(R.drawable.pjanic);
        Question pjanic = new Question(Pjanic.toByteArray(),
                "Edin Dzeko", "Wojciech Szczęsny", "Miralem Pjanic", "Mario Mandzukic", 3,
                Question.LEVEL_1);
        insertQuestions(pjanic);


        BigInteger Jovic = BigInteger.valueOf(R.drawable.jovic);
        Question jovic = new Question(Jovic.toByteArray(),
                "Mateo Kovacic", "Luca Jovic", "Ante Rebic", "Luca Modric", 2,
                Question.LEVEL_6);
        insertQuestions(jovic);

        BigInteger Douglascosta = BigInteger.valueOf(R.drawable.douglascosta);
        Question douglascosta = new Question(Douglascosta.toByteArray(),
                "Diego Costa", "Ronaldinho", "Willian", "Douglas Costa", 4,
                Question.LEVEL_6);
        insertQuestions(douglascosta);

         */

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
