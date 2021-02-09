package com.sd.saruj.cuhelpguide.Activity.ModelQuestion.PracticeTest;

import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.sd.saruj.cuhelpguide.R;

import java.util.ArrayList;

public class PracticeTestActivity extends AppCompatActivity {

    private GridView mGridView;
    private PracticeTestAdapter mCategoryAdapter;
    private ArrayList<PracticeTestItemModel> mCategoryItems;
    //======   color
    private int[] mColors;

    private String[] mCategoryTitles;
    private String[] mCategoryID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_test);

        setUpCategoryItems();

        mGridView = findViewById(R.id.categories_list);
        mCategoryAdapter = new PracticeTestAdapter(this, R.layout.question_grid_view_item, mCategoryItems);
        mGridView.setAdapter(mCategoryAdapter);

    }

    private void setUpCategoryItems() {
        mCategoryItems = new ArrayList<>();
        mCategoryTitles = getResources().getStringArray(R.array.test_title);
        mCategoryID = getResources().getStringArray(R.array.test_ID);

        //===========   color  2
        mColors = getResources().getIntArray(R.array.colors);

        for(int i = 0; i< mCategoryTitles.length; i++) {
            mCategoryItems.add(new PracticeTestItemModel(mColors[i], mCategoryTitles[i], mCategoryID[i]));
            Log.d("TAG", "Title\t" + mCategoryTitles[i] + "\tID\t" + mCategoryID[i]);
        }
    }
}
