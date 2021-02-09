package com.sd.saruj.cuhelpguide.Activity.ModelQuestion.ModelDD;

import android.content.Context;

import com.sd.saruj.cuhelpguide.Activity.ModelQuestion.ModelTest.DbHelper;
import com.sd.saruj.cuhelpguide.Activity.ModelQuestion.ModelTest.DbHelper2;

public class DBBuildChain {

    Context mCtx;

    public DBBuildChain(Context mCtx) {
        this.mCtx = mCtx;
    }

    public DBHandler createChain(){
        DBHandler dbHandler = new DbHelper(mCtx);
        DBHandler dbHandler2 = new DbHelper2(mCtx);

        dbHandler.next(dbHandler2);
        return dbHandler ;


    }
}
