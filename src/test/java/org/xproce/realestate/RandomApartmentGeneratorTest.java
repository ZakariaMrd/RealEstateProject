package org.xproce.realestate;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class RandomApartmentGeneratorTest {
    @RepeatedTest(100)
    void should_GenerateCorrectApartment_When_DefaultMinAreaMinPrice() {
        RandomApartmentGenerator generator = new RandomApartmentGenerator();
        Apartment apartment = generator.generate();
        assertTrue(apartment.getArea() >= 20);
        assertTrue(apartment.getPrice().compareTo(BigDecimal.valueOf(100000)) >= 0);
    }
    @RepeatedTest(20)
    void should_GenerateCorrectApartment_When_CustomMinAreaMinPrice() {
           RandomApartmentGenerator generator = new RandomApartmentGenerator(20, new BigDecimal(100000));
            Apartment apartment = generator.generate();
            assertTrue(apartment.getArea() >= 20);
            assertTrue(apartment.getPrice().compareTo(BigDecimal.valueOf(100000)) >= 0);
    }
}