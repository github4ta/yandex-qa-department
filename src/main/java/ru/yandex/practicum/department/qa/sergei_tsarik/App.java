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
    public static void main(String[] args) {
        Client client = new Client(Gender.MALE, 50, IncomeSource.BUSINESS, CreditRating.EXCELLENT, 10, 5, 3, Purpose.CONSUMER);

        try {
            client = Validation.getCheckedClientForCredit(client);

            System.out.println("Credit sum has been requested = " + client.getRequestedSum() + " M.");

            System.out.println("Credit is possible for:");
            System.out.println("Credit sum = " + client.getAvailableSum() + " M.");
            System.out.println("Credit percentage = " + Interest.getAnnualPercentage(client) + " %.");
            System.out.println("Credit annual payment  = " + Payment.getAnnualPayment(client) + " M.");
            System.out.println("Credit maturity " + client.getMaturity() + " years.");
        } catch (IllegalArgumentException e) {
            System.out.println("Credit is impossible.");
            System.out.println(e.getMessage());
        }
    }
}
