package com.sd.saruj.cuhelpguide.Activity.ModelQuestion.PracticeTest;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sd.saruj.cuhelpguide.R;

import java.util.ArrayList;
import java.util.Collections;

import static com.sd.saruj.cuhelpguide.Activity.ModelQuestion.PracticeTest.PracticeTestAdapter.CATEGORY_COLOR;
import static com.sd.saruj.cuhelpguide.Activity.ModelQuestion.PracticeTest.PracticeTestAdapter.CATEGORY_ID;
import static com.sd.saruj.cuhelpguide.Activity.ModelQuestion.PracticeTest.PracticeTestAdapter.CATEGORY_TITLE;

public class QuestionActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private QuestionAdapter mAdapter;
    private ArrayList<Question> mQuestionList;

    private QuizDBHelper mDbHelper;

    private ConstraintLayout mParentLayout;
    private TextView mScoreTextView;
    private TextView mRemaningQuestionsTextView;
    private int mTotalQuestions;
    private int mScore;
    private int mSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      //  supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);





        Bundle categoryBundle = null;
        if (getIntent() != null) {
            categoryBundle = getIntent().getExtras();
        }
     //   setTitle(categoryBundle.getString(CATEGORY_TITLE));

        //  ================
        mParentLayout = findViewById(R.id.question_layout);
        if (categoryBundle != null) {
            String hexColor = String.format("#%06X", (0xFFFFFF & categoryBundle.getInt(CATEGORY_COLOR)));
            hexColor = "#44"+hexColor.substring(1);
            mParentLayout.setBackgroundColor(Color.parseColor(hexColor));
        }

        mScoreTextView = findViewById(R.id.score);
        mRemaningQuestionsTextView = findViewById(R.id.remaining_questions);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setHasFixedSize(true);

        mDbHelper = new QuizDBHelper(this, categoryBundle);
        if (categoryBundle != null) {
            mQuestionList = mDbHelper.getAllQuestions(categoryBundle.getString(CATEGORY_ID));
            mTotalQuestions = mQuestionList.size();
            mScore = 0;
            mSelect = 0;
            displayScore();
        }


        mAdapter = new QuestionAdapter(this, mQuestionList, categoryBundle.getString(CATEGORY_ID) ,categoryBundle.getString(CATEGORY_TITLE));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);

        //=================   this method is used for question shuffle(every time different question)
        Collections.shuffle(mQuestionList);
    }

    public void displayScore() {
        String scoreString = "Score " + mScore + "/" + mSelect;
        mScoreTextView.setText(scoreString);
        mRemaningQuestionsTextView.setText("Remaining: " + mTotalQuestions--);
    }

    public void updateScore() {
        mScore++;
    }

    public void selectScore() {
        mSelect++;
    }
}
