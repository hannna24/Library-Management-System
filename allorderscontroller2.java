package com.example.majortask;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.majortask.Library.allOrderList;
import static com.example.majortask.printuserinfocontroller.*;

public class allorderscontroller2 implements Initializable {

    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private Button backbutton;

    @FXML
    private Label bookidtext;

    @FXML
    private Label booknametext;

    @FXML
    private Label daterentedtext;

    @FXML
    private Button decbutton;

    @FXML
    private Label firstnametext;

    @FXML
    private Label foundtext;

    @FXML
    private Button incbutton;

    @FXML
    private Label returndatetext;

    @FXML
    private Label statustext;

    @FXML
    private Label totalorders;

    @FXML
    private Label useridtext;
    @FXML
    private Label errotext;
    static int loopindex;
    @FXML
    int incrementButton() throws Exception {
        if(loopindex==(allOrderList.size()-1)){
            errotext.setText("Can't go further forward, this is the last order");
        }else{
            loopindex++;
            errotext.setText(" ");}
        loopAllorders(loopindex);
        return loopindex;
    }
    @FXML
    int decrementButton() throws Exception {
        if(loopindex<=0){
            loopindex=0;
            errotext.setText("Can't go further back, this is the first order");
        }else{
            loopindex--;
            errotext.setText(" ");}
        loopAllorders(loopindex);
        return loopindex;

    }
    void loopAllorders(int index) throws Exception {
        try {
            Order order = allOrderList.get(index);

            useridtext.setText(order.getP1().id);
            firstnametext.setText(order.getP1().firstName);

            daterentedtext.setText(order.getDateOrderedString());
            returndatetext.setText(order.getDateToReturnString());

            statustext.setText(order.getReturned());

            booknametext.setText(order.getBook().Title);
            bookidtext.setText(Integer.toString(order.getBook().id));

            totalorders.setText("Order: " + (index+1));
        }catch (Exception e){
            System.out.println(allOrderList);
            System.out.println("Empty List");
        }
    }

    @FXML
    public void initialize() throws Exception {
        loopindex=-1;
    }

    public void backTOadmin (ActionEvent event2) throws Exception {
        root = FXMLLoader.load(getClass().getResource("admin.fxml"));
        stage = (Stage) ((Node) event2.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
