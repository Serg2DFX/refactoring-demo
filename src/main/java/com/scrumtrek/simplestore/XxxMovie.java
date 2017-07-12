package com.scrumtrek.simplestore;

public class XxxMovie extends AbstractMovie {
    public XxxMovie(String title) {
        super(title);
    }

    @Override
    public double getAmount(int daysRented) {
        double amount = 2;
        if (daysRented > 2) {
            amount += (daysRented - 2) * 1.5;
        }
        return amount * 0.85;
    }
}