package edu.westga.cs1302.lab1.modelTests;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab1.model.Bill;
import edu.westga.cs1302.lab1.model.BillItem;

class BillTest {

	@Test
	void testBillStartsEmpty() {
		Bill bill = new Bill();
		assertTrue(bill.getItems().isEmpty());
	}

	@Test
	void testAddItemToBill() {
		Bill bill = new Bill();
		BillItem item = new BillItem("Pasta", 21.99);
		bill.addItem(item);

		assertEquals(1, bill.getItems().size());
		assertEquals("Pasta", bill.getItems().get(0).getName());
		assertEquals(21.99, bill.getItems().get(0).getAmount());
	}

	@Test
	void testAddNullItemToBill() {
		Bill bill = new Bill();
		assertThrows(IllegalArgumentException.class, () -> {
			bill.addItem(null);
		});
	}

}
