package com.example.ticketingsystem;

public class Person {


    private String cno;
    private String id;
    private String name;


    public Person() {
    }

    public Person(String name, String id, String cno) {
        this.id = id;
        this.name = name;
        this.cno = cno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id= id;
    }
}
