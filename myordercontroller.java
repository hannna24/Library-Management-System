package com.example.majortask;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.majortask.Library.*;
import static com.example.majortask.allorderscontroller2.loopindex;
import static com.example.majortask.printuserinfocontroller.loginindex;

public class myordercontroller implements Initializable {

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
    static int myloopindex=0;
    public static int loginindex;
    static void setloginindex(int number) {
        loginindex = number;
    }
    @FXML
    void incrementButton() throws Exception {
        if(myloopindex < (membersList.get(loginindex).mybookOrderList.size() - 1)) {
            myloopindex++;
            errotext.setText(" ");
        } else {
            errotext.setText("Can't go further forward, this is the last order");
        }
        loopMyorders2(loginindex, myloopindex);
    }

    @FXML
    void decrementButton() throws Exception {
        if(myloopindex > 0) {
            myloopindex--;
            errotext.setText(" ");
        } else {
            errotext.setText("Can't go further back, this is the first order");
        }
        loopMyorders2(loginindex, myloopindex);
    }

    void loopMyorders(int index1, int index2)throws Exception{
        try {
            Order order = membersList.get(index1).mybookOrderList.get(index2);

            daterentedtext.setText(order.getDateOrderedString());
            returndatetext.setText(order.getDateToReturnString());

            statustext.setText(order.getReturned());

            booknametext.setText(order.getBook().Title);
            bookidtext.setText(Integer.toString(order.getBook().id));

            totalorders.setText("Order: " +index2+1 );
        }catch (Exception e){
            System.out.println(e);
            errotext.setText("No Data");
        }
    }
    void loopMyorders2(int ind1 , int ind2)throws   Exception{
        try{
            Order order = allOrderList.get(myloopindex);
            if(order.getP1().equals(membersList.get(ind1))){
                daterentedtext.setText(order.getDateOrderedString());
                returndatetext.setText(order.getDateToReturnString());

                statustext.setText(order.getReturned());

                booknametext.setText(order.getBook().Title);
                bookidtext.setText(Integer.toString(order.getBook().id));

                totalorders.setText("Order: " +(myloopindex+1) );
            } else {
                ++myloopindex;
            }

        }catch(Exception e1){
            System.out.println(e1);
        }
    }
    @FXML
    public void initialize() throws Exception {

    }

    public void backTOadmin (ActionEvent event2) throws Exception {
        if (Library.membersList.get(loginindex).getType().equals("reader")) {
            root = FXMLLoader.load(getClass().getResource("adminuser.fxml"));
            stage = (Stage) backbutton.getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else {
            root = FXMLLoader.load(getClass().getResource("admin.fxml"));
            stage = (Stage) backbutton.getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}