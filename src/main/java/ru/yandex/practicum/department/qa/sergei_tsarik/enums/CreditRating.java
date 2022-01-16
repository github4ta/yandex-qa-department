package ru.yandex.practicum.department.qa.sergei_tsarik.enums;

public enum CreditRating {
    POOR(-2),
    FAIR(-1),
    GOOD(0),
    GREAT(1),
    EXCELLENT(2);

    private final int value;

    private CreditRating(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
