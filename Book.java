package com.example.majortask;


import java.time.LocalDate;
import java.util.Date;

public class Book {
    public Integer id ;
    public String Title;
    private String Author;
    public boolean rented;
    private boolean isReturned;
    private person rentedBy;
    private myDate toReturnDate;
    public void setRentedBy(person rentedBy) {
        this.rentedBy = rentedBy;
    }
    public void setToReturnDate(myDate returnDate) {
        this.toReturnDate = returnDate;
    }
    public void setReturned(boolean returned) {
        isReturned = returned;
    }
    public person getRentedBy() {
        return rentedBy;
    }
    public Date getReturnDate() {
        Date d1= new Date(toReturnDate.Year,toReturnDate.Month,toReturnDate.Day);
        return d1;
    }
    public myDate getToReturnDate(){
        return toReturnDate;
    }
    public boolean getIsReturned() {
        return isReturned;
    }
    public void setIsReturned(boolean bool) {
        isReturned=bool;
    }
    public Book(Integer id, String title, String author, boolean rented) {
        this.id = id;
        this.Title = title;
        this.Author = author;
        this.rented = rented;

    }
    public Book() {

    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return Title;
    }
    public String getAuthor() {
        return Author;
    }
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + Title + '\'' +
                ", author='" + Author + '\'' +
                ", 'rented='" + rented +
                '}';
    }
    public boolean isRented() {
        return rented;
    }
    public void setRented(boolean rented) {
        this.rented = rented;
        this.setToReturnDate(new myDate(LocalDate.now().plusDays(14).getYear(),LocalDate.now().plusDays(14).getMonthValue(),LocalDate.now().plusDays(14).getDayOfMonth()));
    }
}