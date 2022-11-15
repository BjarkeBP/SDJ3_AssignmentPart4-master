package com.MalasataXD.Controllers;

import com.MalasataXD.Application.LogicInterfaces.IAnimalLogic;
import com.MalasataXD.Domain.DTOs.AnimalCreationDTO;
import com.MalasataXD.Domain.DTOs.PackageCreationDTO;
import com.MalasataXD.Domain.DTOs.PartCreationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AnimalController
{
    private final IAnimalLogic animalLogic;

    // ¤ Constructor
    public AnimalController(@Autowired IAnimalLogic animalLogic)
    {
        this.animalLogic = animalLogic;
    }

    // ¤ Create Animal
    @PostMapping(path = "/animal")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody AnimalCreationDTO dto)
    {
        animalLogic.CreateAnimal(dto);
    }



    @PostMapping(path = "/animal/part")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody PartCreationDTO dto)
    {
        animalLogic.CreatePart(dto);
    }

    @GetMapping(value = "/animal")
    public String read(@RequestParam(required = false) int animalNumber){
        return animalLogic.GetPackageFromAnimalNum(animalNumber);
    }

}
