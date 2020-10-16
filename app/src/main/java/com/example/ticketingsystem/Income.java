package com.example.ticketingsystem;

public class Income {

    private String income;
    private String fuel;
    private String machin;
    private String other;

    public Income() {
    }

    public Income(String income, String fuel, String machin, String other) {
        this.income = income;
        this.fuel = fuel;
        this.machin = machin;
        this.other = other;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getMachin() {
        return machin;
    }

    public void setMachin(String machin) {
        this.machin = machin;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }
}
