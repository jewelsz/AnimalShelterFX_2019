package Database;

import Models.Animal;
import Models.Cat;
import java.util.List;

public interface IConnection
{
    List<Animal> getAnimals();
    void insertCat(Cat cat);
}
