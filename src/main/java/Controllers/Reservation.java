package Controllers;

import Models.Animal;
import Models.Cat;
import Models.Dog;
import Models.Gender;

import java.util.ArrayList;

public class Reservation
{
    private ArrayList<Animal> animals = new ArrayList<>();

    public void NewCat(String name, Gender gender, String badHabits)
    {
        Animal newcat = new Cat(name, gender, badHabits);
        this.animals.add(newcat);
    }

    public void NewDog(String name, Gender gender)
    {
        Animal newdog = new Dog(name, gender);
        this.animals.add(new Dog(name, gender));
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }
}
