package com.scrumtrek.simplestore;

public class RegularMovie extends AbstractMovie {

    public RegularMovie(String title) {
        super(title);
    }

    @Override
    public double getAmount(int daysRented) {
        double amount = 2;
        if (daysRented > 2) {
            amount += (daysRented - 2) * 1.5;
        }
        return amount;
    }
}