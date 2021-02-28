package com.sd.saruj.cuhelpguide.controller.Interfaces;

import com.sd.saruj.cuhelpguide.model.Faculty;

import java.util.List;

public interface DepartmentNameInterfaces {

    List<Faculty> getAllDepartmentName(String[] departmentNameList, String type, List<Faculty> productList) ;
}
