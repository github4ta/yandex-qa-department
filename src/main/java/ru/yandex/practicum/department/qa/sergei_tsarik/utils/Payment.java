package ru.yandex.practicum.department.qa.sergei_tsarik.utils;

import ru.yandex.practicum.department.qa.sergei_tsarik.domain.Client;

public class Payment {

    public static double getAnnualPayment(Client client) {
        double percentageDouble = Interest.getAnnualPercentage(client) / 100.0;
        double maturityDouble = (double) client.getMaturity();
        return client.getLoan() * ( 1.0 + maturityDouble * percentageDouble) / maturityDouble;
    }
}
