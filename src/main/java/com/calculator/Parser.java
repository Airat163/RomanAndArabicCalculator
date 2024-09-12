package com.calculator;

import com.calculator.convert_number.ConvertNumberImpl;

public class Parser {
    private static final Parser INSTANCE = new Parser();
    private final ConvertNumberImpl convertNumber = ConvertNumberImpl.getInstance();

    private Parser() {
    }

    public static Parser getInstance() {
        return INSTANCE;
    }

    public String[] parseStringAndReturnAnArrayOfNumbers(String input, boolean isArabicNumerals) {
        String[] values = input.split(" ");
        if (isArabicNumerals) {
            return new String[]{values[0], values[2]};
        } else {
            String[] arabicNumbers = convertNumber.convertRomanNumberToArabicNumber(values);
            return new String[]{arabicNumbers[0], arabicNumbers[1]};
        }
    }
}
