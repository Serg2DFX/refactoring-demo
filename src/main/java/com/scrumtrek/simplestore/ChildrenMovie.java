package com.scrumtrek.simplestore;

public class ChildrenMovie extends AbstractMovie {

    public ChildrenMovie(String title) {
        super(title);
    }

    @Override
    public double getAmount(int daysRented) {
        double amount = 1.5;
        if (daysRented > 3) {
            amount = (daysRented - 3) * 1.5;
        }
        return amount;
    }
}