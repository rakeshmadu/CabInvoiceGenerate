package com.cab.services;

import com.cab.entities.Ride;

public class InvoiceGenerator {

	public double generateInvoice(Ride ride) {
		double fare = 10*ride.distance + ride.time;

		return fare > 5 ? fare : 5;
	}

	public double generateInvoice(Ride[] rides) {
		double singleFare;
		double totalFare = 0;
		for (Ride ride : rides) {
			singleFare = 10*ride.distance + ride.time;
			totalFare += singleFare > 5 ? singleFare : 5;
		}


		return totalFare;
	}


}
