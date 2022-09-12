package com.cab.test;

import com.cab.entities.Invoice;
import com.cab.entities.Ride;
import com.cab.entities.RideRepository;
import com.cab.services.InvoiceGenerator;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class InvoiceTest {

	InvoiceGenerator invoiceGenerator;
	RideRepository rideRepository = new RideRepository();
	HashMap<Integer, Ride[]> rideRepo;

	@Before
	public void initialization() {
		invoiceGenerator = new InvoiceGenerator();
		rideRepo = rideRepository.getRideRepo();
	}

	@Test
	public void testGenerateInvoice() {

		assertEquals(103, invoiceGenerator.generateInvoice(new Ride(10, 3, "normal")), 0.0);
	}

	@Test
	public void testGenerateInvoice_getMin() {

		assertEquals(5, invoiceGenerator.generateInvoice(new Ride(0.1, 1, "normal")), 0.0);
	}

	@Test
	public void testGenerateInvoice_multipleRides() {

		Ride[] rides1 = { new Ride(0.1, 2, "premium"), new Ride(10, 3, "normal") };
		Ride[] rides2 = { new Ride(3, 2, "normal"), new Ride(1, 3, "premium"), new Ride(150, 300, "premium") };
		Ride[] rides3 = { new Ride(5, 7, "normal") };

		rideRepo.put(1, rides1);
		rideRepo.put(2, rides2);
		rideRepo.put(3, rides3);

		Invoice invoice = new Invoice(3, 2903, 967.6666666666666);

		assertEquals(invoice, invoiceGenerator.generateInvoice(2, rideRepo));
	}

}