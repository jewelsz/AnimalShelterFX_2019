package Database;

import Models.Animal;
import Models.Cat;
import Models.Dog;

import java.util.List;

public interface IDBRegistration
{
    void insertCat(Cat cat);
    void insertDog(Dog dog);

    List<Animal> getAll();
}

