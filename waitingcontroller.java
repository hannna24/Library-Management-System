package com.example.majortask;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.EventObject;

import static com.example.majortask.Library.*;
import static com.example.majortask.Library.booksList;
import static com.example.majortask.printbookinfocontroller.setsearchindex0;
import static com.example.majortask.printuserinfocontroller.*;
import static com.example.majortask.printbookinfocontroller.rent;

public class waitingcontroller {
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;

    @FXML
    private Button backbutton;

    @FXML
    private Label bookerrortext;

    @FXML
    private Label personerrortext;

    @FXML
    private TextField searchtext;
    @FXML
    private Button searchbutton;
    @FXML
    private TextField searchtext1;
    private int searchindex0;
    private int searchindex1;
    private boolean found1;
    private boolean found2;
    public void searchW(ActionEvent event4) throws Exception {
        //Search for Person
        String searchText = searchtext.getText(); // Get the text from the search text
        searchindex0 = Library.searchMember(searchText); // Pass the text to the search function in the Library class
        if (searchindex0 == -1) {
            found1=false;
            System.out.println("notfound");
            personerrortext.setText("User not found");
            setsearchindex0(searchindex0);
        } else {
            found1=true;
            System.out.println(searchText + " is found at index " + searchindex0);
            personerrortext.setText("User found");

        }
//Search for Book
        String searchText1 = searchtext1.getText(); // Get the text from the search text
        searchindex1 = Library.searchBooks(searchText1); // Pass the text to the search function in the Library class
        if (searchindex == -1) {
            found2=false;
            System.out.println("notfound");
            personerrortext.setText("Book not found");
        } else {
            found2=true;
            System.out.println(searchText + " is found at index " + searchindex1);
            bookerrortext.setText("Book found");
        }

        if(found1 && found2){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("waitinglistaction.fxml"));
            root = loader.load();
            waitingcontroller waitingcontroller = loader.getController();
            stage = (Stage) ((Node) event4.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

//            root = FXMLLoader.load(getClass().getResource("waitinglistaction.fxml"));
//            stage = (Stage) searchbutton.getScene().getWindow();
//            scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
        }
    }

    public void addtowaitinglist(int searchindex,int userindex) throws Exception {
        try {
            waitinglist.add(new Order(membersList.get(userindex), booksList.get(searchindex)));
        }catch (Exception e)
        {
            System.out.println("ohhhh");
        }
        RWfile.writewaitinglist();
        System.out.println("dona y basha");
    }
    public void removefromwaitinglist(int searchindex,int userindex) throws Exception {
        waitinglist.remove(new Order(membersList.get(userindex),booksList.get(searchindex)));
        RWfile.writewaitinglist();
    }
    public void removefromwaitinglistonAction(ActionEvent event)throws Exception{
        removefromwaitinglist(searchindex,loginindex);
    }
    public void addtowaitinglistonAction(ActionEvent event)throws Exception{
        addtowaitinglist(searchindex,loginindex);
    }
    static void setloginindex(int number) {
        loginindex = number;
    }
    public  void rentButtonAction() throws Exception {
        rent(searchindex,printuserinfocontroller.loginindex);
    }


    public void backTOadmin (ActionEvent event2) throws Exception {

        root = FXMLLoader.load(getClass().getResource("admin.fxml"));
        stage = (Stage) backbutton.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void backTOSearch(ActionEvent event) throws Exception {
        root =  FXMLLoader.load(getClass().getResource("searchbook.fxml"));
        stage=(Stage) backbutton.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}