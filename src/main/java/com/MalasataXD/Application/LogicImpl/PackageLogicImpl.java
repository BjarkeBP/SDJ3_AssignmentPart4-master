package com.MalasataXD.Application.LogicImpl;

import com.MalasataXD.Application.DAOInterfaces.IPackageDao;
import com.MalasataXD.Application.LogicInterfaces.IPackageLogic;
import com.MalasataXD.Domain.DTOs.PackageCreationDTO;
import org.springframework.beans.factory.annotation.Autowired;

public class PackageLogicImpl implements IPackageLogic {

    private IPackageDao PackageDao;

    public PackageLogicImpl(@Autowired IPackageDao packageDao) {

        PackageDao = packageDao;
    }

    @Override
    public void CreatePackage(PackageCreationDTO dto) {
        PackageDao.CreatePackage(dto);
    }

    @Override
    public void addPartToPackage(int partNumber, int packageNumber) {
        PackageDao.addPartToPackage(partNumber, packageNumber);
    }

    @Override
    public String getAnimalFromPackNumber(int packageNumber) {
        return PackageDao.GetAnimalFromPackNumber(packageNumber);
    }
}
