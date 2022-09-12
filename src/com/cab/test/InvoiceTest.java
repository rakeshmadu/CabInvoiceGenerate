package com.cab.test;

import com.cab.entities.Invoice;
import com.cab.entities.Ride;
import com.cab.services.InvoiceGenerator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InvoiceTest {

	InvoiceGenerator invoiceGenerator;

	@Before
	public void initialization() {
		invoiceGenerator = new InvoiceGenerator();
	}

	@Test
	public void testGenerateInvoice() {

		assertEquals(103, invoiceGenerator.generateInvoice(new Ride(10, 3)), 0.0);
	}

	@Test
	public void testGenerateInvoice_getMin() {

		assertEquals(5, invoiceGenerator.generateInvoice(new Ride(0.1, 1)), 0.0);
	}

	@Test
	public void testGenerateInvoice_multipleRides() {

		Ride [] rides = {new Ride(0.1, 2), new Ride(10, 3)};
		Invoice invoice = new Invoice(2, 108, 54);

		assertEquals(invoice, invoiceGenerator.generateInvoice(rides));
	}


}