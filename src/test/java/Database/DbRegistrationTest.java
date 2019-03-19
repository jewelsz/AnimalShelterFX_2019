package Database;

import Models.Animal;
import Models.Cat;
import Models.Gender;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DbRegistrationTest
{
    DbRegistration dbRegistration = new DbRegistration();

    private DbConnection dbConnection = new DbConnection("animalshelterdb");

    @Test
    void insertCat()
    {
        Cat cat = new Cat ("Ozzy", Gender.Male, "");
        //dbConnection.insertCat(cat);

    }
}