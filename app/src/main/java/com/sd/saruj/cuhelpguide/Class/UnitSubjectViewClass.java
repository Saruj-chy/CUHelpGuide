package com.sd.saruj.cuhelpguide.Class;

import android.content.Context;

import com.sd.saruj.cuhelpguide.Interfaces.DepartmentNameInterfaces;
import com.sd.saruj.cuhelpguide.Interfaces.UnitSubjectViewInterfaces;
import com.sd.saruj.cuhelpguide.ModelClass.Faculty;

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
