package com.MalasataXD.Client;

import Server.databaseOperations.*;
import com.MalasataXD.Application.DAOInterfaces.IAnimalDao;
import com.MalasataXD.Application.DAOInterfaces.IPackageDao;
import com.MalasataXD.Application.DAOInterfaces.ITrayDao;
import com.MalasataXD.Domain.DTOs.AnimalCreationDTO;
import com.MalasataXD.Domain.DTOs.PackageCreationDTO;
import com.MalasataXD.Domain.DTOs.PartCreationDTO;
import com.MalasataXD.Domain.DTOs.TrayCreationDTO;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class gRPCClient implements IAnimalDao, IPackageDao, ITrayDao {

    private DatabaseOperationServiceGrpc.DatabaseOperationServiceBlockingStub serviceStub;
    public gRPCClient() {

        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost",1010).usePlaintext().build();

        serviceStub = DatabaseOperationServiceGrpc.newBlockingStub(managedChannel);

    }

    @Override
    public void CreateAnimal(AnimalCreationDTO dto) {

        RegistrateAnimalRequest request = RegistrateAnimalRequest.newBuilder()
                .setRegistrationNumber(dto.getRegistrationNumber())
                .setOrigin(dto.getOrigin())
                .setWeight(dto.getWeight())
                .setDate(dto.getDate())
                .build();


        APIResponse response = serviceStub.registrateAnimal(request);
    }

    @Override
    public void CreatePackage(PackageCreationDTO dto) {

        RegistratePackageRequest request = RegistratePackageRequest.newBuilder()
                .setDestination(dto.getDestination())
                .build();
        APIResponse response = serviceStub.registratePackage(request);
    }

    @Override
    public String getPartsFromTrayNumber(int trayNumber) {
        GetPartsFromTrayNumberRequest request = GetPartsFromTrayNumberRequest.newBuilder()
                .setTrayNumber(trayNumber)
                .build();

        APIResponse response = serviceStub.getPartsFromTrayNumber(request);
        return response.toString();
    }

    @Override
    public void addPartToTray(int partNumber, int trayNumber) {
        AddPartToTrayRequest request = AddPartToTrayRequest.newBuilder()
                .setPartNumber(partNumber)
                .setTrayNumber(trayNumber)
                .build();
        APIResponse response = serviceStub.addPartToTray(request);
    }

    @Override
    public void addPartToPackage(int partNumber, int packageNumber) {
        AddPartToPackageRequest request = AddPartToPackageRequest.newBuilder()
                .setPartNumber(partNumber)
                .setPackageNumber(packageNumber)
                .build();
        APIResponse response = serviceStub.addPartToPackage(request);
    }

    @Override
    public void addTray(TrayCreationDTO dto) {
        AddTrayRequest request = AddTrayRequest.newBuilder()
                .setWeight(dto.getWeight())
                .setTypeOfPart(dto.getTypeOfPart())
                .build();
        APIResponse response = serviceStub.addTray(request);
    }

    @Override
    public void CreatePart(PartCreationDTO dto) {

        RegistratePartRequest request = RegistratePartRequest.newBuilder()
                .setWeight(dto.getWeight())
                .setOriginAnimal(dto.getOriginAnimal())
                .setType(dto.getType())
                .build();

        APIResponse response = serviceStub.registratePart(request);
    }

    @Override
    public String GetPackageFromAnimalNum(int animalNum) {

        GetPackageFromAnimalNumberRequest request = GetPackageFromAnimalNumberRequest.newBuilder()
                .setAnimalNumber(animalNum)
                .build();

        APIResponse response = serviceStub.getPackageFromAnimalNumber(request);
        return response.toString();

    }

    @Override
    public String GetAnimalFromPackNumber(int packageNumber) {
        GetAnimalFromPackageNumberRequest request = GetAnimalFromPackageNumberRequest.newBuilder()
                .setPackNumber(packageNumber).
                build();

        APIResponse response = serviceStub.getAnimalFromPackageNumber(request);

        return response.toString();
    }
}
