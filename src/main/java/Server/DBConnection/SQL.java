package Server.DBConnection;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;
import java.util.ArrayList;

public class SQL implements DBConnectionInterface{

    // ? Attributes
    private Connection connection;

    // * Constructor

    public SQL(String url, String user, String password, String schema) throws SQLException, ClassNotFoundException {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(url, user, password);
            this.connection.setSchema(schema);
            System.out.println("Opened database successfully");

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }


    public ArrayList<String> getPackFromAnimalNumber(String AnimalNumber) throws SQLException{
       ArrayList<String> arrayList = new ArrayList<>();
       arrayList.add("PackageNum");

     return selectFromSQL("select pa.PackageNum\n" +
             "from Package pa\n" +
             "left join Part P on pa.PackageNum = P.PackageNum\n" +
             "left join Animal A2 on p.OriginAnimal = A2.RegistrationNum\n" +
             "where A2.RegistrationNum = " + "'" + AnimalNumber + "'" + ";" , arrayList);
    }

    public ArrayList<String> getAnimalFromPackNumber(String PackNumber) throws SQLException{
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("RegistrationNum");

        return selectFromSQL("select RegistrationNum\n" +
                "from animal a\n" +
                "left join Part P on a.RegistrationNum = P.OriginAnimal\n" +
                "left join Package P2 on P.PackageNum = P2.PackageNum\n" +
                "where P2.PackageNum = " + "'" + PackNumber + "'" + ";" , arrayList);
    }

    public void RegistrateAnimal(String registrationNumber, String weight, String origin) throws SQLException{
        insertInto("insert into animal values (" + "'" + registrationNumber + "'" + ", " + "'" + weight + "'" + ", " + "'" + origin + "'" + ");");
    }

    public void RegistratePakke(String destination) throws SQLException{
        insertInto("insert into package (Destination) values (" + "'" + destination + "'" + ");");
    }

    public void RegistratePart(String originAnimal, String type, String weight, String packageNum) throws SQLException{
        insertInto("insert into Part (OriginAnimal, Type, Weight, PackageNum) values (" + "'" + originAnimal + "'" + ", " + "'" + type + "'" + ", " + "'" + weight + "'" +", " + "'" +packageNum + "'" + ");");
    }

    // # Gets information from the database, by performing a statement
    private ArrayList<String> selectFromSQL(String statementSQL, ArrayList<String> columnNames){
        ArrayList<String> colData = new ArrayList<>();

        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(statementSQL);

            while (rs.next()) {
                for (int i = 0; i < columnNames.size(); i++) {
                    colData.add(rs.getString(columnNames.get(i)));
                }
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Database query ok ");
        return colData;
    }

    // # Inserts information into the database, by performing a statement
    private void insertInto(String statementSQL){
        Statement stmt = null;

        try {

            System.out.println("Database open ok");

            stmt = connection.createStatement();
            stmt.executeUpdate(statementSQL);

            stmt.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Database update ok");
    }
}
