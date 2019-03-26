package Factory;

import Controllers.Registration;
import Models.Animal;
import Models.Cat;
import Models.Dog;
import Models.Gender;

import java.util.ArrayList;

public class AnimalFactory
{
    public Registration reg;

    public void createAnimals()
    {

        reg.NewCat("Zora", Gender.Female, "Zeurt");
        reg.NewCat("Gijs", Gender.Male, "Eet veel");
        reg.NewCat("Amber", Gender.Female, "");

        reg.NewDog("Denja", Gender.Female);
        reg.NewDog("Onyx", Gender.Male);
        reg.NewDog("Ravi", Gender.Female);
    }
}
