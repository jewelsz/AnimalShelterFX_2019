package Models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dog extends Animal
{
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Date LastWalk;

    public boolean NeedsWalk;


    public Dog(String name, Gender gender)
    {
        super(name, gender, 500);
        LastWalk = new Date();
    }

    public Date getLastWalk()
    {
        return LastWalk;
    }

    public boolean getNeedsWalk()
    {
        Date today = new Date();
        if(today.after(LastWalk))
        {
            return true;
        }
        return false;
    }

    public String ToString()
    {
        return super.toString() +
                ", last walk: "+ dateFormat.format(LastWalk);
    }

}
