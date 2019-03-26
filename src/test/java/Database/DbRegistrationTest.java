package Database;

import Models.Animal;
import Models.Cat;
import Models.Gender;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DbRegistrationTest
{
    private DbConnection dbConnection = new DbConnection();

    @Test
    void insertCat()
    {
        Cat cat = new Cat ("Ozzy", Gender.Male, "");
        dbConnection.insertCat(cat);

    }
}