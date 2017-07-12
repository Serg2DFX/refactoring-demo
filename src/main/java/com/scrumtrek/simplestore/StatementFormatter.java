package com.scrumtrek.simplestore;

public class StatementFormatter {
    private StringBuilder _builder;

    public StatementFormatter() {
        _builder = new StringBuilder();
    }

    public void Format(Customer customer) {
        _builder.append("Rental record for " + customer.getName() + "\n");

        for (Rental each : customer.getRentals()) {
            Format(each);
        }

        AddFooterLines(customer);
    }

    public void Format(Rental rental) {
        double thisAmount = rental.getMovie().getAmount(rental.getDaysRented());
        _builder.append("\t" + rental.getMovie().getTitle() + "\t" + thisAmount + "\n");
    }

    public String getResult() {
        return _builder.toString();
    }

    private void AddFooterLines(Customer customer) {
        _builder.append("Amount owed is " + customer.getTotalAmount() + "\n");
        _builder.append("You earned " + customer.getFrequentRenterPoints() + " frequent renter points.");
    }
}