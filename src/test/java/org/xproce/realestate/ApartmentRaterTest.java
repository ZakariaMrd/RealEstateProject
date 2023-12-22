package org.xproce.realestate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApartmentRaterTest {
    @ParameterizedTest
    @CsvSource({
            "30.0, 3000.0, 0",
            "40.0, 4000.0, 1",
            "50.0, 5000.0, 2"
    })
    void should_ReturnCorrectRating_When_CorrectApartment(double area, BigDecimal price, int expectedRating) {
        // given
        Apartment apartment = new Apartment(area, price);

        // when
        int rating = ApartmentRater.rateApartment(apartment);

        // then
        assertEquals(expectedRating, rating);
    }
    @Test
    void should_ReturnErrorValue_When_IncorrectApartment() {
        // given
        Apartment apartment = new Apartment(0.0, BigDecimal.ZERO);

        // when
        int rating = ApartmentRater.rateApartment(apartment);

        // then
        assertEquals(-1, rating);
    }
    @Test
    void should_CalculateAverageRating_When_CorrectApartmentList() {

        // when
        double averageRating = ApartmentRater.calculateAverageRating(List.of( new Apartment(30.0, BigDecimal.valueOf(3000.0)),
                new Apartment(40.0, BigDecimal.valueOf(4000.0)),
                new Apartment(50.0, BigDecimal.valueOf(5000.0))));

        // then
        assertEquals(0.0, averageRating);
    }
    @Test
    void should_ThrowException_When_EmptyApartmentList() {

        // when
        RuntimeException exception = assertThrows(RuntimeException.class, () -> ApartmentRater.calculateAverageRating(List.of()));

        // then
        assertEquals("Cannot calculate average rating for empty list", exception.getMessage());
    }

}