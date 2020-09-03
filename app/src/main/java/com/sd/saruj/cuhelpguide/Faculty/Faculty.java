package com.sd.saruj.cuhelpguide.Faculty;

public class Faculty {
    private  int id;
    private  String name;
    private  String title;
    private  String details;
    private String type;


    public Faculty(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //==========engineering
    public Faculty(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    //===========     NoticeActivity
    public Faculty(String title, String name) {
        this.title = title;
        this.name = name;

    }

    //============ RetrivePostListActivity
    public Faculty(int id, String title, String details, String name) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public String getType() {
        return type;
    }
}
