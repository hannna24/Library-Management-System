package com.example.majortask;


public class toBlock {
    private person p1;
    private Book b1;
    private myDate expectedReturn ;
    private myDate actualReturn;
    private int lateBy;

    public toBlock(person p1, Book b1, myDate expectedReturn, myDate actualReturn) {
        this.p1 = p1;
        this.b1 = b1;
        this.expectedReturn = expectedReturn;
        this.actualReturn = actualReturn;
        this.lateBy= actualReturn.diffDate(expectedReturn);
    }

    public person getP1() {
        return p1;
    }

    public void setP1(person p1) {
        this.p1 = p1;
    }

    public Book getB1() {
        return b1;
    }

    public void setB1(Book b1) {
        this.b1 = b1;
    }

    public myDate getExpectedReturn() {
        return expectedReturn;
    }

    public void setExpectedReturn(myDate expectedReturn) {
        this.expectedReturn = expectedReturn;
    }

    public myDate getActualReturn() {
        return actualReturn;
    }

    public void setActualReturn(myDate actualReturn) {
        this.actualReturn = actualReturn;
    }

    public int getLateBy() {
        return lateBy;
    }

    public void setLateBy(int lateBy) {
        this.lateBy = lateBy;
    }
}