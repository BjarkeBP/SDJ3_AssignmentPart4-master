package com.MalasataXD.Application.DAOInterfaces;

import com.MalasataXD.Domain.DTOs.PackageCreationDTO;

public interface IPackageDao {
    String getAnimalFromPackNumber(int packageNumber);
    void CreatePackage(PackageCreationDTO dto);
}
