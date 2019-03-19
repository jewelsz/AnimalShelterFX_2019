package Factory;

import Models.Animal;
import Models.Cat;
import Models.Dog;
import Models.Gender;

import java.util.ArrayList;

public class AnimalFactory
{
    public ArrayList<Animal> animals;

    public void createAnimals()
    {
        animals = new ArrayList<>();

        animals.add(new Cat("Zora", Gender.Female, "Zeurt"));
        animals.add(new Cat("Gijs", Gender.Male, "Eet veel"));
        animals.add(new Cat("Amber", Gender.Female, ""));

        animals.add(new Dog("Denja", Gender.Female));
        animals.add(new Dog("Onyx", Gender.Male));
        animals.add(new Dog("Ravi", Gender.Female));
    }
}
