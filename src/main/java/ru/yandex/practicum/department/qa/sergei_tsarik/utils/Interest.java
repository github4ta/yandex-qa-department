package ru.yandex.practicum.department.qa.sergei_tsarik.utils;

import ru.yandex.practicum.department.qa.sergei_tsarik.domain.Client;

public class Interest {

    private static final double BASE_PERCENTAGE = 10.0;

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
        return - Math.log(client.getLoan());
    }

    public static double getAnnualPercentage(Client client) {
        return BASE_PERCENTAGE + getPurposePercentage(client) + getCreditRatingPercentage(client) + getIncomeSourcePercentage(client) + getLoanSumPercentage(client);
    }
}
