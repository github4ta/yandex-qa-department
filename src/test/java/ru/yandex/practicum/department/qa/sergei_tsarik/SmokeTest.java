package ru.yandex.practicum.department.qa.sergei_tsarik;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import ru.yandex.practicum.department.qa.sergei_tsarik.Bank;
import ru.yandex.practicum.department.qa.sergei_tsarik.domain.Client;
import ru.yandex.practicum.department.qa.sergei_tsarik.domain.Credit;
import ru.yandex.practicum.department.qa.sergei_tsarik.enums.*;

public class SmokeTest {

    @Test
    public void testPathOne() {
        String expectedMessage = "Credit is impossible due to that age is more than retirement age.";
        Client client = new Client(Gender.MALE, 70, IncomeSource.BUSINESS, CreditRating.EXCELLENT, 10, 5, 3, Purpose.CONSUMER);
        Bank bank = new Bank();
        Credit credit = bank.applyForCredit(client);
        String actualMessage = credit.toString();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testPathTwo() {
        String expectedMessage = "Credit is impossible due to UNEMPLOYED.";
        Client client = new Client(Gender.MALE, 50, IncomeSource.UNEMPLOYED, CreditRating.EXCELLENT, 10, 5, 3, Purpose.CONSUMER);
        Bank bank = new Bank();
        Credit credit = bank.applyForCredit(client);
        String actualMessage = credit.toString();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testPathThree() {
        String expectedMessage = "Credit is impossible due to credit rating is POOR.";
        Client client = new Client(Gender.MALE, 50, IncomeSource.EMPLOYEE, CreditRating.POOR, 10, 5, 3, Purpose.CONSUMER);
        Bank bank = new Bank();
        Credit credit = bank.applyForCredit(client);
        String actualMessage = credit.toString();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testPathFour() {
        String expectedMessage = "Credit is impossible due to income does not cover loan and percentages.";
        Client client = new Client(Gender.MALE, 50, IncomeSource.EMPLOYEE, CreditRating.EXCELLENT, 6, 5, 2, Purpose.CONSUMER);
        Bank bank = new Bank();
        Credit credit = bank.applyForCredit(client);
        String actualMessage = credit.toString();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testPathFive() {
        String expectedMessage = "Credit is impossible due to income does not cover annual payment.";
        Client client = new Client(Gender.FEMALE, 50, IncomeSource.EMPLOYEE, CreditRating.GOOD, 1.5, 5, 10, Purpose.CONSUMER);
        Bank bank = new Bank();
        Credit credit = bank.applyForCredit(client);
        String actualMessage = credit.toString();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testPathSix() {
        double creditSumExpected = 9.3905620875659;
        Client client = new Client(Gender.MALE, 50, IncomeSource.BUSINESS, CreditRating.EXCELLENT, 10, 5, 3, Purpose.CONSUMER);
        Bank bank = new Bank();
        Credit credit = bank.applyForCredit(client);
        double creditSumActual = credit.getInterest();

        assertEquals(creditSumExpected, creditSumActual);
    }
}
