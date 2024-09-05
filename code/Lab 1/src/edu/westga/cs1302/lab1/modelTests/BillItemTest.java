package edu.westga.cs1302.lab1.modelTests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab1.model.BillItem;

class BillItemTest {

	@Test
	void testNewBillItem() {
		BillItem item = new BillItem("Pasta", 21.99);
		assertEquals("Pasta", item.getName());
		assertEquals(21.99, item.getAmount());
	}

	@Test
	void testNewBillItemWithZeroAmount() {
		assertThrows(IllegalArgumentException.class, () -> {
			new BillItem("Pasta", 0);
		});
	}

	@Test
	void testNewBillItemWithNegativeAmount() {
		assertThrows(IllegalArgumentException.class, () -> {
			new BillItem("Pasta", -21.99);
		});
	}

	@Test
	void testNewBillItemWithNullName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new BillItem(null, 21.99);
		});
	}

}
