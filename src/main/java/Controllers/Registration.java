package Controllers;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import Database.DbAnimal;
import Models.*;

import java.util.ArrayList;

public class Registration
{
    DbAnimal dbReg = new DbAnimal();
    private ArrayList<Animal> animals = new ArrayList<>();
    private ArrayList<Dog> dogs = new ArrayList<>();

    private final PropertyChangeSupport support;

    public Registration()
    {
        support = new PropertyChangeSupport(this);
    }


    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener)
    {
        support.addPropertyChangeListener(propertyName, listener);
    }

    public void NewCat(String name, Gender gender, String badHabits)
    {
        Animal newcat = new Cat(name, gender, badHabits);
        this.animals.add(newcat);
        dbReg.insertCat((Cat)newcat);
        support.firePropertyChange("addCatEvent", null, newcat);

    }

    public void NewDog(String name, Gender gender)
    {
        Animal newdog = new Dog(name, gender, dogs.size());
        this.animals.add(newdog);
        this.dogs.add((Dog)newdog);
        support.firePropertyChange("addDogEvent", null, newdog);
    }

    private void removeDog(int id)
    {
        Animal supposelpydog= this.animals.get(id);
        this.animals.remove(supposelpydog);
        support.firePropertyChange("removeDogEvent", null, supposelpydog);
    }
    public ArrayList<Animal> getAnimals() {
        return animals;
    }


    public void removePropertyChangeListener(PropertyChangeListener listener)
    {
        support.removePropertyChangeListener(listener);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener)
    {
        support.addPropertyChangeListener(listener);
    }
}
