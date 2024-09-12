package com.calculator;

import com.calculator.convert_number.ConvertNumberImpl;

public class Parser {
    private static final Parser INSTANCE = new Parser();

    private Parser() {
    }

    public static Parser getInstance() {
        return INSTANCE;
    }

    public String[] parseStringAndReturnAnArrayOfNumbers(String input) {
        String[] strings = input.split(" ");
        boolean arabicNumerals = new Main().isArabicNumerals(input);
        if (arabicNumerals) {
            return new String[]{strings[0], strings[2]};
        }
        String[] strings1 = ConvertNumberImpl.getInstance().convertRomanNumberToArabicNumber(strings);
        return new String[]{strings1[0], strings1[1]};
    }
}
