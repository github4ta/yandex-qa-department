package ru.yandex.practicum.department.qa.sergei_tsarik;

import ru.yandex.practicum.department.qa.sergei_tsarik.domain.Client;
import ru.yandex.practicum.department.qa.sergei_tsarik.enums.CreditRating;
import ru.yandex.practicum.department.qa.sergei_tsarik.enums.Gender;
import ru.yandex.practicum.department.qa.sergei_tsarik.enums.IncomeSource;
import ru.yandex.practicum.department.qa.sergei_tsarik.enums.Purpose;

public class App {
    public static void main( String[] args ) {
        Client client = new Client(Gender.MALE, 50, IncomeSource.PASSIVE, CreditRating.EXCELLENT, 1, 1, 3, Purpose.CONSUMER);

        if (!client.isAgeEligible()) throw new IllegalArgumentException("The age is more than retirement age" );
        if (!client.isIncomeSourceEligible()) throw new IllegalArgumentException("No credit for " + IncomeSource.UNEMPLOYED);
        if (!client.isCreditRatingEligible()) throw new IllegalArgumentException("No credit for rating " + CreditRating.POOR);

        double maxSumToLoan = client.getMaxCreditSumAccordingToIncomeSourceAndCreditRating();
        double clientSumToLoan = client.getSum();
        System.out.println("Client sum to loan = " + clientSumToLoan);
        System.out.println("Max credit loan sum according to credit rating and income source = " + maxSumToLoan);
        if (clientSumToLoan > maxSumToLoan) client.setLoan(maxSumToLoan);
        System.out.println("Client loan sum = " + client.getLoan());

        maxSumToLoan = client.getMaxCreditSumAccordingToIncomeAndMaturity();
        // System.out.println("Max credit loan sum according to income and maturity = " + maxSumToLoan);
        if (!client.doesIncomeCoverLoan()) throw new IllegalArgumentException("No credit ...");

        client.calculateAnnualPayment();
        double payment = client.getAnnualPayment();
        System.out.println("Annual payment = " + payment);
        System.out.println("Percentage = " + client.getPercentage() + " %");
        if (!client.doesIncomeCoverAnnualPayment()) throw new IllegalArgumentException("Income does not cover annual payment");
    }
}
