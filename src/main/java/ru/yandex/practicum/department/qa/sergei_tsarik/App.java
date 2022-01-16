package ru.yandex.practicum.department.qa.sergei_tsarik;

import ru.yandex.practicum.department.qa.sergei_tsarik.domain.Client;
import ru.yandex.practicum.department.qa.sergei_tsarik.enums.CreditRating;
import ru.yandex.practicum.department.qa.sergei_tsarik.enums.Gender;
import ru.yandex.practicum.department.qa.sergei_tsarik.enums.IncomeSource;
import ru.yandex.practicum.department.qa.sergei_tsarik.enums.Purpose;
import ru.yandex.practicum.department.qa.sergei_tsarik.utils.Credit;
import ru.yandex.practicum.department.qa.sergei_tsarik.utils.Interest;
import ru.yandex.practicum.department.qa.sergei_tsarik.utils.Payment;
import ru.yandex.practicum.department.qa.sergei_tsarik.utils.Validation;

public class App {
    public static void main( String[] args ) {
        Client client = new Client(Gender.MALE, 50, IncomeSource.PASSIVE, CreditRating.EXCELLENT, 1, 1, 3, Purpose.CONSUMER);

        if (!Validation.isAgeEligible(client)) throw new IllegalArgumentException("Credit is impossible due to that age is more than retirement age." );
        if (!Validation.isIncomeSourceEligible(client)) throw new IllegalArgumentException("Credit is impossible due to " + IncomeSource.UNEMPLOYED);
        if (!Validation.isCreditRatingEligible(client)) throw new IllegalArgumentException("Credit is impossible due to credit rating is " + CreditRating.POOR);

        if (!Validation.isRequestedSumLessOrEqualsToMaxCreditSum(client)) client.setLoan(Credit.getMaxSumForIncomeSourceAndCreditRating(client));

        if (!Validation.isLoanCoveredByIncome(client)) throw new IllegalArgumentException("Credit is impossible due to income does not cover loan and percentages.");
        if (!Validation.isAnnualPaymentCoveredByIncome(client)) throw new IllegalArgumentException("Credit is impossible due to income does not cover annual payment.");

        System.out.println("Credit is possible.");
        System.out.println("Credit loan = " + client.getLoan());
        System.out.println("Credit annual payment  = " + Payment.getAnnualPayment(client) + " M.");
    }
}
