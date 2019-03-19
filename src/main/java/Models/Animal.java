package Models;

import Webshop.ISellable;

import java.util.Date;

public class Animal implements ISellable
{
    public int id;
    public String name;
    public Gender gender;
    public Reservor ReservedBy;
    public int price;

    public Animal(String name, Gender gender, int price)
    {
        this.name = name;
        this.gender = gender;
        this.price = price;
    }

    public boolean Reserve(String reservedBy)
    {
        if (this.ReservedBy == null)
        {
            Date today = new Date();
            this.ReservedBy = new Reservor(reservedBy, today);
            return true;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        gender = gender;
    }

    public Reservor getReservedBy() {
        return ReservedBy;
    }

    public void setReservedBy(Reservor reservedBy) {
        ReservedBy = reservedBy;
    }

    public int getPrice() {
        return price;
    }

    public String toString()
    {
        String reserved = "not reserved";
        if (this.ReservedBy != null)
        {
            reserved = "reserved by "+ this.ReservedBy.Name;
        }
        return this.name + ", " + this.gender;
    }

}
