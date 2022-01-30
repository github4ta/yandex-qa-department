package ru.yandex.practicum.department.qa.sergei_tsarik;

import ru.yandex.practicum.department.qa.sergei_tsarik.domain.Client;
import ru.yandex.practicum.department.qa.sergei_tsarik.domain.Credit;
import ru.yandex.practicum.department.qa.sergei_tsarik.enums.CreditRating;
import ru.yandex.practicum.department.qa.sergei_tsarik.enums.Gender;
import ru.yandex.practicum.department.qa.sergei_tsarik.enums.IncomeSource;
import ru.yandex.practicum.department.qa.sergei_tsarik.enums.Purpose;

public class App {
    public static void main(String[] args) {
        Client client = new Client(Gender.MALE, 50, IncomeSource.BUSINESS, CreditRating.EXCELLENT, 10, 5, 3, Purpose.CONSUMER);
        System.out.println("Credit sum has been requested = " + client.getRequestedSum() + " Millions rubles.");

        Bank bank = new Bank();
        Credit credit = bank.applyForCredit(client);
        System.out.println(credit.toString());
    }
}
