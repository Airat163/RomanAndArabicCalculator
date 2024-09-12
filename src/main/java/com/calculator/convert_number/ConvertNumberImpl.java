package com.calculator.convert_number;

import com.calculator.RomanNumeral;

public class ConvertNumberImpl implements ConvertNumber {

    private static final ConvertNumberImpl INSTANCE = new ConvertNumberImpl();

    public static ConvertNumberImpl getInstance() {
        return INSTANCE;
    }

    private ConvertNumberImpl() {
    }


    public String convertArabicNumberToRomanNumber(String arabicNumber) {
        int num = Integer.parseInt(arabicNumber);
        StringBuilder builder = new StringBuilder();

        while (true) {

            if (num >= 100) {
                builder.append(RomanNumeral.C);
                num -= 100;
            }
            if (num >= 90) {
                builder.append(RomanNumeral.XC);
                num -= 90;
            }
            if (num >= 50) {
                builder.append(RomanNumeral.L);
                num -= 50;
            }
            if (num >= 40) {
                builder.append(RomanNumeral.XL);
                num -= 40;
            }

            if (num >= 10) {
                builder.append(RomanNumeral.X);
                num -= 10;
            }
            if (num < 10 && num > 0) {
                RomanNumeral[] values = RomanNumeral.values();
                RomanNumeral romanNumeral = null;
                for (RomanNumeral numeral : values) {
                    if (numeral.getArabicNumeral() == num) {
                        romanNumeral = numeral;
                    }
                }
                builder.append(romanNumeral);
                assert romanNumeral != null;
                num -= romanNumeral.getArabicNumeral();
            }
            if (num == 0) {
                return builder.toString();
            }
        }
    }

    public String[] convertRomanNumberToArabicNumber(String[] arrayValues) {
        RomanNumeral romNum = null;
        RomanNumeral romNum2 = null;
        RomanNumeral[] romanNumerals = RomanNumeral.values();
        for (RomanNumeral roman : romanNumerals) {
            if (romNum != null && romNum2 != null) {
                return new String[]{String.valueOf(romNum.getArabicNumeral()), String.valueOf(romNum2.getArabicNumeral())};
            }
            if (roman == RomanNumeral.valueOf(arrayValues[0])) {
                romNum = roman;
            }
            if (roman == RomanNumeral.valueOf(arrayValues[arrayValues.length - 1]) && romNum2 == null) {
                romNum2 = roman;
            }
        }
        throw new IllegalArgumentException();
    }
}
