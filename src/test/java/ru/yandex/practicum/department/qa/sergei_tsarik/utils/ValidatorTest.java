package ru.yandex.practicum.department.qa.sergei_tsarik.utils;

import ru.yandex.practicum.department.qa.sergei_tsarik.domain.Client;
import ru.yandex.practicum.department.qa.sergei_tsarik.enums.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidatorTest {

    @Test
    public void testIsAgeEligibleForMale() {
        Client client = new Client(Gender.MALE, RetirementAge.BY_2022_MALE.getValue(), IncomeSource.BUSINESS, CreditRating.EXCELLENT, 10, 5, 3, Purpose.CONSUMER);
        assertTrue(Validator.isAgeEligible(client));
    }

    @Test
    public void testIsAgeNotEligibleForMale() {
        Client client = new Client(Gender.MALE, RetirementAge.BY_2022_MALE.getValue() + 1, IncomeSource.BUSINESS, CreditRating.EXCELLENT, 10, 5, 3, Purpose.CONSUMER);
        assertFalse(Validator.isAgeEligible(client));
    }

    @Test
    public void testIsNegativeAgeNotEligibleForMale() {
        Client client = new Client(Gender.MALE, -1, IncomeSource.BUSINESS, CreditRating.EXCELLENT, 10, 5, 3, Purpose.CONSUMER);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Validator.isAgeEligible(client);
        });
        String expectedMessage = "Negative age is not eligible.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testIsAgeEligibleForFemale() {
        Client client = new Client(Gender.FEMALE, RetirementAge.BY_2022_FEMALE.getValue(), IncomeSource.BUSINESS, CreditRating.EXCELLENT, 10, 5, 3, Purpose.CONSUMER);
        assertTrue(Validator.isAgeEligible(client));
    }

    @Test
    public void testIsAgeNotEligibleForFemale() {
        Client client = new Client(Gender.FEMALE, RetirementAge.BY_2022_FEMALE.getValue() + 1, IncomeSource.BUSINESS, CreditRating.EXCELLENT, 10, 5, 3, Purpose.CONSUMER);
        assertFalse(Validator.isAgeEligible(client));
    }

    @Test
    public void testIsNegativeAgeNotEligibleForFemale() {
        Client client = new Client(Gender.FEMALE, -1, IncomeSource.BUSINESS, CreditRating.EXCELLENT, 10, 5, 3, Purpose.CONSUMER);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Validator.isAgeEligible(client);
        });
        String expectedMessage = "Negative age is not eligible.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    public void testIsIncomeSourceEligible() {
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 2})
    public void testIsCreditRatingEligibleForMale(int creditRatingValue) {
        Client client = null;
        switch (creditRatingValue) {
            case -1:
                client = new Client(Gender.MALE, RetirementAge.BY_2022_MALE.getValue(), IncomeSource.BUSINESS, CreditRating.FAIR, 10, 5, 3, Purpose.CONSUMER);
                break;
            case 0:
                client = new Client(Gender.MALE, RetirementAge.BY_2022_MALE.getValue(), IncomeSource.BUSINESS, CreditRating.GOOD, 10, 5, 3, Purpose.CONSUMER);
                break;
            case 1:
                client = new Client(Gender.MALE, RetirementAge.BY_2022_MALE.getValue(), IncomeSource.BUSINESS, CreditRating.GREAT, 10, 5, 3, Purpose.CONSUMER);
                break;
            case 2:
                client = new Client(Gender.MALE, RetirementAge.BY_2022_MALE.getValue(), IncomeSource.BUSINESS, CreditRating.EXCELLENT, 10, 5, 3, Purpose.CONSUMER);
                break;
        }
        assertTrue(Validator.isCreditRatingEligible(client));
    }

    @Test
    public void testIsCreditRatingNotEligibleForMale() {
        Client client = new Client(Gender.MALE, RetirementAge.BY_2022_MALE.getValue(), IncomeSource.BUSINESS, CreditRating.POOR, 10, 5, 3, Purpose.CONSUMER);
        assertFalse(Validator.isCreditRatingEligible(client));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    public void testIsRequestedSumLessOrEqualsToMaxCreditSum(int requestedSum) {
        Client client = new Client(Gender.MALE, RetirementAge.BY_2022_MALE.getValue(), IncomeSource.BUSINESS, CreditRating.GOOD, 10, requestedSum, 10, Purpose.MORTGAGE);
        assertTrue(Validator.isCreditRatingEligible(client));
    }

    @Test
    public void testIsAnnualPaymentCoveredByIncome() {
        Client client = new Client(Gender.MALE, RetirementAge.BY_2022_MALE.getValue(), IncomeSource.BUSINESS, CreditRating.GOOD, 10, 1, 10, Purpose.MORTGAGE);
        assertTrue(Validator.isCreditRatingEligible(client));
    }

    @Test
    public void testIsLoanCoveredByIncome() {
        Client client = new Client(Gender.MALE, RetirementAge.BY_2022_MALE.getValue(), IncomeSource.EMPLOYEE, CreditRating.GOOD, 10, 1, 10, Purpose.MORTGAGE);
        assertTrue(Validator.isCreditRatingEligible(client));
    }
}