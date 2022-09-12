package com.cab.services;

import com.cab.entities.Ride;

public class InvoiceGenerator {

	public double generateInvoice(Ride ride) {
		double fare = 10*ride.distance + ride.time;
		
		return fare > 5 ? fare : 5;
	}
}
