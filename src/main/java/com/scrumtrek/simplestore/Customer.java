package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String _name;
	private List<Rental> _rentals = new ArrayList<Rental>();

	public Customer(String name) {
		_name = name;
	}

	public String getName() {
		return _name;
	}

	public void addRental(Rental arg) {
		_rentals.add(arg);
	}

	public Iterable<Rental> getRentals() {
		return _rentals;
	}

	public double getTotalAmount() {
		double totalAmount = 0;
		for (Rental each : _rentals) {
			totalAmount += each.getMovie().getAmount(each.getDaysRented());
		}
		return totalAmount;
	}

	public int getFrequentRenterPoints() {
		int frequentRenterPoints = 0;
		for (Rental each : _rentals) {
			frequentRenterPoints += each.getMovie().getFrequentRenterPoint(each.getDaysRented());
		}
		return frequentRenterPoints;
	}

	public String Statement() {
		StatementFormatter formatter = new StatementFormatter();
		formatter.Format(this);
		return formatter.getResult();
	}
}