package sample;

import Controllers.Registration;
import Models.Animal;
import Models.Dog;
import Models.Gender;
import javafx.scene.control.*;

import java.beans.PropertyChangeEvent;

public class Controller
{
    public TextField nameTxt, nameProductTxt, priceProductTxt;
    public TextArea habitsTxt;
    public Label warmingMessageTxt;
    public ListView animalList;
    Registration res = new Registration();

    public Controller() {
        res.addPropertyChangeListener("addDogEvent", Controller::addDogEvent);
    }


    private boolean isCat = true;
    private Gender gender = Gender.Female;

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


    }

    public void addProduct()
    {

    }


    public void initialize() {
        habitsTxt.setText(null);
        nameTxt.setText(null);
    }
}
