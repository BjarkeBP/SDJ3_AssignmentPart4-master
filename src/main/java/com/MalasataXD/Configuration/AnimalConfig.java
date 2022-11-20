package com.MalasataXD.Configuration;

import com.MalasataXD.Application.DAOInterfaces.IAnimalDao;
import com.MalasataXD.Application.DAOInterfaces.IPackageDao;
import com.MalasataXD.Application.DAOInterfaces.ITrayDao;
import com.MalasataXD.Application.LogicImpl.AnimalLogicImpl;
import com.MalasataXD.Application.LogicImpl.PackageLogicImpl;
import com.MalasataXD.Application.LogicImpl.TrayLogicImpl;
import com.MalasataXD.Application.LogicInterfaces.IPackageLogic;
import com.MalasataXD.Client.gRPCClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnimalConfig
{
    // # Makes AnimalLogic a Bean
    @Bean(name="AnimalService")
    public AnimalLogicImpl getAnimalService()
    {
        return new AnimalLogicImpl(getAnimalDAO());
    }

    // # Makes AnimalDAO a Bean
    @Bean(name="AnimalDAO")
    public IAnimalDao getAnimalDAO()
    {
        return new gRPCClient();
    }


    // # Makes PackageLogic a Bean
    @Bean(name="PackageService")
    public PackageLogicImpl getPackageService()
    {
        return new PackageLogicImpl((IPackageDao) getPackageDAO());
    }

    // # Makes PackageDAO a Bean
    @Bean(name="PackageDAO")
    public IAnimalDao getPackageDAO()
    {
        return new gRPCClient();
    }


    // # Makes TrayLogic a Bean
    @Bean(name="TrayService")
    public TrayLogicImpl getTrayService()
    {
        return new TrayLogicImpl((ITrayDao) getTrayDAO());
    }

    // # Makes PackageDAO a Bean
    @Bean(name="TrayDAO")
    public IAnimalDao getTrayDAO()
    {
        return new gRPCClient();
    }

}
