package com.sd.saruj.cuhelpguide.controller.Activity.ModelQuestion.ModelDD;

import com.sd.saruj.cuhelpguide.model.QuestionModel;

import java.util.List;

public interface DBHandler {


    List<QuestionModel> process(String testName) ;
    void next(DBHandler h);

}
