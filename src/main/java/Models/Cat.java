package Models;

public class Cat extends Animal
{
    public String BadHabits;
    private int maxPrice = 350;

    public Cat(String name, Gender gender, String badHabits)
    {
        super(name, gender, 350);
        this.BadHabits = badHabits;

        int discount = badHabits.length() * 20;
        int price = maxPrice - discount;
        if( price < 35)
        {
            this.price = 35;
        }
        else
        {
            this.price = price;
        }
    }

    public Cat(int id, String name, int price) {
        super(id, name, price);
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
