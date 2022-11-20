package Server.DBConnection;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public interface DBConnectionInterface {
    public ArrayList<String> getPackageFromAnimalNumber(int AnimalNumber) throws SQLException;
    public ArrayList<String> getAnimalFromPackageNumber(int PackNumber) throws SQLException;
    public ArrayList<String> getPartsFromTrayNumber(int trayNumber) throws SQLException;
    public void registrateAnimal(int registrationNumber, int weight, String origin, String date) throws SQLException;
    public void registratePackage(String destination) throws SQLException;
    public void registratePart(int originAnimal, String type, int weight) throws SQLException;
    public void addPartToPackage(int partNumber, int packageNumber) throws SQLException;
    public void addPartToTray(int partNumber, int trayNumber) throws SQLException;
    public void addTray(String typeOfPart, int weight) throws SQLException;

}
