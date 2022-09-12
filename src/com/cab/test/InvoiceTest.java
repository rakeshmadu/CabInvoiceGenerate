package com.cab.test;

import com.cab.entities.Ride;
import com.cab.services.InvoiceGenerator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InvoiceTest {

	InvoiceGenerator invoice;

	@Before
	public void initialization() {
		invoice = new InvoiceGenerator();
	}

	@Test
	public void testGenerateInvoice() {

		assertEquals(103, invoice.generateInvoice(new Ride(10, 3)), 0.0);
	}

	@Test
	public void testGenerateInvoice_getMin() {

		assertEquals(5, invoice.generateInvoice(new Ride(0.1, 1)), 0.0);
	}

	@Test
	public void testGenerateInvoice_multipleRides() {

		Ride [] rides = {new Ride(0.1, 2), new Ride(10, 3)};

		assertEquals(108, invoice.generateInvoice(rides), 0.0);
	}

}