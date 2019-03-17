package sample;

import Controllers.Reservation;
import Models.Gender;
import Webshop.Product;
import javafx.scene.control.*;

public class Controller
{
    public TextField nameTxt, nameProductTxt, priceProductTxt;
    public TextArea habitsTxt;
    public Label warmingMessageTxt;
    public ListView animalList;

    Reservation res = new Reservation();

    private boolean isCat = true;
    private Gender gender = Gender.Female;

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

        updateList();

    }

    public void addProduct()
    {

    }

    private void updateList()
    {
        animalList.getItems().clear();
        animalList.getItems().addAll(res.getAnimals());
    }

    public void initialize()
    {
        habitsTxt.setText(null);
        nameTxt.setText(null);
    }

}
