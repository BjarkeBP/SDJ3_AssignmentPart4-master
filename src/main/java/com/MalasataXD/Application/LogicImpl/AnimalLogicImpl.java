package com.MalasataXD.Application.LogicImpl;

import com.MalasataXD.Application.DAOInterfaces.IAnimalDao;
import com.MalasataXD.Application.LogicInterfaces.IAnimalLogic;
import com.MalasataXD.Domain.DTOs.AnimalCreationDTO;
import com.MalasataXD.Domain.DTOs.PackageCreationDTO;
import com.MalasataXD.Domain.DTOs.PartCreationDTO;
import com.MalasataXD.Domain.Models.Animal;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;


public class AnimalLogicImpl implements IAnimalLogic
{
    // # Fields
    private IAnimalDao animalDao;

    // ¤ Constructor
    public AnimalLogicImpl(@Autowired IAnimalDao dao)
    {
        this.animalDao = dao;
    }


    // # Create an Animal and adds it to the "database"
    @Override public void CreateAnimal(AnimalCreationDTO dto)
    {
        animalDao.CreateAnimal(dto);
    }



    @Override
    public void CreatePart(PartCreationDTO dto) {
        animalDao.CreatePart(dto);
    }

    @Override
    public String GetPackageFromAnimalNum(int AnimalNum) {
        return animalDao.GetPackageFromAnimalNum(AnimalNum);
    }
}
