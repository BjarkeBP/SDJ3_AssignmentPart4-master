package Server.AppilcationConnection;

import Server.DBConnection.SQL;
import Server.databaseOperations.*;
import io.grpc.stub.StreamObserver;

import java.sql.SQLException;

public class DatabaseOperationsImpl extends DatabaseOperationServiceGrpc.DatabaseOperationServiceImplBase
{
    //Attributes
    private SQL sql;

    //constructor
    public DatabaseOperationsImpl(SQL sql) {
        this.sql = sql;
    }

    //Overridden grpc method
    @Override
    public void getAnimalFromPackageNumber(GetAnimalFromPackageNumberRequest request, StreamObserver<APIResponse> responseObserver) {

        try {
            //Method to forward grpc request information to the SQL class
            String data = sql.getAnimalFromPackNumber(request.getPackNumber()).toString();

            System.out.println(data);

            //API response that returns a success code and message if the rpc protocol is successful
            APIResponse response = APIResponse.newBuilder()
                    .setResponseMessage("successfully")
                    .setResponseCode("200")
                    .setData(data)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();

        }
        catch (SQLException e) {
            throw new RuntimeException("Error code 500: " + e.getMessage());
        }
    }

    //Overridden grpc method registrateAnimal
    @Override
    public void getPackageFromAnimalNumber(GetPackageFromAnimalNumberRequest request, StreamObserver<APIResponse> responseObserver) {
        try {
            //Method to forward grpc request information to the SQL class
            String data = sql.getPackFromAnimalNumber(request.getAnimalNumber()).toString();

            System.out.println(data);

            //API response that returns a success code and message if the rpc protocol is successful
            APIResponse response = APIResponse.newBuilder()
                    .setResponseMessage("successfully")
                    .setResponseCode("200")
                    .setData(data)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();

        }
        catch (SQLException e) {
            throw new RuntimeException("Error code 500: " + e.getMessage());
        }

    }

    @Override
    public void registrateAnimal(RegistrateAnimalRequest request, StreamObserver<APIResponse> responseObserver) {
        try {
            //Method to forward grpc request information to the SQL class
            sql.RegistrateAnimal(request.getRegistrationNumber() + "", String.valueOf(request.getWeight()), request.getOrigin());

            //API response that returns a success code and message if the rpc protocol is successful
            APIResponse response = APIResponse.newBuilder()
                    .setResponseMessage("successfully")
                    .setResponseCode("200")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();

        }
        catch (SQLException e) {
            throw new RuntimeException("Error code 500: " + e.getMessage());
        }

    }
    @Override
    public void registratePackage(RegistratePackageRequest request, StreamObserver<APIResponse> responseObserver) {
        try {
            //Method to forward grpc request information to the SQL class
            sql.RegistratePakke(request.getDestination());

            //API response that returns a success code and message if the rpc protocol is successful
            APIResponse response = APIResponse.newBuilder()
                    .setResponseMessage("successfully")
                    .setResponseCode("200")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();

        }
        catch (SQLException e) {
            throw new RuntimeException("Error code 500: " + e.getMessage());
        }

    }

    public void registratePart(registratePartRequest request, StreamObserver<APIResponse> responseObserver) {
        try {
            //Method to forward grpc request information to the SQL class
            sql.RegistratePart(String.valueOf(request.getOriginAnimal()), request.getType(), String.valueOf(request.getWeight()), String.valueOf(request.getPackageNum()));

            //API response that returns a success code and message if the rpc protocol is successful
            APIResponse response = APIResponse.newBuilder()
                    .setResponseMessage("successfully")
                    .setResponseCode("200")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();

        }
        catch (SQLException e) {
            throw new RuntimeException("Error code 500: " + e.getMessage());
        }

    }
}

