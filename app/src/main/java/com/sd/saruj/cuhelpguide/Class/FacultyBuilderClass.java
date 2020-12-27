package com.sd.saruj.cuhelpguide.Class;

import com.sd.saruj.cuhelpguide.ModelClass.FacultyBuilderModel;

public class FacultyBuilderClass {

    private  int id;
    private  String name;
    private  String title;
    private  String details;
    private String type;


    public FacultyBuilderClass setId(int id) {
        this.id = id;
        return this ;
    }

    public FacultyBuilderClass setName(String name) {
        this.name = name;
        return this ;
    }

    public FacultyBuilderClass setTitle(String title) {
        this.title = title;
        return this ;
    }

    public FacultyBuilderClass setDetails(String details) {
        this.details = details;
        return this ;
    }

    public FacultyBuilderClass setType(String type) {
        this.type = type;
        return this ;
    }

    public FacultyBuilderModel build(){
        FacultyBuilderModel builderModel = new FacultyBuilderModel( id,  name,  title,  details,  type) ;
        return builderModel ;
    }
}
