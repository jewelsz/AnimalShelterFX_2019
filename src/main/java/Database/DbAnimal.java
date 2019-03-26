package Database;

import Models.Animal;
import Models.Cat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbAnimal
{
    DbConnection con = new DbConnection();

    public void insertCat(Cat cat) {

        String sql = "INSERT INTO animals(name,animalType, price) VALUES(?,?,?)";

        try (Connection conn = this.con.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cat.getName());
            pstmt.setString(2, "Cat");
            pstmt.setInt(3, cat.getPrice());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Animal> getAnimals(){
        String sql = "SELECT animalID, name, price FROM animals";
        ArrayList<Animal> animals = new ArrayList<>();

        try (Connection conn = this.con.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("name") +  "\t" +
                        rs.getString("animalType") + "\t" +
                        rs.getInt("price"));
                Animal animal = new Cat(rs.getInt("animalID"), rs.getString("name"), rs.getInt("price"));
                animals.add(animal);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return animals;
    }
}
