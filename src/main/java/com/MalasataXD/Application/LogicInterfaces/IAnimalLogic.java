package com.MalasataXD.Application.LogicInterfaces;

import com.MalasataXD.Domain.DTOs.AnimalCreationDTO;
import com.MalasataXD.Domain.DTOs.PackageCreationDTO;
import com.MalasataXD.Domain.DTOs.PartCreationDTO;
import com.MalasataXD.Domain.Models.Animal;

import java.util.ArrayList;

public interface IAnimalLogic
{
    // # Methods
     void CreateAnimal(AnimalCreationDTO dto);
     void CreatePart(PartCreationDTO dto);
     String GetPackageFromAnimalNum(int AnimalNum);
}
