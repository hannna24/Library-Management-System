package com.example.majortask;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;

public class addusercontroller {
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    TextField firstnametext;
    @FXML
    TextField lastnametext;
    @FXML
    TextField emailtext;
    @FXML
    TextField phonenumbertext;
    @FXML
    TextField addresstext;
    @FXML
    TextField idtext;
    @FXML
    PasswordField passwordtext;
    @FXML
    Button adduserbutton;
    @FXML
    RadioButton libtype;
    @FXML
    RadioButton readertype;
    @FXML
    Button backbutton;
    person tempPerson;
    String type;
    @FXML
    Label foundtext;
    public void getType(ActionEvent event)
    {
        if (readertype.isSelected())
        {
            type="reader";

        } else
        {
            type="librarian";

        }
        System.out.println(type);

    }
    public static String toString(person person) {
        return  person.id + "," + person.password + "," + person.type + "," + person.firstName + "," + person.lastName + "," + person.address + "," + person.cellPhone + "," + person.email + "," + person.isBlocked ;
    }
    public void addusertolib(ActionEvent event1) throws IOException {
        String id=idtext.getText();
        String firstname= firstnametext.getText();
        String lastname= lastnametext.getText();
        String email= emailtext.getText();
        int phone= Integer.valueOf(phonenumbertext.getText());
        String address= addresstext.getText();
        String addresss= addresstext.getText();
        String idd= idtext.getText();
        int pasword= Integer.parseInt(passwordtext.getText());
        person p1=new person(idd,pasword,type,firstname,lastname,address,phone,email,false);
        Library.membersList.add(p1);
        FileWriter fileWriter = new FileWriter("C:\\Users\\DELL\\IdeaProjects\\Majortask\\src\\main\\java\\com\\example\\majortask\\Memberdata.txt",true);
        fileWriter.write(toString(p1) + "\n");
        fileWriter.close();
        foundtext.setText("The User is added successfully");
    }
    public void backTOadmin(ActionEvent event) throws Exception {
        root =  FXMLLoader.load(getClass().getResource("admin.fxml"));
        stage=(Stage) backbutton.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
