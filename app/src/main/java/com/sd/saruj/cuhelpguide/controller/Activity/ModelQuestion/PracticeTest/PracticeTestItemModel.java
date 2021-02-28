package com.sd.saruj.cuhelpguide.controller.Activity.ModelQuestion.PracticeTest;

public class PracticeTestItemModel {

    private int mBgColor;
    private String mTestTitle;
    private String mTestID;

    PracticeTestItemModel(int imageId, String testTitle, String testID) {
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
