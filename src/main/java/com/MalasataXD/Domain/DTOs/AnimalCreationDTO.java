package com.MalasataXD.Domain.DTOs;

public class AnimalCreationDTO
{
    // # Fields
    private String registrationNumber;
    private int weight;
    private String origin;

    // ¤ Constructor
    public AnimalCreationDTO(int weight, String origin, String RegistrationNumber)
    {
        this.weight = weight;
        this.origin = origin;
        this.registrationNumber = RegistrationNumber;
    }

    // # Getters
    public int getWeight() {return weight;}
    public String getOrigin() {return origin;}

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}
