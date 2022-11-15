package com.MalasataXD.Domain.Models;

public class Animal
{
    // # Fields
    private String date;
    private double weight;
    private int registrationNumber;
    private String origin;

    // ¤ Constructor
    public Animal(double weight, String origin)
    {
        this.weight = weight;
        this.origin = origin;
    }

    // ! Used for loading data.
    public Animal(double weight, String origin,int registrationNumber, String date)
    {
        this.weight = weight;
        this.origin = origin;
        this.registrationNumber = registrationNumber;
        this.date = date;
    }

    // # Setters
    public void setWeight(double weight) {this.weight = weight;}
    public void setOrigin(String origin) {this.origin = origin;}
    public void setRegistrationNumber(int registrationNumber)
    {
        this.registrationNumber = registrationNumber;
    }
    public void setDate(String date)
    {
        this.date = date;
    }

    // # Getters
    public double getWeight() {return weight;}
    public String getOrigin() {return origin;}
    public int getRegistrationNumber() {return registrationNumber;}
    public String getDate() {return date;}

    // ¤ ToString
    @Override public String toString() {
        return  weight + ";" + origin + ";" + registrationNumber + ";" + date;
    }
}
