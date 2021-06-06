/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Savannah Osburn
 */

package ex10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    public void output_string_includes_subtotal_tax_and_total() {
        App myApp = new App();

        String[] prices = {"25", "10", "4"};
        String[] quantities = {"2", "1", "1"};

        double subtotal = myApp.subtotal(prices, quantities);
        double tax = myApp.calculateTax(subtotal);
        double total = myApp.total(subtotal, tax);

        String expectedOutput = """
                Subtotal: $64.00
                Tax: $3.52
                Total: $67.52""";

        String actualOutput = myApp.generateOutput(subtotal, tax, total);

        assertEquals(expectedOutput, actualOutput);
    }
}