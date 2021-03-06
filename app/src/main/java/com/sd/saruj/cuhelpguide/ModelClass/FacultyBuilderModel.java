package com.sd.saruj.cuhelpguide.ModelClass;

public class FacultyBuilderModel {

    private  int id;
    private  String name;
    private  String title;
    private  String details;
    private String type;
    private String url;

    public FacultyBuilderModel(int id, String name, String title, String details, String type, String url) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.details = details;
        this.type = type;
        this.url = url;
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

    public String getUrl() {
        return url;
    }
}
