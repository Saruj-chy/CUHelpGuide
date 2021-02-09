package com.sd.saruj.cuhelpguide.Activity.ModelQuestion.ModelDD;

import com.sd.saruj.cuhelpguide.ModelClass.QuestionModel;

import java.util.List;

public interface DBHandler {


    List<QuestionModel> process(String testName) ;
    void next(DBHandler h);

}
