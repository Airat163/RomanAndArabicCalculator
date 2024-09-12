package com.calculator;

public enum CalculatorImpl implements Calculator {
    DIVIDE {
        public int mathOperation(int num1, int num2) {
            return num1 / num2;
        }
    },
    MULTIPLY {
        public int mathOperation(int num1, int num2) {
            return num1 * num2;
        }
    },
    MINUS {
        public int mathOperation(int num1, int num2) {
            return num1 - num2;
        }
    },
    PLUS {
        public int mathOperation(int num1, int num2) {
            return num1 + num2;
        }
    };

    public abstract int mathOperation(int num1, int num2);
}
