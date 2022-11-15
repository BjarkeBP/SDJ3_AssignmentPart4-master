package com.MalasataXD.Domain.DTOs;

public class PartCreationDTO {

    private int OriginAnimal;
    private String Type;
    private int Weight;
    private int packageNum;


    public PartCreationDTO(int originAnimal, String type, int weight, int packageNum) {
        OriginAnimal = originAnimal;
        Type = type;
        Weight = weight;
        this.packageNum = packageNum;
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

    public int getPackageNum() {
        return packageNum;
    }
}
