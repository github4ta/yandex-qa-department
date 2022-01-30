package ru.yandex.practicum.department.qa.sergei_tsarik.utils;

import ru.yandex.practicum.department.qa.sergei_tsarik.domain.Client;
import ru.yandex.practicum.department.qa.sergei_tsarik.enums.CreditRating;
import ru.yandex.practicum.department.qa.sergei_tsarik.enums.IncomeSource;

public class Calculator {

    private static final double CREDIT_SUM_10M = 10.0;
    private static final double CREDIT_SUM_5M = 5.0;
    private static final double CREDIT_SUM_1M = 1.0;

    private static final double BASE_PERCENTAGE = 10.0;

    public static double getMaxSumForIncomeSourceAndCreditRating(Client client) {
        double maxCreditSum = CREDIT_SUM_10M;
        IncomeSource incomeSource = client.getIncomeSource();
        CreditRating creditRating = client.getCreditRating();
        if (incomeSource == IncomeSource.BUSINESS || creditRating == CreditRating.EXCELLENT || creditRating == CreditRating.GREAT) maxCreditSum = CREDIT_SUM_10M;
        if (incomeSource == IncomeSource.EMPLOYEE || creditRating == CreditRating.GOOD) maxCreditSum = CREDIT_SUM_5M;
        if (incomeSource == IncomeSource.PASSIVE || creditRating == CreditRating.FAIR) maxCreditSum = CREDIT_SUM_1M;
        return maxCreditSum;
    }

    public static double getMaxSumForIncomeAndMaturity(Client client) {
        return (double) client.getMaturity() * (client.getIncome() / 3.0);
    }

    public static double getAnnualPayment(Client client) {
        double percentageDouble = getAnnualPercentage(client) / 100.0;
        double maturityDouble = (double) client.getMaturity();
        return client.getAvailableSum() * ( 1.0 + maturityDouble * percentageDouble) / maturityDouble;
    }

    public static double getPurposePercentage(Client client) {
        switch(client.getPurpose()) {
            case MORTGAGE:
                return -2.0;
            case BUSINESS:
                return -0.5;
            case CAR:
                return 0;
            case CONSUMER:
                return 1.5;
        }
        throw new IllegalArgumentException("Purpose Percentage is not calculated.");
    }

    public static double getCreditRatingPercentage(Client client) {
        switch(client.getCreditRating()) {
            case FAIR:
                return 1.5;
            case GOOD:
                return 0;
            case GREAT:
                return -0.25;
            case EXCELLENT:
                return -0.75;
        }
        throw new IllegalArgumentException("Credit Rating Percentage is not calculated.");
    }

    public static double getIncomeSourcePercentage(Client client) {
        switch(client.getIncomeSource()) {
            case PASSIVE:
                return 0.5;
            case EMPLOYEE:
                return -0.25;
            case BUSINESS:
                return 0.25;
        }
        throw new IllegalArgumentException("Income Source Percentage is not calculated.");
    }

    public static double getLoanSumPercentage(Client client) {
        return - Math.log(client.getAvailableSum());
    }

    public static double getAnnualPercentage(Client client) {
        return BASE_PERCENTAGE + getPurposePercentage(client) + getCreditRatingPercentage(client) + getIncomeSourcePercentage(client) + getLoanSumPercentage(client);
    }
}
