package ru.yandex.practicum.department.qa.sergei_tsarik.domain;

public class Credit {

    public boolean isAvailable() {
        return isAvailable;
    }

    public double getSum() {
        return sum;
    }

    public double getInterest() {
        return interest;
    }

    public double getAnnualPayment() {
        return annualPayment;
    }

    public int getMaturity() {
        return maturity;
    }

    public String getMessage() {
        return message;
    }

    private boolean isAvailable;
    private double sum;
    private double interest;
    private double annualPayment;
    private int maturity;
    private String message;

    public Credit(boolean isAvailable, double sum, double interest, double annualPayment, int maturity, String message) {
        this.isAvailable = isAvailable;
        this.sum = sum;
        this.interest = interest;
        this.annualPayment = annualPayment;
        this.maturity = maturity;
        this.message = message;
    }

    public String toString() {
        if (isAvailable()) {
            return String.format("%s\nCredit sum : %.8f Millions rubles.\nCredit percentage : %.2f percents.\nCredit annual payment  : %.8f Millions rubles.\nCredit maturity : %s years.",
                    getMessage(), getSum(), getInterest(), getAnnualPayment(), getMaturity());
        } else {
            return getMessage();
        }
    }
}
