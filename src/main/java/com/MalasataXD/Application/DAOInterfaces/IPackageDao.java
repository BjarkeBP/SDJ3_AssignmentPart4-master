package com.MalasataXD.Application.DAOInterfaces;

import com.MalasataXD.Domain.DTOs.PackageCreationDTO;

public interface IPackageDao {
    String GetAnimalFromPackNumber(int packageNumber);
    void CreatePackage(PackageCreationDTO dto);
    void addPartToPackage(int partNumber, int packageNumber);
}
