package com.tws.refactoring.extract_method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.Assert.*;

public class OwingPrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }


    /*given name is Joe, and empty order
      when printOwing
      then print 0 amount owing order
     */
    @Test
    public void should_print_a_owing_order_with_only_header() {
        OwingPrinter owingPrinter = new OwingPrinter();
        owingPrinter.printOwing("Joe", Arrays.asList());
        assertEquals(
                "*****************************\n" +
                        "****** Customer totals ******\n" +
                        "*****************************\n" +
                        "name: Joe\n" +
                        "amount: 0.0\n"
                , outContent.toString());
    }

    /*given name is Tommy, have 1 order that is $5
      when printOwing
      then print a 5 amount owing order
     */
    @Test
    public void should_print_a_owing_order_with_5_dolloar_amount() {
        OwingPrinter owingPrinter = new OwingPrinter();
        owingPrinter.printOwing("Tommy", Arrays.asList(new Order(5)));
        assertEquals(
                "*****************************\n" +
                        "****** Customer totals ******\n" +
                        "*****************************\n" +
                        "name: Tommy\n" +
                        "amount: 5.0\n", outContent.toString());
    }


    /*given name is Sam, have 2 order those are $5 and $10
      when printOwing
      then print a 15 amount owing order
     */
    @Test
    public void should_print_a_owing_order_with_15_dollar_amount() {
        OwingPrinter owingPrinter = new OwingPrinter();
        owingPrinter.printOwing("Sam", Arrays.asList(new Order(5), new Order(10)));
        assertEquals(
                "*****************************\n" +
                        "****** Customer totals ******\n" +
                        "*****************************\n" +
                        "name: Sam\n" +
                        "amount: 15.0\n", outContent.toString());
    }
}