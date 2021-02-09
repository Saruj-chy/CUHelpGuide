package com.sd.saruj.cuhelpguide.ModelClass;

public class FacultyBuilderClass {

    private  int id;
    private  String name;
    private  String title;
    private  String details;
    private String type;
    private String url;
    private String phone;
    private String department_name;


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

    public FacultyBuilderClass setUrl(String url) {
        this.url = url;
        return this ;
    }

    public FacultyBuilderClass setPhone(String phone) {
        this.phone = phone;
        return this ;
    }

    public FacultyBuilderClass setDepartment_name(String department_name) {
        this.department_name = department_name;
        return this ;
    }

    public FacultyBuilderModel build(){
        FacultyBuilderModel builderModel = new FacultyBuilderModel( id,  name,  title,  details,  type, url, phone, department_name) ;
        return builderModel ;
    }
}
