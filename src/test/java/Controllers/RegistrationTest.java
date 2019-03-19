package Controllers;

import Models.Animal;
import Models.Cat;
import Models.Gender;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegistrationTest
{
    Registration reg = new Registration();

    @Test
    public void newCat()
    {
        String name = "Ozzy";
        Gender gender = Gender.Male;
        String badHabits = "";
        Cat newCat = new Cat(name, gender, badHabits);
        reg.NewCat(name, gender,badHabits);

        Animal catTest = reg.getAnimals().get(0);

        assertEquals(newCat.getName(), catTest.getName());
    }

    @Test
    public void newDog()
    {

    }

    @Test
    public void getAnimals() {
    }
}