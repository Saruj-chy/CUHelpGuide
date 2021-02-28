package com.sd.saruj.cuhelpguide.controller.Class;

import android.content.Context;

import com.sd.saruj.cuhelpguide.controller.Interfaces.UnitSubjectViewInterfaces;
import com.sd.saruj.cuhelpguide.model.Faculty;

import java.util.List;

public class UnitSubjectViewClass implements UnitSubjectViewInterfaces {

    Context context ;

    public UnitSubjectViewClass(Context context) {
        this.context = context;
    }


    @Override
    public List<Faculty> getUnitName(String[] unitNameList, String type, List<Faculty> productList) {
        for(int i=0; i<unitNameList.length; i++){
            productList.add(
                    new Faculty(
                            i+1,
                            unitNameList[i],
                            type
                    )
            );
        }
        return productList;
    }
}
