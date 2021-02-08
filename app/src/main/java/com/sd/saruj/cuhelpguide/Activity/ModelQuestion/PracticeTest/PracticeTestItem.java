package com.sd.saruj.cuhelpguide.Activity.ModelQuestion.PracticeTest;

public class PracticeTestItem {

    private int mBgColor;
    private String mTestTitle;
    private String mTestID;

    PracticeTestItem(int imageId, String testTitle, String testID) {
        this.mBgColor = imageId;
        this.mTestTitle = testTitle;
        this.mTestID = testID;
    }

    public int getmBgColor() {
        return mBgColor;
    }

    public String getmCategoryTitle() {
        return mTestTitle;
    }

    public String getmCategoryID() {
        return mTestID;
    }
}
