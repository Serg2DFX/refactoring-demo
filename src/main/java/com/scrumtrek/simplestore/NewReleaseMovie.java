package com.scrumtrek.simplestore;

public class NewReleaseMovie extends AbstractMovie {

    public NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    public double getAmount(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getFrequentRenterPoint(int daysRented) {
        int renterPoint = super.getFrequentRenterPoint(daysRented);
        if (daysRented > 1) {
            renterPoint += 1;
        }
        return renterPoint;
    }
}