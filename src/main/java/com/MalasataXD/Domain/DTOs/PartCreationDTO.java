package com.MalasataXD.Domain.DTOs;

public class PartCreationDTO {

    private int OriginAnimal;
    private String Type;
    private int Weight;



    public PartCreationDTO(int originAnimal, String type, int weight) {
        OriginAnimal = originAnimal;
        Type = type;
        Weight = weight;
    }

    public int getOriginAnimal() {
        return OriginAnimal;
    }

    public String getType() {
        return Type;
    }

    public int getWeight() {
        return Weight;
    }

}
