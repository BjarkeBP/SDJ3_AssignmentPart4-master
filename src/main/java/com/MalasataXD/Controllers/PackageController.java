package com.MalasataXD.Controllers;


import com.MalasataXD.Application.LogicInterfaces.IPackageLogic;
import com.MalasataXD.Domain.DTOs.PackageCreationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class PackageController {

    private final IPackageLogic PackageLogic;

    public PackageController(IPackageLogic packageLogic) {
        PackageLogic = packageLogic;
    }

    @PostMapping(path = "/package")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody PackageCreationDTO dto)
    {
        PackageLogic.CreatePackage(dto);
    }
    @GetMapping(value = "/package")
    public String read(@RequestParam(required = false) int packageNumber){
        return PackageLogic.getAnimalFromPackNumber(packageNumber);
    }

    @GetMapping(value = "/packageAddPart")
    public void read(@RequestParam(required = false) int parkNumber, int packageNumber){
        PackageLogic.addPartToPackage(parkNumber, packageNumber);
    }


}
