/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Savannah Osburn
 */

package ex10;

import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static int NUMITEMS = 3;
    public static double TAXRATE = 0.055;

    public static void main(String[] args) {
        App myApp = new App();

        // Input
        String[] itemsPrice = new String[NUMITEMS];
        String[] itemsQuantity = new String[NUMITEMS];

        myApp.inputItems(itemsPrice, itemsQuantity);

        // Calculations
        double subTotal = myApp.subtotal(itemsPrice, itemsQuantity);
        double tax = myApp.calculateTax(subTotal);
        double total = myApp.total(subTotal, tax);

        // Output
        String outputString = myApp.generateOutput(subTotal, tax, total);
        myApp.output(outputString);
    }

    public void inputItems(String[] itemsPrice, String[] itemsQuantity) {
        int i;

        for (i = 0; i < NUMITEMS; i++) {
            System.out.printf("Enter the price of item %d: ", i + 1);

            // User can only enter number
            while (!in.hasNextDouble()) {
                System.out.print("Invalid price. Enter again: ");
                in.next();
            }

            itemsPrice[i] = in.next();

            System.out.printf("Enter the quantity of item %d: ", i + 1);

            // User can only enter number
            while (!in.hasNextDouble()) {
                System.out.print("Invalid quantity. Enter again: ");
                in.next();
            }

            itemsQuantity[i] = in.next();
        }
    }

    public double subtotal(String[] itemsPrice, String[] itemsQuantity) {
        int i;

        double subTotal = 0;

        for (i = 0; i < NUMITEMS; i++) {
            double price = Double.parseDouble(itemsPrice[i]);
            int quantity = Integer.parseInt(itemsQuantity[i]);

            double calculateItemPrice = price * quantity;

            subTotal += calculateItemPrice;
        }

        return subTotal;
    }

    public double calculateTax(double subtotal) {

        return subtotal * TAXRATE;
    }

    public double total(double subtotal, double tax) {

        return subtotal + tax;
    }

    public String generateOutput(double subTotal, double tax, double total) {
        String str1 = String.format("Subtotal: $%.2f\n", subTotal);
        String str2 = String.format("Tax: $%.2f\n", tax);
        String str3 = String.format("Total: $%.2f", total);

        return str1 + str2 + str3;
    }

    public void output(String outputString) {

        System.out.println(outputString);
    }
}
