package ru.yandex.practicum.department.qa.sergei_tsarik.utils;

import ru.yandex.practicum.department.qa.sergei_tsarik.domain.Client;
import ru.yandex.practicum.department.qa.sergei_tsarik.enums.CreditRating;
import ru.yandex.practicum.department.qa.sergei_tsarik.enums.IncomeSource;
import ru.yandex.practicum.department.qa.sergei_tsarik.enums.RetirementAge;

public class Validation {

    public static boolean isAgeEligible(Client client) {
        int personAge = client.getAge();
        switch (client.getGender()) {
            case MALE:
                if (personAge <= RetirementAge.BY_2022_MALE.getValue()) return true;
            case FEMALE:
                if (personAge <= RetirementAge.BY_2022_FEMALE.getValue()) return true;
        }
        return false;
    }

    public static boolean isIncomeSourceEligible(Client client) {
        if (client.getIncomeSource() != IncomeSource.UNEMPLOYED) return true;
        return false;
    }

    public static boolean isCreditRatingEligible(Client client) {
        if (client.getCreditRating() != CreditRating.POOR) return true;
        return false;
    }

    public static boolean isRequestedSumLessOrEqualsToMaxCreditSum(Client client) {
        double maxCreditSum = Credit.getMaxSumForIncomeSourceAndCreditRating(client);
        double requestedSum = client.getRequestedSum();
        return requestedSum <= maxCreditSum;
    }

    public static boolean isAnnualPaymentCoveredByIncome(Client client) {
        return Payment.getAnnualPayment(client) <= client.getIncome() / 2.0;
    }

    public static boolean isLoanCoveredByIncome(Client client) {
        return client.getAvailableSum() <= Credit.getMaxSumForIncomeAndMaturity(client);
    }

    public static Client getCheckedClientForCredit(Client client) {
        if (!isAgeEligible(client)) throw new IllegalArgumentException("Credit is impossible due to that age is more than retirement age." );
        if (!isIncomeSourceEligible(client)) throw new IllegalArgumentException("Credit is impossible due to " + IncomeSource.UNEMPLOYED + ".");
        if (!isCreditRatingEligible(client)) throw new IllegalArgumentException("Credit is impossible due to credit rating is " + CreditRating.POOR + ".");
        if (!isRequestedSumLessOrEqualsToMaxCreditSum(client)) client.setAvailableSum(Credit.getMaxSumForIncomeSourceAndCreditRating(client));
        if (!isLoanCoveredByIncome(client)) throw new IllegalArgumentException("Credit is impossible due to income does not cover loan and percentages.");
        if (!isAnnualPaymentCoveredByIncome(client)) throw new IllegalArgumentException("Credit is impossible due to income does not cover annual payment.");

        return client;
    }
}
