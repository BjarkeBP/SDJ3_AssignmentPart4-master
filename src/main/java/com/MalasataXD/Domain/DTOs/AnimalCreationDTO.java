package com.MalasataXD.Domain.DTOs;

public class AnimalCreationDTO
{
    // # Fields
    private int registrationNumber;
    private int weight;
    private String origin;
    private String date;


    // ¤ Constructor
    public AnimalCreationDTO(int weight, String origin, int RegistrationNumber, String date)
    {
        this.weight = weight;
        this.origin = origin;
        this.registrationNumber = RegistrationNumber;
        this.date = date;
    }

    // # Getters
    public int getWeight() {return weight;}
    public String getOrigin() {return origin;}

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public String getDate() {
        return date;
    }
}
