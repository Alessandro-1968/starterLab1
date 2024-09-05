package edu.westga.cs1302.lab1.view;

import edu.westga.cs1302.lab1.model.Bill;
import edu.westga.cs1302.lab1.model.BillItem;

/**
 * Formats a bill
 * 
 * @author Dante
 * @version Fall 2024
 */
public class BillFormatter {

	public static final double TIPPERCENTAGE = 0.2;
	public static final double TAXPERCENTAGE = 0.1;

	/**
	 * Return a String containing the list of bill items and total for the bill.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param bill to format
	 * @return a String containing the list of bill items and total for the bill
	 */
	public String getText(Bill bill) {
		String text = "ITEMS" + System.lineSeparator();
		double subTotal = 0.0;
		for (BillItem item : bill.getItems()) {
			text += item.getName() + " - $" + String.format("%.2f", item.getAmount()) + System.lineSeparator();
			subTotal += item.getAmount();
		}

		text += System.lineSeparator();
		text += "SUBTOTAL - $" + String.format("%.2f", subTotal) + System.lineSeparator();
		double tax = subTotal * BillFormatter.TAXPERCENTAGE;
		double tip = subTotal * BillFormatter.TIPPERCENTAGE;
		text += "TAX - $" + String.format("%.2f", tax) + System.lineSeparator();
		text += "TIP - $" + String.format("%.2f", tip) + System.lineSeparator();
		text += "TOTAL - $" + String.format("%.2f", subTotal + tax + tip);

		return text;
	}
}
