package com.sd.saruj.cuhelpguide.controller.Activity.ModelQuestion.ModelTest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.sd.saruj.cuhelpguide.controller.Activity.ModelQuestion.ModelDD.DBHandler;
import com.sd.saruj.cuhelpguide.model.QuestionModel;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper implements DBHandler {

    //DB version, table and database name
    private static final int DB_VERSION1 = 1;
    private static final String DB_NAME1 = "quizdb5";
    private static final String DB_TABLE1 = "quiztable3";

    //table column names
    private static final String KEY_ID1 = "id1";
    private static final String KEY_QUES1 = "question1";
    private static final String KEY_ANSWER1 = "answer1";
    private static final String KEY_OPTA1 = "optA1";
    private static final String KEY_OPTB1 = "optB1";
    private static final String KEY_OPTC1 = "optC1";

    private SQLiteDatabase dbase;
    private int rowCount = 0;

    public DbHelper(Context context){
        super(context,DB_NAME1,null,DB_VERSION1);
    }

    //=====interface
    DBHandler handleInterface ;

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String sqlQuery = String.format("CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT )", DB_TABLE1, KEY_ID1, KEY_QUES1, KEY_ANSWER1, KEY_OPTA1, KEY_OPTB1, KEY_OPTC1);
        Log.d("TaskDBHelper", "Query to form table" + sqlQuery);
        db.execSQL(sqlQuery);
        addQuestions();
    }

    private void addQuestions() {
        QuestionModel q1 = new QuestionModel("Which company is the largest manufacturer of network equipment ?", "HP", "IBM", "CICSO", "CISCO");
        this.addQuestionToDB(q1);
        QuestionModel q2 = new QuestionModel("Which of the following is NOT an operating system ?", "Linux", "BIOS", "DOS", "BIOS");
        this.addQuestionToDB(q2);
        QuestionModel q3 = new QuestionModel("Who is the founder of Apple Inc. ?", "Jose Thomas", "Bill Gates", "Steve Jobs", "Steve Jobs");
        this.addQuestionToDB(q3);
        QuestionModel q4 = new QuestionModel("Who is the first cricketer to score an international double century in 50-over match ?", "Ricky Ponting", "Sachin Tendulkar", "Brian Lara", "Sachin Tendulkar");
        this.addQuestionToDB(q4);
        QuestionModel q5 = new QuestionModel("Which is the biggest largest city in the world ?", "Vienna", "Reno", "Delhi", "Reno");
        this.addQuestionToDB(q5);
        QuestionModel q6 = new QuestionModel("Which is the biggest desert in in the world ?", "Thar", "Sahara", "Mohave", "Sahara");
        this.addQuestionToDB(q6);
        QuestionModel q7 = new QuestionModel("Which is the the largest coffee growing country in the world ?", "Brazil", "India", "Myanmar", "Brazil");
        this.addQuestionToDB(q7);
        QuestionModel q8 = new QuestionModel("Which is the longest river in the world ?", "Ganga", "Amazon", "Nile", "Nile");
        this.addQuestionToDB(q8);
        QuestionModel q9 = new QuestionModel("Which country is known as the country of copper ?", "Somalia", "Cameroon", "Zambia", "Zambia");
        this.addQuestionToDB(q9);
        QuestionModel q10 = new QuestionModel("Which is the world's oldest known city ?", "Rome", "Damascus", "Jerusalem", "Damascus");
        this.addQuestionToDB(q10);
        QuestionModel q11 = new QuestionModel("Who is the first Prime minister of India ?", "Jawaharlal Nehru", "Dr.Rajendra Prasad", "Lal Bahadur Shasthri", "Jawaharlal Nehru");
        this.addQuestionToDB(q11);
        QuestionModel q12 = new QuestionModel("Which city is known as the city of canals ?", "Paris", "Venice", "London", "Venice");
        this.addQuestionToDB(q12);
        QuestionModel q13 = new QuestionModel("Australia was discovered by ?", "James Cook", "Columbus", "Magallan", "James Cook");
        this.addQuestionToDB(q13);
        QuestionModel q14 = new QuestionModel("The national flower of Britain is ?", "Lily", "Rose", "Lotus", "Rose");
        this.addQuestionToDB(q14);
        QuestionModel q15 = new QuestionModel("The red cross was founded by ?", "Gullivar Crossby", "Alexandra Maria Lara", "Jean Henri Durant", "Jean Henri Durant");
        this.addQuestionToDB(q15);
        QuestionModel q16 = new QuestionModel("Which place is known as the roof of the world ?", "Alphs", "Tibet", "Nepal", "Tibet");
        this.addQuestionToDB(q16);
        QuestionModel q17 = new QuestionModel("Who invented washing machine ?", "James King", "Alfred Vincor", "Christopher Marcossi", "James King");
        this.addQuestionToDB(q17);
        QuestionModel q18 = new QuestionModel("Who won the Football world Cup in 2014 ?", "Italy", "Argentina", "Germany", "Germany");
        this.addQuestionToDB(q18);
        QuestionModel q19 = new QuestionModel("Who won the Cricket World cup in 2011 ?", "Australia", "India", "England", "India");
        this.addQuestionToDB(q19);
        QuestionModel q20 = new QuestionModel("The number regarded as the lucky number in Italy is ?", "13", "7", "9", "13");
        this.addQuestionToDB(q20);
    }

    public void addQuestionToDB(QuestionModel q){
        ContentValues values = new ContentValues();
        values.put(KEY_QUES1, q.getQuestion());
        values.put(KEY_ANSWER1,q.getAnswer());
        values.put(KEY_OPTA1,q.getOptA());
        values.put(KEY_OPTB1,q.getOptB());
        values.put(KEY_OPTC1,q.getOptC());
        dbase.insert(DB_TABLE1, null, values);
    }

    public List <QuestionModel> getAllQuestions(){
        List <QuestionModel> questionList = new ArrayList<QuestionModel>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM "+DB_TABLE1;
        Cursor cursor = dbase.rawQuery(selectQuery,null);
        rowCount = cursor.getCount();

        if(cursor.moveToFirst()){
            do{
                QuestionModel q = new QuestionModel();
                q.setId(cursor.getInt(0));
                q.setQuestion(cursor.getString(1));
                q.setAnswer(cursor.getString(2));
                q.setOptA(cursor.getString(3));
                q.setOptB(cursor.getString(4));
                q.setOptC(cursor.getString(5));

                questionList.add(q);

            }while (cursor.moveToNext());
        }
        return questionList;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+DB_TABLE1);
        onCreate(db);
    }

    public int getRowCount(){
        return rowCount;
    }

    @Override
    public List<QuestionModel> process(String testName) {

        if(testName.equalsIgnoreCase("model1")){
            return getAllQuestions();
        }else{
            return handleInterface.process(testName);
        }
    }

    @Override
    public void next(DBHandler h) {

        this.handleInterface = h ;

    }
}
