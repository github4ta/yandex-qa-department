package ru.yandex.practicum.department.qa.sergei_tsarik.utils;

import ru.yandex.practicum.department.qa.sergei_tsarik.domain.Client;
import ru.yandex.practicum.department.qa.sergei_tsarik.enums.CreditRating;
import ru.yandex.practicum.department.qa.sergei_tsarik.enums.IncomeSource;
import ru.yandex.practicum.department.qa.sergei_tsarik.enums.RetirementAge;

public class Validator {

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
        double maxCreditSum = Calculator.getMaxSumForIncomeSourceAndCreditRating(client);
        double requestedSum = client.getRequestedSum();
        return requestedSum <= maxCreditSum;
    }

    public static boolean isAnnualPaymentCoveredByIncome(Client client) {
        return Calculator.getAnnualPayment(client) <= client.getIncome() / 2.0;
    }

    public static boolean isLoanCoveredByIncome(Client client) {
        return client.getAvailableSum() <= Calculator.getMaxSumForIncomeAndMaturity(client);
    }
}
