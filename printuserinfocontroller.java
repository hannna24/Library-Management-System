package com.example.majortask;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import static com.example.majortask.Library.membersList;
import static com.example.majortask.searchusercontroller.searchindex;

public class printuserinfocontroller {
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    Button backbutton;
    @FXML
    Button deletebutton;
    @FXML
    Label firstnametext;
    @FXML
    Label lastnametext;
    @FXML
    Label emaLabeliltext;
    @FXML
    Label phonenumbertext;
    @FXML
    Label addresstext;
    @FXML
    Label idtext;
    @FXML
    Label passwordtext;
    @FXML
    Label typetext;
    @FXML
    Label foundtext;
    @FXML
    Label foundtext1;
    static int loginindex;
    static int searchindex;

    static public void setloginindex(int number) {loginindex = number;}
    public void setsearchindex(int number) {
        searchindex = number;
    }
    public void showResults(int searchindex) throws Exception {
        try {
            person member = Library.membersList.get(searchindex);
            firstnametext.setText(member.firstName);
            lastnametext.setText(member.lastName);
            emaLabeliltext.setText(member.email);
            phonenumbertext.setText(String.valueOf(member.cellPhone));
            addresstext.setText(member.address);
            idtext.setText(member.id);
            if (Library.membersList.get(loginindex).type.equals("librarian")) {
                passwordtext.setText(String.valueOf(member.password));
            } else {
                passwordtext.setText("*********");
            }
            typetext.setText(member.type);
            setsearchindex(searchindex);
        } catch (Exception e) {
            System.out.println("error showing results ");
        }
    }

    public void backTOSearch(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("searchuser.fxml"));
        stage = (Stage) backbutton.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void backTOSearchwithblock(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("searchusertoblock.fxml"));
        stage = (Stage) backbutton.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void backTOSearchwithdelete(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("searchremoveuser.fxml"));
        stage = (Stage) backbutton.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void delete() throws Exception {
        membersList.remove(membersList.get(searchindex));
        RWfile.writeuser();
//        foundtext.setText("Deleted successfully");
        root = FXMLLoader.load(getClass().getResource("searchuser.fxml"));
        stage = (Stage) backbutton.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void block (ActionEvent event) throws Exception{
        Library.membersList.get(searchindex).setBlocked(true);
        RWfile.writeuser();
        foundtext1.setText("User Blocked successfully");
    }
    public void unblock (ActionEvent event) throws Exception{
        Library.membersList.get(searchindex).setBlocked(false);
        RWfile.writeuser();
        foundtext1.setText("User Un-blocked successfully");
    }
}