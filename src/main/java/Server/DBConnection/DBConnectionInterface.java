package Server.DBConnection;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public interface DBConnectionInterface {
    public ArrayList<String> getPackFromAnimalNumber(String AnimalNumber) throws SQLException;
    public ArrayList<String> getAnimalFromPackNumber(String PackNumber) throws SQLException;
    public void RegistrateAnimal(String registrationNumber, String weight, String origin) throws SQLException;
    public void RegistratePakke(String destination) throws SQLException;
    public void RegistratePart(String originAnimal, String type, String weight, String packageNum) throws SQLException;
}
