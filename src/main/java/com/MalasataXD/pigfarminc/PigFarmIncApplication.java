package com.MalasataXD.pigfarminc;

import com.MalasataXD.Application.LogicImpl.AnimalLogicImpl;
import com.MalasataXD.Application.LogicImpl.PackageLogicImpl;
import com.MalasataXD.Application.LogicInterfaces.IAnimalLogic;
import com.MalasataXD.Application.LogicInterfaces.IPackageLogic;
import com.MalasataXD.Configuration.AnimalConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.MalasataXD")
public class PigFarmIncApplication {

    public static void main(String[] args)
    {
        // ¤ Loads AnimalConfig
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AnimalConfig.class);
        // ¤ Gets the BEANS!
        IAnimalLogic animalLogic = ctx.getBean(AnimalLogicImpl.class);

        IPackageLogic packageLogic = ctx.getBean(PackageLogicImpl.class);

        // # Starts the WebAPI
        SpringApplication.run(PigFarmIncApplication.class, args);
    }
}
