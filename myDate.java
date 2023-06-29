package com.example.majortask;


import java.time.LocalDate;

public class myDate {
    public int Year;
    public int Month;
    public int Day;

    public myDate(int year, int month, int day) {
        Year = year;
        Month = month;

        if(day>31){
            Month++;
            Day= Day-day;
        }else{
            Day = day;
        }
    }
    public myDate() {
        Year = 2003;
        Month = 4;
        Day = 16;

    }
    public String toStringDate(myDate d1){
        return d1.Year+"-"+ d1.Month+"-"+d1.Day;
    }
    public myDate toDateString(String s)
    {
        String[] token = s.split("-");
        Year=Integer.parseInt(token[0]);
        Month=Integer.parseInt(token[1]);
        Day=Integer.parseInt(token[2]);
        myDate d4 = new myDate(Year,Month,Day);
        return d4;
    }
    public myDate fromLocaltomy(LocalDate date){
        myDate returndate=new myDate(date.getYear(),date.getMonthValue(),date.getDayOfMonth());
        return returndate;
    }

    public int diffDate( myDate d2){
        int yearsdiff = this.Year- d2.Year;
        int monthsdiff= this.Month-d2.Month;
        int daysdiff= this.Day-d2.Day;
        return ((yearsdiff*365)+(monthsdiff*30)+daysdiff);

    }
}