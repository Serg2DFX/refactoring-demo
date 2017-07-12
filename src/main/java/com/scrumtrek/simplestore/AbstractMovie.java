package com.scrumtrek.simplestore;

public abstract class AbstractMovie {
    private String m_Title;

    public AbstractMovie(String title) {
        m_Title = title;
    }

    public String getTitle() {
        return m_Title;
    }

    public int getFrequentRenterPoint(int daysRented) {
        int defaultFrequenceRenterPoint = 1;
        return defaultFrequenceRenterPoint;
    }

    public abstract double getAmount(int daysRented);
}