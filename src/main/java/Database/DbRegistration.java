package Database;

import Models.Animal;
import Models.Cat;
import Models.Dog;

import java.sql.PreparedStatement;
import java.util.List;

public class DbRegistration implements IDBRegistration
{

    private DbConnection dbConnection = new DbConnection("animalshelterdb");
    private static final String insertSQL = "INSERT INTO animals(name, animalType, price) values(?, ?, ?) ";


    @Override
    public void insertCat(Cat cat)
    {
        try {

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = dbConnection.getStatement(insertSQL);
            preparedStmt.setString (1, (cat.getName()));
            preparedStmt.setString (2, "Cat");
            preparedStmt.setInt (3, cat.price);

            // execute the preparedstatement
            preparedStmt.execute();

            dbConnection.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }


    }

    @Override
    public void insertDog(Dog dog)
    {

    }

    @Override
    public List<Animal> getAll() {
        return null;
    }
}
