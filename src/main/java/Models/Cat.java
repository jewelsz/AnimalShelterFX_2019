package Models;

public class Cat extends Animal
{
    public String BadHabits;

    public Cat(String name, Gender gender, String badHabits)
    {
        super(name, gender, 350);
        this.BadHabits = badHabits;
    }

    public String getBadHabits() {
        return BadHabits;
    }

    public void setBadHabits(String badHabits) {
        BadHabits = badHabits;
    }

    public String toString()
    {
        return "Name: "+ super.name+", bad habits: "+ this.BadHabits + ",  " + super.getGender();
    }

}
