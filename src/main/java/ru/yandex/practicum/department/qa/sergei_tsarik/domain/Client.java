package ru.yandex.practicum.department.qa.sergei_tsarik.domain;

import ru.yandex.practicum.department.qa.sergei_tsarik.enums.*;
import ru.yandex.practicum.department.qa.sergei_tsarik.utils.Interest;
import ru.yandex.practicum.department.qa.sergei_tsarik.utils.Payment;
import ru.yandex.practicum.department.qa.sergei_tsarik.utils.Validation;

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

    public boolean isAgeEligible() {
        return Validation.isAgeEligible(this);
/*        int personAge = age;
        switch (gender) {
            case MALE:
                if (personAge <= RetirementAge.BY_2022_MALE.getValue()) return true;
            case FEMALE:
                if (personAge <= RetirementAge.BY_2022_FEMALE.getValue()) return true;
        }
        return false;*/
    }

    public double getPercentage() {
        return percentage;
    }

    public boolean isIncomeSourceEligible() {
        return Validation.isIncomeSourceEligible(this);
/*
        if (incomeSource != IncomeSource.UNEMPLOYED) return true;
        return false;
*/
    }

    public boolean isCreditRatingEligible() {
        return Validation.isCreditRatingEligible(this);
/*
        if (creditRating != CreditRating.POOR) return true;
        return false;
*/
    }

    public boolean doesIncomeCoverLoan() {
        return loan <= getMaxCreditSumAccordingToIncomeAndMaturity();
    }

    public boolean doesIncomeCoverAnnualPayment() {
        return annualPayment <= income / 2.0;
    }

    public double getMaxCreditSumAccordingToIncomeAndMaturity() {
        return (double) maturity * (income / 3.0);
    }

    public double getMaxCreditSumAccordingToIncomeSourceAndCreditRating() {
        double maxCreditSum = 10.0;
        if (incomeSource == IncomeSource.BUSINESS || creditRating == CreditRating.EXCELLENT || creditRating == CreditRating.GREAT) maxCreditSum = 10;
        if (incomeSource == IncomeSource.EMPLOYEE || creditRating == CreditRating.GOOD) maxCreditSum = 5.0;
        if (incomeSource == IncomeSource.PASSIVE || creditRating == CreditRating.FAIR) maxCreditSum = 1.0;
        return maxCreditSum;
    }

    public double getAnnualPayment() {
        return annualPayment;
    }

    public void calculateAnnualPayment() {
        percentage = Interest.getAnnualPercentage(this);
/*
        double percentageDouble = percentage / 100.0;
        annualPayment = loan * ( 1.0 + (double) maturity * percentageDouble) / (double) maturity;
*/
        annualPayment = Payment.getAnnualPayment(this);
    }

    public double getPurposePercentage() {
        return Interest.getPurposePercentage(this);
/*        switch(purpose) {
            case MORTGAGE:
                return -2.0;
            case BUSINESS:
                return -0.5;
            case CAR:
                return 0;
            case CONSUMER:
                return 1.5;
        }
        throw new IllegalArgumentException("");*/
    }

    public double getCreditRatingPercentage() {
        return Interest.getCreditRatingPercentage(this);
/*
        switch(creditRating) {
            case FAIR:
                return 1.5;
            case GOOD:
                return 0;
            case GREAT:
                return -0.25;
            case EXCELLENT:
                return -0.75;
        }
        throw new IllegalArgumentException("");
*/
    }

    public double getIncomeSourcePercentage() {
        return Interest.getIncomeSourcePercentage(this);
/*        switch(incomeSource) {
            case PASSIVE:
                return 0.5;
            case EMPLOYEE:
                return -0.25;
            case BUSINESS:
                return 0.25;
        }
        throw new IllegalArgumentException("");*/
    }

    public double getLoanSumPercentage() {
        return Interest.getLoanSumPercentage(this);
//        return - Math.log(loan);
    }
}
