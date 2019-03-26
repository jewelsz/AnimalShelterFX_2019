package sample;

import Controllers.Registration;
import Models.Animal;
import Models.Dog;
import Models.Gender;
import Webshop.Product;
import Webshop.Webshop;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;

import java.beans.PropertyChangeEvent;

public class Controller
{
    private static Registration res = new Registration();
    public TextField nameTxt, nameProductTxt, priceProductTxt;
    public TextArea habitsTxt;
    public Label warmingMessageTxt;
    public ListView<Animal> animalList;
    public ListView<Product> productList;

    public static final ObservableList products =
            FXCollections.observableArrayList();

    private boolean isCat = true;
    private Gender gender = Gender.Female;

    Webshop webshop = new Webshop();

    public Controller()
    {
        res.addPropertyChangeListener("addDogEvent", Controller::addDogEvent);
    }


    private static void addDogEvent(PropertyChangeEvent evt) {
        Dog animal = (Dog) evt.getNewValue();
        System.out.println("Het addDogEvent is afgevuurd!");
        System.out.println(animal.name);
    }

    public void changeToCat()
    {
        isCat = true;
        habitsTxt.setDisable(false);
    }

    public void changeToDog()
    {
        isCat = false;
        habitsTxt.setDisable(true);
    }

    public  void changeToMale()
    {
        gender = Gender.Male;
    }

    public void changeToFemale()
    {
        gender = Gender.Female;
    }

    public void addAnimal()
    {
        if(isCat)
        {

            if(nameTxt.getText() != null && habitsTxt.getText() != null)
            {
                warmingMessageTxt.setVisible(false);
                res.NewCat(nameTxt.getText(), gender, habitsTxt.getText());
                System.out.print("Cat added");
            }
            else
            {
                warmingMessageTxt.setVisible(true);
            }
        }
        if(!isCat)
        {
            if(nameTxt.getText() != null)
            {
                warmingMessageTxt.setVisible(false);
                res.NewDog(nameTxt.getText(), gender);
            }
        }

        refreshAnimals();

    }

    public void addProduct()
    {
        webshop.newProduct(nameProductTxt.getText(), Integer.parseInt(priceProductTxt.getText()));
        refreshProducts();
    }

    private void refreshAnimals()
    {
        ObservableList<Animal> animals =FXCollections.observableArrayList(res.getAnimals());
        animalList.setItems(animals);
    }

    private void refreshProducts()
    {
        ObservableList<Product> products =FXCollections.observableArrayList(webshop.getProducts());
        //webshop.getProducts();
        productList.setItems(products);
    }

    public void initialize() {
        habitsTxt.setText(null);
        nameTxt.setText(null);
    }
}
