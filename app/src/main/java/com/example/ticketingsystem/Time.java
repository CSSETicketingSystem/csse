package com.example.ticketingsystem;

public class Time {

    private String rootno;
    private String from;
    private String to;
    private String time;

    public Time() {
    }

    public Time(String rootno, String from, String to, String time) {
        this.rootno = rootno;
        this.from = from;
        this.to = to;
        this.time = time;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRootno() {
        return rootno;
    }

    public void setRootno(String rootno) {
        this.rootno = rootno;
    }
}
