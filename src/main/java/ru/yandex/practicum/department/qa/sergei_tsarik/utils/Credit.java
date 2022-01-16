package ru.yandex.practicum.department.qa.sergei_tsarik.utils;

import ru.yandex.practicum.department.qa.sergei_tsarik.domain.Client;
import ru.yandex.practicum.department.qa.sergei_tsarik.enums.CreditRating;
import ru.yandex.practicum.department.qa.sergei_tsarik.enums.IncomeSource;

public class Credit {

    private static final double CREDIT_SUM_10M = 10.0;
    private static final double CREDIT_SUM_5M = 5.0;
    private static final double CREDIT_SUM_1M = 1.0;

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

}
