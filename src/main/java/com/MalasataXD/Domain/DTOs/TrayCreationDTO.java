package com.MalasataXD.Domain.DTOs;

public class TrayCreationDTO {
    private String typeOfPart;
    private int weight;

    public TrayCreationDTO(String typeOfPart, int weight) {
        this.typeOfPart = typeOfPart;
        this.weight = weight;
    }

    public String getTypeOfPart() {
        return typeOfPart;
    }

    public int getWeight() {
        return weight;
    }
}
