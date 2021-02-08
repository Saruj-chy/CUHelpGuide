package com.sd.saruj.cuhelpguide.Activity.ModelQuestion.PracticeTest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;

import com.sd.saruj.cuhelpguide.Activity.ModelQuestion.PracticeTest.QuizContract.QuestionsTable;

import java.util.ArrayList;
import java.util.List;

public class QuizDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "quizzes.DB24";
    private static final int DB_VERSION = 8;

    public static final String TEST_1 = "test_1";
    public static final String TEST_2 = "test_2";
    public static final String TEST_3 = "test_3";
    public static final String TEST_4 = "test_4";
    public static final String TEST_5 = "test_5";
    public static final String TEST_6 = "test_6";
    public static final String TEST_7 = "test_7";

    private final String CREATE_TABLE_QUERY = "CREATE TABLE " + QuestionsTable.TABLE_NAME +
            "(" +
            QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            QuestionsTable.COLUMN_ID + " INTEGER, " +
            QuestionsTable.COLUMN_QUESTION + " TEXT, " +
            QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
            QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
            QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
            QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
            QuestionsTable.COLUMN_ANSWER + " TEXT, " +
            QuestionsTable.COLUMN_CATEGORY + " TEXT" +
            ")";

    private final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME;

    private SQLiteDatabase db;
    private List<Question> mQuestionList;

    private Bundle categoryIntentBundle;

    public QuizDBHelper(Context context, Bundle bundle) {
        super(context, DB_NAME, null, DB_VERSION);
        this.categoryIntentBundle = bundle;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        db.execSQL(CREATE_TABLE_QUERY);

        setUpQuestions();
        insertQuestions();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_QUERY);
        onCreate(db);
    }

    private void setUpQuestions() {
        mQuestionList = new ArrayList<>();

        //questions for category india
        mQuestionList.add(new Question("What Indian city is the capital of two states?", "Mumbai", "Kolkatta", "Chennai", "Chandigarh", "Chandigarh", TEST_1));
        mQuestionList.add(new Question("Which is the smallest (in area) of the following Union Territories?", "Lakshadweep", "Chandigardh", "Daman & Diu", "Delhi", "Lakshadweep", TEST_1));
        mQuestionList.add(new Question("On which river has the Hirakud dam been built?", "Godavari", "Mahanadi", "Cauvery", "Periyar", "Mahanadi", TEST_1));
        mQuestionList.add(new Question("Which state is irrigated by the Ganga canal?", "Uttar Pradesh", "Bihar", "West Bengal", "Rajasthan", "Rajasthan", TEST_1));
        mQuestionList.add(new Question("The famous Gir forests are located in", "Mysore", "Kashmir", "Gujarat", "Kerala", "Gujarat", TEST_1));

        mQuestionList.add(new Question("What Indian city is the capital of two states?", "Mumbai", "Kolkatta", "Chennai", "Chandigarh", "Chandigarh", TEST_1));
        mQuestionList.add(new Question("Which is the smallest (in area) of the following Union Territories?", "Lakshadweep", "Chandigardh", "Daman & Diu", "Delhi", "Lakshadweep", TEST_1));
        mQuestionList.add(new Question("On which river has the Hirakud dam been built?", "Godavari", "Mahanadi", "Cauvery", "Periyar", "Mahanadi", TEST_1));
        mQuestionList.add(new Question("Which state is irrigated by the Ganga canal?", "Uttar Pradesh", "Bihar", "West Bengal", "Rajasthan", "Rajasthan", TEST_1));
        mQuestionList.add(new Question("The famous Gir forests are located in", "Mysore", "Kashmir", "Gujarat", "Kerala", "Gujarat", TEST_1));


        //questions for category movies
        mQuestionList.add(new Question("সিরিয়ার জাতীয় প্রতীক কোনটি ?", "বাঘ", "সিংহ", "ঈগল", "উপরের কোনটাই নয়", "ঈগল", TEST_2));
        mQuestionList.add(new Question(" নিন্মলিখিতগুলির মধ্যে কোনটি ব্রিটেনের জাতীয় প্রতীক ?", "চন্দ্রমল্লিকা", "শ্বেতপদ্ম", "গোলাপ", "উপরের কোনটাই নয়", "গোলাপ", TEST_2));
        mQuestionList.add(new Question("ইতালীর জাতীয় প্রতীক কোনটি  ?", "চন্দ্রমল্লিকা", "শ্বেতপদ্ম", "গোলাপ", "উপরের কোনটাই নয়", "শ্বেতপদ্ম", TEST_2));
        mQuestionList.add(new Question(" ক্যাঙ্গারু কোন দেশের জাতীয় প্রতীক", "অস্ট্রেলিয়া", "দক্ষিন আফ্রিকা", "ওয়েষ্ট ইন্ডিজ", "উপরের কোনটাই নয়", "অস্ট্রেলিয়া", TEST_2));
        mQuestionList.add(new Question(" ফান্সের জাতীয় প্রতীক কি কোনটি ", "কমুদ", "অর্কিড", "হাতি", "উপরের কোনটাই নয়", "কমুদ", TEST_2));
        mQuestionList.add(new Question("নিন্মলিখিতগুলির মধ্যে কোনটি ত্রিনিদাদের জাতীয় প্রতীক কোনটি ?", "হ্যামিং বার্ড  ", " তোতাপাখি", "সারস", "উপরের কোনটাই নয়", "সারস", TEST_2));

        mQuestionList.add(new Question("সিরিয়ার জাতীয় প্রতীক কোনটি ?", "বাঘ ", "সিংহ ", "ঈগল", "উপরের কোনটাই নয়", "ঈগল", TEST_2));
        mQuestionList.add(new Question(" নিন্মলিখিতগুলির মধ্যে কোনটি ব্রিটেনের জাতীয় প্রতীক ?", "চন্দ্রমল্লিকা  ", " শ্বেতপদ্ম ", "গোলাপ", "উপরের কোনটাই নয়", "গোলাপ", TEST_2));
        mQuestionList.add(new Question("ইতালীর জাতীয় প্রতীক কোনটি  ?", "চন্দ্রমল্লিকা  ", "শ্বেতপদ্ম", "গোলাপ ", "উপরের কোনটাই নয়", "শ্বেতপদ্ম", TEST_2));
        mQuestionList.add(new Question(" ক্যাঙ্গারু কোন দেশের জাতীয় প্রতীক", "অস্ট্রেলিয়া", " দক্ষিন আফ্রিকা", "ওয়েষ্ট ইন্ডিজ ", "উপরের কোনটাই নয়", "অস্ট্রেলিয়া", TEST_2));
        mQuestionList.add(new Question(" ফান্সের জাতীয় প্রতীক কি কোনটি ", "কমুদ", " অর্কিড ", "হাতি     ", "উপরের কোনটাই নয়", "কমুদ", TEST_2));
        mQuestionList.add(new Question("নিন্মলিখিতগুলির মধ্যে কোনটি ত্রিনিদাদের জাতীয় প্রতীক কোনটি ?", "হ্যামিং বার্ড  ", " তোতাপাখি", "সারস", "উপরের কোনটাই নয়", "সারস", TEST_2));

        mQuestionList.add(new Question("সিরিয়ার জাতীয় প্রতীক কোনটি ?", "বাঘ ", "সিংহ ", "ঈগল", "উপরের কোনটাই নয়", "ঈগল", TEST_2));
        mQuestionList.add(new Question(" নিন্মলিখিতগুলির মধ্যে কোনটি ব্রিটেনের জাতীয় প্রতীক ?", "চন্দ্রমল্লিকা  ", " শ্বেতপদ্ম ", "গোলাপ", "উপরের কোনটাই নয়", "গোলাপ", TEST_2));
        mQuestionList.add(new Question("ইতালীর জাতীয় প্রতীক কোনটি  ?", "চন্দ্রমল্লিকা  ", "শ্বেতপদ্ম", "গোলাপ ", "উপরের কোনটাই নয়", "শ্বেতপদ্ম", TEST_2));
        mQuestionList.add(new Question(" ক্যাঙ্গারু কোন দেশের জাতীয় প্রতীক", "অস্ট্রেলিয়া", " দক্ষিন আফ্রিকা", "ওয়েষ্ট ইন্ডিজ ", "উপরের কোনটাই নয়", "অস্ট্রেলিয়া", TEST_2));
        mQuestionList.add(new Question(" ফান্সের জাতীয় প্রতীক কি কোনটি ", "কমুদ", " অর্কিড ", "হাতি     ", "উপরের কোনটাই নয়", "কমুদ", TEST_2));
        mQuestionList.add(new Question("নিন্মলিখিতগুলির মধ্যে কোনটি ত্রিনিদাদের জাতীয় প্রতীক কোনটি ?", "হ্যামিং বার্ড  ", " তোতাপাখি", "সারস", "উপরের কোনটাই নয়", "সারস", TEST_2));

        mQuestionList.add(new Question("What Indian city is the capital of two states?", "Mumbai", "Kolkatta", "Chennai", "Chandigarh", "Chandigarh", TEST_2));
        mQuestionList.add(new Question("Which is the smallest (in area) of the following Union Territories?", "Lakshadweep", "Chandigardh", "Daman & Diu", "Delhi", "Lakshadweep", TEST_2));
        mQuestionList.add(new Question("On which river has the Hirakud dam been built?", "Godavari", "Mahanadi", "Cauvery", "Periyar", "Mahanadi", TEST_2));
        mQuestionList.add(new Question("Which state is irrigated by the Ganga canal?", "Uttar Pradesh", "Bihar", "West Bengal", "Rajasthan", "Rajasthan", TEST_2));
        mQuestionList.add(new Question("The famous Gir forests are located in", "Mysore", "Kashmir", "Gujarat", "Kerala", "Gujarat", TEST_2));


        //questions for category tv
        mQuestionList.add(new Question("Which famous person does Phoebe believe is her Grandfather?", "Albert Einstein", "Isaac Newton", "Winston Churchill", "Beethoven", "Albert Einstein", TEST_3));
        mQuestionList.add(new Question("What is the name of the main family in this US TV series - Beverly Hills, 90210", "Keaton", "Walsh", "Tanner", "Crane", "Walsh", TEST_3));
        mQuestionList.add(new Question("What is Sheldon's middle name?", "Leonard", "John", "Lee", "Brian", "Lee", TEST_3));
        mQuestionList.add(new Question("What was finally revealed to be Jon Snow's real name in Game of Thrones?", "Aemon Targaryen", "Aegon Targaryen", "Viserys Targeryan", "Rhaegar Targeryan", "Aegon Targaryen", TEST_3));
        mQuestionList.add(new Question("What is Pied Piper?", "A company", "A scary story", "A song", "A bank", "A company", TEST_3));

        mQuestionList.add(new Question("Which famous person does Phoebe believe is her Grandfather?", "Albert Einstein", "Isaac Newton", "Winston Churchill", "Beethoven", "Albert Einstein", TEST_3));
        mQuestionList.add(new Question("What is the name of the main family in this US TV series - Beverly Hills, 90210", "Keaton", "Walsh", "Tanner", "Crane", "Walsh", TEST_3));
        mQuestionList.add(new Question("What is Sheldon's middle name?", "Leonard", "John", "Lee", "Brian", "Lee", TEST_3));
        mQuestionList.add(new Question("What was finally revealed to be Jon Snow's real name in Game of Thrones?", "Aemon Targaryen", "Aegon Targaryen", "Viserys Targeryan", "Rhaegar Targeryan", "Aegon Targaryen", TEST_3));
        mQuestionList.add(new Question("What is Pied Piper?", "A company", "A scary story", "A song", "A bank", "A company", TEST_3));

        mQuestionList.add(new Question("Which famous person does Phoebe believe is her Grandfather?", "Albert Einstein", "Isaac Newton", "Winston Churchill", "Beethoven", "Albert Einstein", TEST_3));
        mQuestionList.add(new Question("What is the name of the main family in this US TV series - Beverly Hills, 90210", "Keaton", "Walsh", "Tanner", "Crane", "Walsh", TEST_3));
        mQuestionList.add(new Question("What is Sheldon's middle name?", "Leonard", "John", "Lee", "Brian", "Lee", TEST_3));
        mQuestionList.add(new Question("What was finally revealed to be Jon Snow's real name in Game of Thrones?", "Aemon Targaryen", "Aegon Targaryen", "Viserys Targeryan", "Rhaegar Targeryan", "Aegon Targaryen", TEST_3));
        mQuestionList.add(new Question("What is Pied Piper?", "A company", "A scary story", "A song", "A bank", "A company", TEST_3));

        //questions for category science
        mQuestionList.add(new Question("What is the first element on the periodic table?", "Uranium", "Helium", "Hydrogen", "Carbon", "Hydrogen", TEST_4));
        mQuestionList.add(new Question("What constitutes the biggest part of the human brain?", "Cerebrum", "Cerebellum", "Thalamus", "Medula", "Cerebrum", TEST_4));
        mQuestionList.add(new Question("Electric current is measured using what device?", "Anemometer", "Hygrometer", "Spectrometer", "Ammeter", "Ammeter", TEST_4));
        mQuestionList.add(new Question("What planet is closest in size to Earth?", "Mercury", "Mars", "Venus", "Jupiter", "Venus", TEST_4));
        mQuestionList.add(new Question("Who introduced the idea of natural selection?", "Herbert Spencer", "Charles Darwin", "Charles Dicken", "Karl Marx", "Charles Darwin", TEST_4));

        //questions for category word
        mQuestionList.add(new Question("Which is a synonym of vigilant?", "puzzled", "watchful", "unhealthy", "wide", "watchful", TEST_5));
        mQuestionList.add(new Question("Which of these is a word for an artistic critique?", "chanteuse", "charrette", "chariot", "charlatan", "charrette", TEST_5));
        mQuestionList.add(new Question("Which of these words means \"substitute\"?", "prediction", "period", "proof", "proxy", "proxy", TEST_5));
        mQuestionList.add(new Question("Which word means something like \"paradise\"?", "unicorn", "antelope", "utility", "utopia", "utopia", TEST_5));
        mQuestionList.add(new Question("Which is a synonym of acute?", "severe", "tired", "long", "open", "severe", TEST_5));
        //questions for category sports
        mQuestionList.add(new Question("Which of these footballers retired with fewer than 100 international caps?", "Andrea Pirlo", "Dirk Kuyt", "Francesco Totti", "Philipp Lahm", "Francesco Totti", TEST_6));
        mQuestionList.add(new Question("Which tennis player made it to three singles grand slam finals in 2017?", "Venus Williams", "Rafael Nadal", "Roger Federer", "Serena Williams", "Rafael Nadal", TEST_6));
        mQuestionList.add(new Question("Which was the 1st non Test playing country to beat India in an international match?", "Canada", "Sri Lanka", "Zimbabwe", "East Africa", "Sri Lanka", TEST_6));
        mQuestionList.add(new Question("The term 'Beamer' is associated with", "Football", "Hockey", "Cricket", "Chess", "Cricket", TEST_6));
        mQuestionList.add(new Question("Jahangir Khan is famous for", "Boxing", "Squash", "Hockey", "Cricket", "Squash", TEST_6));

        mQuestionList.add(new Question("Which is a synonym of vigilant?", "puzzled", "watchful", "unhealthy", "wide", "watchful", TEST_6));
        mQuestionList.add(new Question("Which of these is a word for an artistic critique?", "chanteuse", "charrette", "chariot", "charlatan", "charrette", TEST_6));
        mQuestionList.add(new Question("Which of these words means \"substitute\"?", "prediction", "period", "proof", "proxy", "proxy", TEST_6));
        mQuestionList.add(new Question("Which word means something like \"paradise\"?", "unicorn", "antelope", "utility", "utopia", "utopia", TEST_6));
        mQuestionList.add(new Question("Which is a synonym of acute?", "severe", "tired", "long", "open", "severe", TEST_6));


        //questions for category TEST 7
        mQuestionList.add(new Question("Which of these footballers retired with fewer than 100 international caps?", "Andrea Pirlo", "Dirk Kuyt", "Francesco Totti", "Philipp Lahm", "Francesco Totti", TEST_7));
        mQuestionList.add(new Question("Which tennis player made it to three singles grand slam finals in 2017?", "Venus Williams", "Rafael Nadal", "Roger Federer", "Serena Williams", "Rafael Nadal", TEST_7));
        mQuestionList.add(new Question("Which was the 1st non Test playing country to beat India in an international match?", "Canada", "Sri Lanka", "Zimbabwe", "East Africa", "Sri Lanka", TEST_7));
        mQuestionList.add(new Question("The term 'Beamer' is associated with", "Football", "Hockey", "Cricket", "Chess", "Cricket", TEST_7));
        mQuestionList.add(new Question("Jahangir Khan is famous for", "Boxing", "Squash", "Hockey", "Cricket", "Squash", TEST_7));


        mQuestionList.add(new Question("Which is a synonym of vigilant?", "puzzled", "watchful", "unhealthy", "wide", "watchful", TEST_7));
        mQuestionList.add(new Question("Which of these is a word for an artistic critique?", "chanteuse", "charrette", "chariot", "charlatan", "charrette", TEST_7));
        mQuestionList.add(new Question("Which of these words means \"substitute\"?", "prediction", "period", "proof", "proxy", "proxy", TEST_7));
        mQuestionList.add(new Question("Which word means something like \"paradise\"?", "unicorn", "antelope", "utility", "utopia", "utopia", TEST_7));
        mQuestionList.add(new Question("Which is a synonym of acute?", "severe", "tired", "long", "open", "severe", TEST_7));

        mQuestionList.add(new Question("Which famous person does Phoebe believe is her Grandfather?", "Albert Einstein", "Isaac Newton", "Winston Churchill", "Beethoven", "Albert Einstein", TEST_7));
        mQuestionList.add(new Question("What is the name of the main family in this US TV series - Beverly Hills, 90210", "Keaton", "Walsh", "Tanner", "Crane", "Walsh", TEST_7));
        mQuestionList.add(new Question("What is Sheldon's middle name?", "Leonard", "John", "Lee", "Brian", "Lee", TEST_7));
        mQuestionList.add(new Question("What was finally revealed to be Jon Snow's real name in Game of Thrones?", "Aemon Targaryen", "Aegon Targaryen", "Viserys Targeryan", "Rhaegar Targeryan", "Aegon Targaryen", TEST_7));
        mQuestionList.add(new Question("What is Pied Piper?", "A company", "A scary story", "A song", "A bank", "A company", TEST_7));

        mQuestionList.add(new Question("Which of these footballers retired with fewer than 100 international caps?", "Andrea Pirlo", "Dirk Kuyt", "Francesco Totti", "Philipp Lahm", "Francesco Totti", TEST_7));
        mQuestionList.add(new Question("Which tennis player made it to three singles grand slam finals in 2017?", "Venus Williams", "Rafael Nadal", "Roger Federer", "Serena Williams", "Rafael Nadal", TEST_7));
        mQuestionList.add(new Question("Which was the 1st non Test playing country to beat India in an international match?", "Canada", "Sri Lanka", "Zimbabwe", "East Africa", "Sri Lanka", TEST_7));
        mQuestionList.add(new Question("The term 'Beamer' is associated with", "Football", "Hockey", "Cricket", "Chess", "Cricket", TEST_7));
        mQuestionList.add(new Question("Jahangir Khan is famous for", "Boxing", "Squash", "Hockey", "Cricket", "Squash", TEST_7));


        mQuestionList.add(new Question("Which is a synonym of vigilant?", "puzzled", "watchful", "unhealthy", "wide", "watchful", TEST_7));
        mQuestionList.add(new Question("Which of these is a word for an artistic critique?", "chanteuse", "charrette", "chariot", "charlatan", "charrette", TEST_7));
        mQuestionList.add(new Question("Which of these words means \"substitute\"?", "prediction", "period", "proof", "proxy", "proxy", TEST_7));
        mQuestionList.add(new Question("Which word means something like \"paradise\"?", "unicorn", "antelope", "utility", "utopia", "utopia", TEST_7));
        mQuestionList.add(new Question("Which is a synonym of acute?", "severe", "tired", "long", "open", "severe", TEST_7));

        mQuestionList.add(new Question("Which famous person does Phoebe believe is her Grandfather?", "Albert Einstein", "Isaac Newton", "Winston Churchill", "Beethoven", "Albert Einstein", TEST_7));
        mQuestionList.add(new Question("What is the name of the main family in this US TV series - Beverly Hills, 90210", "Keaton", "Walsh", "Tanner", "Crane", "Walsh", TEST_7));
        mQuestionList.add(new Question("What is Sheldon's middle name?", "Leonard", "John", "Lee", "Brian", "Lee", TEST_7));
        mQuestionList.add(new Question("What was finally revealed to be Jon Snow's real name in Game of Thrones?", "Aemon Targaryen", "Aegon Targaryen", "Viserys Targeryan", "Rhaegar Targeryan", "Aegon Targaryen", TEST_7));
        mQuestionList.add(new Question("What is Pied Piper?", "A company", "A scary story", "A song", "A bank", "A company", TEST_7));


    }

    private void insertQuestions() {
        for(Question q : mQuestionList) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(QuestionsTable.COLUMN_QUESTION, q.getmQuestion());
            contentValues.put(QuestionsTable.COLUMN_OPTION1, q.getmOption1());
            contentValues.put(QuestionsTable.COLUMN_OPTION2, q.getmOption2());
            contentValues.put(QuestionsTable.COLUMN_OPTION3, q.getmOption3());
            contentValues.put(QuestionsTable.COLUMN_OPTION4, q.getmOption4());
            contentValues.put(QuestionsTable.COLUMN_ANSWER, q.getmAnswer());
            contentValues.put(QuestionsTable.COLUMN_CATEGORY, q.getmCategory());
            db.insert(QuestionsTable.TABLE_NAME, null, contentValues);
        }
    }

    public ArrayList<Question> getAllQuestions(String categoryID) {
        Log.d("TAG", "Getting all questions for : " + categoryID);
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        String SELECT_TABLE_QUERY = "SELECT * FROM " + QuestionsTable.TABLE_NAME + " WHERE " + QuestionsTable.COLUMN_CATEGORY + " = \"" + categoryID + "\"";
        Cursor cursor = db.rawQuery(SELECT_TABLE_QUERY, null);
        if(cursor.moveToFirst()) {
            do {
                Question question = new Question();
                question.setmQuestion(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setmOption1(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setmOption2(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setmOption3(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setmOption4(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setmAnswer(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_ANSWER)));
                questionList.add(question);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return questionList;
    }
}
