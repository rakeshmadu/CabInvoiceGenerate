package com.cab.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.cab.entities.Ride;
import com.cab.services.InvoiceGenerator;

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
}
