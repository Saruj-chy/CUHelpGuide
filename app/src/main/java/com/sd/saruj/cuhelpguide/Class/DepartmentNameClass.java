package com.sd.saruj.cuhelpguide.Class;

import android.content.Context;

import com.sd.saruj.cuhelpguide.Interfaces.DepartmentNameInterfaces;
import com.sd.saruj.cuhelpguide.ModelClass.Faculty;

import java.util.List;

public class DepartmentNameClass implements DepartmentNameInterfaces {

    Context context ;

    public DepartmentNameClass(Context context) {
        this.context = context;
    }


    @Override
    public List<Faculty> getAllDepartmentName(String[] departmentNameList, String type, List<Faculty> productList) {
        for(int i=0; i<departmentNameList.length; i++){
            productList.add(
                    new Faculty(
                            i+1,
                            departmentNameList[i],
                            type
                    )
            );
        }
        return productList;
    }
}
