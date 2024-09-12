package com.calculator;

public enum CalculatorImpl implements Calculator {
    DIVIDE {
        public int calculate(int num1, int num2) {
            return num1 / num2;
        }
    },
    MULTIPLY {
        public int calculate(int num1, int num2) {
            return num1 * num2;
        }
    },
    MINUS {
        public int calculate(int num1, int num2) {
            return num1 - num2;
        }
    },
    PLUS {
        public int calculate(int num1, int num2) {
            return num1 + num2;
        }
    };

    public abstract int calculate(int num1, int num2);
}
