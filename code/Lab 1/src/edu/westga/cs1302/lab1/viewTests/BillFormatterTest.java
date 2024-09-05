package edu.westga.cs1302.lab1.viewTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab1.model.Bill;
import edu.westga.cs1302.lab1.model.BillItem;
import edu.westga.cs1302.lab1.view.BillFormatter;

class BillFormatterTest {

	@Test
	void testFormatEmptyBill() {
		Bill bill = new Bill();
		BillFormatter formatter = new BillFormatter();

		String billText = formatter.getText(bill);
		String expectedText = "ITEMS" + System.lineSeparator() + System.lineSeparator() + "SUBTOTAL - $0.00"
				+ System.lineSeparator() + "TAX - $0.00" + System.lineSeparator() + "TIP - $0.00"
				+ System.lineSeparator() + "TOTAL - $0.00";

		assertEquals(expectedText, billText);
	}

	@Test
	void testFormatBillWithOneItem() {
		Bill bill = new Bill();
		BillFormatter formatter = new BillFormatter();
		bill.addItem(new BillItem("Espresso", 2.50));

		String billText = formatter.getText(bill);
		String expectedText = "ITEMS" + System.lineSeparator() + "Espresso - $2.50" + System.lineSeparator()
				+ System.lineSeparator() + "SUBTOTAL - $2.50" + System.lineSeparator() + "TAX - $0.25"
				+ System.lineSeparator() + "TIP - $0.50" + System.lineSeparator() + "TOTAL - $3.25";

		assertEquals(expectedText, billText);
	}

	@Test
	void testFormatBillWithMultipleItems() {
		Bill bill = new Bill();
		BillFormatter formatter = new BillFormatter();
		bill.addItem(new BillItem("Espresso", 2.50));
		bill.addItem(new BillItem("Cookie", 1.75));

		String billText = formatter.getText(bill);
		String expectedText = "ITEMS" + System.lineSeparator() + "Espresso - $2.50" + System.lineSeparator()
				+ "Cookie - $1.75" + System.lineSeparator() + System.lineSeparator() + "SUBTOTAL - $4.25"
				+ System.lineSeparator() + "TAX - $0.43" + System.lineSeparator() + "TIP - $0.85"
				+ System.lineSeparator() + "TOTAL - $5.53";

		assertEquals(expectedText, billText);
	}
}
