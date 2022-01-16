package ru.yandex.practicum.department.qa.sergei_tsarik.domain;

import ru.yandex.practicum.department.qa.sergei_tsarik.enums.*;
import ru.yandex.practicum.department.qa.sergei_tsarik.utils.Credit;
import ru.yandex.practicum.department.qa.sergei_tsarik.utils.Interest;
import ru.yandex.practicum.department.qa.sergei_tsarik.utils.Payment;

public class Client {
    private Gender gender;
    private int age;
    private IncomeSource incomeSource;
    private CreditRating creditRating;
    private double income;
    private double sum;
    private double loan;
    private int maturity;
    private Purpose purpose;
    private double annualPayment;
    private double percentage;

    public Client(Gender gender, int age, IncomeSource incomeSource, CreditRating creditRating, double income,
                  double sum, int maturity, Purpose purpose) {
        this.gender = gender;
        this.age = age;
        this.incomeSource = incomeSource;
        this.creditRating = creditRating;
        this.income = income;
        this.sum = sum;
        this.maturity = maturity;
        this.purpose = purpose;
        this.loan = sum;
        this.annualPayment = 0;
    }

    public void setLoan(double loan) {
        this.loan = loan;
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

    public double getLoan() {
        return loan;
    }

    public double getSum() {
        return sum;
    }

    public int getMaturity() {
        return maturity;
    }

    public Purpose getPurpose() {
        return purpose;
    }

    public double getPercentage() {
        return percentage;
    }
}
