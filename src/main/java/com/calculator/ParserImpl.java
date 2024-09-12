package com.calculator;

import com.calculator.convert_number.ConvertNumberImpl;

public class ParserImpl implements Parser {
    private static final ParserImpl INSTANCE = new ParserImpl();
    private final ConvertNumberImpl convertNumber = ConvertNumberImpl.getInstance();

    private ParserImpl() {
    }

    public static ParserImpl getInstance() {
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
