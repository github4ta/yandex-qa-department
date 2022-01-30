package ru.yandex.practicum.department.qa.sergei_tsarik.enums;

public enum RetirementAge {
    BY_2022_FEMALE(58),
    BY_2022_MALE(63);

    private final int value;

    private RetirementAge(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
