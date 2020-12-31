package com.sd.saruj.cuhelpguide.Class;

import android.content.Context;

import com.sd.saruj.cuhelpguide.Interfaces.DUnitSubjectViewInterfaces;
import com.sd.saruj.cuhelpguide.Interfaces.DepartmentNameInterfaces;
import com.sd.saruj.cuhelpguide.ModelClass.Faculty;

import java.util.List;

public class DUnitSubjectViewClass implements DUnitSubjectViewInterfaces {

    Context context ;

    public DUnitSubjectViewClass(Context context) {
        this.context = context;
    }


    @Override
    public List<Faculty> getDepartmentListByPosition(String[] departmentNameList, List<Faculty> productList) {
        productList.clear();
        for(int i=0; i<departmentNameList.length; i++){
            productList.add(
                    new Faculty(
                            1,
                            departmentNameList[i]
                    )
            );
        }
        return productList;
    }
}
