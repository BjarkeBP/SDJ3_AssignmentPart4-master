package com.MalasataXD.Client;

import Server.databaseOperations.*;
import com.MalasataXD.Application.DAOInterfaces.IAnimalDao;
import com.MalasataXD.Application.DAOInterfaces.IPackageDao;
import com.MalasataXD.Domain.DTOs.AnimalCreationDTO;
import com.MalasataXD.Domain.DTOs.PackageCreationDTO;
import com.MalasataXD.Domain.DTOs.PartCreationDTO;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class gRPCClient implements IAnimalDao, IPackageDao {

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
    public void CreatePart(PartCreationDTO dto) {
        registratePartRequest request = registratePartRequest.newBuilder()
                .setWeight(dto.getWeight())
                .setOriginAnimal(dto.getOriginAnimal())
                .setPackageNum(dto.getPackageNum())
                .setType(dto.getType())
                .build();

        APIResponse response = serviceStub.registratePart(request);
    }

    @Override
    public String GetPackageFromAnimalNum(int AnimalNum) {
        GetPackageFromAnimalNumberRequest request = GetPackageFromAnimalNumberRequest.newBuilder()
                .setAnimalNumber(String.valueOf(AnimalNum))
                .build();

        APIResponse response = serviceStub.getPackageFromAnimalNumber(request);
        return response.toString();
    }

    @Override
    public String getAnimalFromPackNumber(int packageNumber) {
        GetAnimalFromPackageNumberRequest request = GetAnimalFromPackageNumberRequest.newBuilder()
                .setPackNumber(String.valueOf(packageNumber)).
                build();

        APIResponse response = serviceStub.getAnimalFromPackageNumber(request);

        return response.toString();
    }
}
