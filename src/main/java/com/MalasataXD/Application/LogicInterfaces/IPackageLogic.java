package com.MalasataXD.Application.LogicInterfaces;

import com.MalasataXD.Domain.DTOs.PackageCreationDTO;

public interface IPackageLogic {

    String getAnimalFromPackNumber(int packageNumber);
    void CreatePackage(PackageCreationDTO dto);
    void addPartToPackage(int partNumber, int packageNumber);
}
