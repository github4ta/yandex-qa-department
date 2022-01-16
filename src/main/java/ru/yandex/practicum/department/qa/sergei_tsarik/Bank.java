package ru.yandex.practicum.department.qa.sergei_tsarik;

import ru.yandex.practicum.department.qa.sergei_tsarik.domain.Client;
import ru.yandex.practicum.department.qa.sergei_tsarik.domain.Credit;
import ru.yandex.practicum.department.qa.sergei_tsarik.enums.CreditRating;
import ru.yandex.practicum.department.qa.sergei_tsarik.enums.IncomeSource;
import ru.yandex.practicum.department.qa.sergei_tsarik.utils.Calculator;
import ru.yandex.practicum.department.qa.sergei_tsarik.utils.Validator;

public class Bank {

    public Credit applyForCredit(Client client) {
        try {
            if (!Validator.isAgeEligible(client)) throw new IllegalArgumentException("Credit is impossible due to that age is more than retirement age." );
            if (!Validator.isIncomeSourceEligible(client)) throw new IllegalArgumentException("Credit is impossible due to " + IncomeSource.UNEMPLOYED + ".");
            if (!Validator.isCreditRatingEligible(client)) throw new IllegalArgumentException("Credit is impossible due to credit rating is " + CreditRating.POOR + ".");
            if (!Validator.isRequestedSumLessOrEqualsToMaxCreditSum(client)) client.setAvailableSum(Calculator.getMaxSumForIncomeSourceAndCreditRating(client));
            if (!Validator.isLoanCoveredByIncome(client)) throw new IllegalArgumentException("Credit is impossible due to income does not cover loan and percentages.");
            if (!Validator.isAnnualPaymentCoveredByIncome(client)) throw new IllegalArgumentException("Credit is impossible due to income does not cover annual payment.");

            return new Credit(true, client.getAvailableSum(), Calculator.getAnnualPercentage(client), Calculator.getAnnualPayment(client), client.getMaturity(), "Credit is possible for:");

        } catch (IllegalArgumentException e) {

            return new Credit(false, 0, 0, 0, 0, "Credit is impossible.\n" + e.getMessage());

        }
    }
}
