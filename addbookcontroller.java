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

public class addbookcontroller {
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    TextField titletext;
    @FXML
    TextField authortext;
    @FXML
    TextField bookidtext;
    //    @FXML
//    TextField rentedtext;
    @FXML
    Button backbutton;
    @FXML
    Button addtolibbutton;

    @FXML
    Label foundtext;
    public static String toString2(Book book) {
        return  book.getId() + "," + book.getTitle() + "," + book.getAuthor() +","+ book.isRented();
    }

    public void addbooktolib(ActionEvent event1) throws IOException {
        int id=Integer.parseInt(bookidtext.getText());
        String title= titletext.getText();
        String author= authortext.getText();
//        boolean rented= Boolean.parseBoolean(rentedtext.getText());
        Book b1=new Book(id,title,author,false);
        Library.booksList.add(b1);
        FileWriter fileWriter = new FileWriter("C:\\Users\\DELL\\IdeaProjects\\Majortask\\src\\main\\java\\com\\example\\majortask\\bookdata.txt",true);
        fileWriter.write(toString2(b1) + "\n");
        fileWriter.close();
        foundtext.setText("the book is added successfully");
    }

    public void backTOadmin(ActionEvent event) throws Exception {
        root =  FXMLLoader.load(getClass().getResource("admin.fxml"));
        stage=(Stage) backbutton.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}