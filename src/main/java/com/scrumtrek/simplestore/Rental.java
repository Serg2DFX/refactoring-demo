package com.scrumtrek.simplestore;

public class Rental {
	private AbstractMovie m_Movie;
	private int m_DaysRented;

	public Rental(AbstractMovie movie, int daysRented) {
		m_Movie = movie;
		m_DaysRented = daysRented;
	}

	public int getDaysRented() {
		return m_DaysRented;
	}

	public AbstractMovie getMovie() {
		return m_Movie;
	}
}