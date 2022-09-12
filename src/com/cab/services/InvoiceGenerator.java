package com.cab.services;

import com.cab.entities.Invoice;
import com.cab.entities.Ride;

import java.util.HashMap;
import java.util.Map;

public class InvoiceGenerator {

	public double generateInvoice(Ride ride) {
		double fare = (ride.distancePrice * ride.distance)+ (ride.timePrice * ride.time);

		return fare > 5 ? fare : 5;
	}

	public Invoice generateInvoice(Ride[] rides) {
		double singleFare;
		double totalFare = 0;
		for (Ride ride : rides) {
			singleFare = generateInvoice(ride);
			totalFare += singleFare > 5 ? singleFare : 5;
		}

		Invoice in = new Invoice(rides.length, totalFare, totalFare / rides.length);
		System.out.println(in);
		return in;

	}

	public Invoice generateInvoice(int i, HashMap<Integer, Ride[]> rideRepo) {

		for (Map.Entry<Integer, Ride[]> rideEntry : rideRepo.entrySet()) {
			if (rideEntry.getKey() == i)
				return generateInvoice(rideEntry.getValue());
		}

		return null;
	}

}