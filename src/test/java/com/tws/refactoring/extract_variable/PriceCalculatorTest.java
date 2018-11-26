package com.tws.refactoring.extract_variable;

import org.junit.Test;

import static org.junit.Assert.*;

public class PriceCalculatorTest {

    @Test
    public void should_get_price_not_discount(){
        double price = new PriceCalculator().getPrice(4,3);
        assertEquals(price, 13.2, 0);
    }

    @Test
    public void should_get_price_have_discount(){
        double price = new PriceCalculator().getPrice(9100,3);
        assertEquals(price, 26110, 0);
    }

}