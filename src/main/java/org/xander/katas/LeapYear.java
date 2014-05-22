package org.xander.katas;

public class LeapYear {
    public boolean checkTheYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 4 == 0 && year % 400 == 0;
    }
}
