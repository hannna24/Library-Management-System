package com.example.majortask;

import com.example.majortask.myDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Order {
    private person p1;
    private Book book;
    private myDate dateOrdered;
    private myDate dateToReturn;
    private myDate dateReturned;
    private boolean isReturned;
    private int counter;
    private String isReturnedText;
    public static int allCounter;

    //Constructor for Person Book DateOrdered Deadline
    public Order(person p1, Book book, myDate date, myDate deadline) {
        //new order is made
        this.p1 = p1;
        this.book = book;
        this.dateOrdered = date;
        this.dateToReturn = deadline;
        book.setToReturnDate(deadline);
        this.counter++;
        allCounter++;
    }
    public Order(person p1, Book book) {
        this.p1 = p1;
        this.book = book;
    }
    //Constructor for Book DateOrdered Deadline
    public Order(Book book, myDate date, myDate deadline) {
        //new order is made
        this.book = book;
        this.dateOrdered = date;
        this.dateToReturn = deadline;
        this.counter++;
        allCounter++;
    }

    //Constructor for Person Book returnDate
    public Order(person p1, Book book, myDate date) {
        //return order
        this.p1 = p1;
        this.book = book;
        this.dateReturned = date;
        this.counter--;
        allCounter--;
    }

    public person getP1() {
        return p1;
    }
    public Book getBook() {
        return book;
    }
    public String getReturned() {
        if (isReturned) {
            isReturnedText = "Returned";
        } else {
            isReturnedText = "Not Returned";
        }
        return isReturnedText;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public static int getAllCounter() {
        return allCounter;
    }

    public String getString(myDate Date){
        return Date.toStringDate(Date);
    }
    public myDate getDate(String s){
        myDate date= new myDate(2003,4,16);
        return date.toDateString(s);
    }

    public String getDateOrderedString(){
        return getString(dateOrdered);
    }
    public String getDateToReturnString(){
        return getString(dateToReturn);
    }
    public String getDateReturnedString(){
        return getString(dateReturned);
    }


}