package Models;

import java.util.Date;

public class Reservor
{
    public String Name;
    public Date ReservedAt;

    public Reservor(String name, Date reservedAt)
    {
        this.Name = name;
        this.ReservedAt = reservedAt;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getReservedAt() {
        return ReservedAt;
    }

    public void setReservedAt(Date reservedAt) {
        ReservedAt = reservedAt;
    }
}
