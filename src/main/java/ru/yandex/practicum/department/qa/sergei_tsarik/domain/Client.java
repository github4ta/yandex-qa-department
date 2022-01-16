package ru.yandex.practicum.department.qa.sergei_tsarik.domain;

import ru.yandex.practicum.department.qa.sergei_tsarik.enums.*;

public class Client {
    private Gender gender;
    private int age;
    private IncomeSource incomeSource;
    private CreditRating creditRating;
    private double income;
    private double requestedSum;
    private int maturity;
    private Purpose purpose;
    private double availableSum;

    public Client(Gender gender, int age, IncomeSource incomeSource, CreditRating creditRating, double income,
                  double requestedSum, int maturity, Purpose purpose) {
        this.gender = gender;
        this.age = age;
        this.incomeSource = incomeSource;
        this.creditRating = creditRating;
        this.income = income;
        this.requestedSum = requestedSum;
        this.maturity = maturity;
        this.purpose = purpose;
        this.availableSum = requestedSum;
    }

    public void setAvailableSum(double availableSum) {
        this.availableSum = availableSum;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public IncomeSource getIncomeSource() {
        return incomeSource;
    }

    public CreditRating getCreditRating() {
        return creditRating;
    }

    public double getIncome() {
        return income;
    }

    public double getAvailableSum() {
        return availableSum;
    }

    public double getRequestedSum() {
        return requestedSum;
    }

    public int getMaturity() {
        return maturity;
    }

    public Purpose getPurpose() {
        return purpose;
    }
}
