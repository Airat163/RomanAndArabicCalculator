package com.calculator;

import lombok.Getter;

@Getter
public enum MathSymbol {
    PLUS("+"),
    MINUS("-"),
    DIVIDE("/"),
    MULTIPLY("*");

    private final String symbol;

    MathSymbol(String symbol) {
        this.symbol = symbol;
    }
}
