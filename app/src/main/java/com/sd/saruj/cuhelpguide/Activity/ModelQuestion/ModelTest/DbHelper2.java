package com.sd.saruj.cuhelpguide.Activity.ModelQuestion.ModelTest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.sd.saruj.cuhelpguide.Activity.ModelQuestion.ModelDD.DBHandler;
import com.sd.saruj.cuhelpguide.ModelClass.QuestionModel;

import java.util.ArrayList;
import java.util.List;

public class DbHelper2 extends SQLiteOpenHelper implements DBHandler {

    //DB version, table and database name
    private static final int DB_VERSION2 = 2;
    private static final String DB_NAME2 = "quizdb6";
    private static final String DB_TABLE2 = "quiztable4";

    //table column names
    private static final String KEY_ID2 = "id2";
    private static final String KEY_QUES2 = "question2";
    private static final String KEY_ANSWER2 = "answer2";
    private static final String KEY_OPTA2 = "optA2";
    private static final String KEY_OPTB2 = "optB2";
    private static final String KEY_OPTC2 = "optC2";

    private SQLiteDatabase dbase;
    private int rowCount = 0;

    //=====interface
    DBHandler handleInterface ;

    public DbHelper2(Context context){
        super(context,DB_NAME2,null,DB_VERSION2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String sqlQuery = String.format("CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT )", DB_TABLE2, KEY_ID2, KEY_QUES2, KEY_ANSWER2, KEY_OPTA2, KEY_OPTB2, KEY_OPTC2);
        Log.d("TaskDBHelper", "Query to form table" + sqlQuery);
        db.execSQL(sqlQuery);
        addQuestions2();
    }

    private void addQuestions2() {
        QuestionModel q1 = new QuestionModel("1. বাংলাদেশের রাজধানী নিচের কোনটি?", "সিলেট", "ঢাকা", "নোয়াখালী", "ঢাকা");
        this.addQuestionToDB(q1);
        QuestionModel q2 = new QuestionModel("2. বাংলাদেশের সবচেয়ে বড় বিভাগ কোনটি?", "সিলেট", "ঢাকা", "চট্টগ্রাম", "চট্টগ্রাম");
        this.addQuestionToDB(q2);
        QuestionModel q3 = new QuestionModel("3. বাংলাদেশের জাতীয় খেলা কোনটি? ", "ক্রিকেট", "ফুটবল", "কাবাডি", "কাবাডি");
        this.addQuestionToDB(q3);
        QuestionModel q4 = new QuestionModel("4. বাংলাদেশের জাতীয় ফুল কোনটি?", "শাপলা", "গোলাপ", "রজনীগন্ধ্যা", "শাপলা");
        this.addQuestionToDB(q4);
        QuestionModel q5 = new QuestionModel(" 5. বাংলাদেশের জাতীয় পাখির নাম কি? ", "ময়না", "শালিক", "দোয়েল", "দোয়েল");
        this.addQuestionToDB(q5);
        QuestionModel q6 = new QuestionModel("6. বাংলাদেশের রাজধানী নিচের কোনটি?", "সিলেট", "ঢাকা", "নোয়াখালী", "ঢাকা");
        this.addQuestionToDB(q6);
        QuestionModel q7 = new QuestionModel("7. বাংলাদেশের সবচেয়ে বড় বিভাগ কোনটি?", "সিলেট", "ঢাকা", "চট্টগ্রাম", "চট্টগ্রাম");
        this.addQuestionToDB(q7);
        QuestionModel q8 = new QuestionModel("8. বাংলাদেশের জাতীয় খেলা কোনটি? ", "ক্রিকেট", "ফুটবল", "কাবাডি", "কাবাডি");
        this.addQuestionToDB(q8);
        QuestionModel q9 = new QuestionModel("9. বাংলাদেশের জাতীয় ফুল কোনটি?", "শাপলা", "গোলাপ", "রজনীগন্ধ্যা", "শাপলা");
        this.addQuestionToDB(q9);
        QuestionModel q10 = new QuestionModel(" 10. বাংলাদেশের জাতীয় পাখির নাম কি? ", "ময়না", "শালিক", "দোয়েল", "দোয়েল");
        this.addQuestionToDB(q10);



    }

    public void addQuestionToDB(QuestionModel q){
        ContentValues values = new ContentValues();
        values.put(KEY_QUES2, q.getQuestion());
        values.put(KEY_ANSWER2,q.getAnswer());
        values.put(KEY_OPTA2,q.getOptA());
        values.put(KEY_OPTB2,q.getOptB());
        values.put(KEY_OPTC2,q.getOptC());
        dbase.insert(DB_TABLE2, null, values);
    }

    public List<QuestionModel> getAllQuestions(){
        List <QuestionModel> questionList = new ArrayList<QuestionModel>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM "+DB_TABLE2;
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
        db.execSQL("DROP TABLE IF EXISTS "+DB_TABLE2);
        onCreate(db);
    }

    public int getRowCount(){
        return rowCount;
    }

    @Override
    public List<QuestionModel> process(String testName) {

        if(testName.equalsIgnoreCase("model2")){
            return getAllQuestions();
        }else{
            handleInterface.process(testName);
        }

        return null ;

    }

    @Override
    public void next(DBHandler h) {

        this.handleInterface = h ;

    }
}
