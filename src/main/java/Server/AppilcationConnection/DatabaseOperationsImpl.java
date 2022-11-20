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
            String data = sql.getAnimalFromPackageNumber(request.getPackNumber()).toString();

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
            String data = sql.getPackageFromAnimalNumber(request.getAnimalNumber()).toString();

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
    public void getPartsFromTrayNumber(GetPartsFromTrayNumberRequest request, StreamObserver<APIResponse> responseObserver) {
        try {
            //Method to forward grpc request information to the SQL class
            String data = sql.getPartsFromTrayNumber(request.getTrayNumber()).toString();

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
            sql.registrateAnimal(request.getRegistrationNumber(), request.getWeight(), request.getOrigin(), request.getDate());

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
            sql.registratePackage(request.getDestination());

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
    public void registratePart(RegistratePartRequest request, StreamObserver<APIResponse> responseObserver) {
        try {
            //Method to forward grpc request information to the SQL class
            sql.registratePart(request.getOriginAnimal(), request.getType(), request.getWeight());

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
    public void addPartToPackage(AddPartToPackageRequest request, StreamObserver<APIResponse> responseObserver) {
        try {
            //Method to forward grpc request information to the SQL class
            sql.addPartToPackage(request.getPartNumber(), request.getPackageNumber());

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
    public void addPartToTray(AddPartToTrayRequest request, StreamObserver<APIResponse> responseObserver) {
        try {
            //Method to forward grpc request information to the SQL class
            sql.addPartToTray(request.getPartNumber(), request.getTrayNumber());

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
    public void addTray(AddTrayRequest request, StreamObserver<APIResponse> responseObserver) {
        try {
            //Method to forward grpc request information to the SQL class
            sql.addTray(request.getTypeOfPart(), request.getWeight());

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

