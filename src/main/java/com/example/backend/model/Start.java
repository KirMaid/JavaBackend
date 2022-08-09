package com.example.backend.model;
public class Start{
    private final long id;
    private final String content;

    public Start(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId(){
        return id;
    }
    public String getContent(){
        return content;
    }
}
