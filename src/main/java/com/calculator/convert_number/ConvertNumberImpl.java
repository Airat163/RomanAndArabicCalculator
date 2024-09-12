package com.calculator.convert_number;

import com.calculator.Main;
import com.calculator.RomanNumeral;

public class ConvertNumberImpl {
    private RomanNumeral romanNumeral;

    private static final ConvertNumberImpl INSTANCE = new ConvertNumberImpl();

    public static ConvertNumberImpl getInstance() {
        return INSTANCE;
    }

    private ConvertNumberImpl() {
    }


    public String convertArabicNumberToRomanNumber(String arabicNumber) {
        //TODO написать логику преобразования числа из арабского в римское
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
                RomanNumeral romanNumeral1 = null;
                for (RomanNumeral numeral : values) {
                    if (numeral.getArabicNumeral() == num) {
                        romanNumeral1 = numeral;
                    }
                }

                builder.append(romanNumeral1);
                num -= romanNumeral1.getArabicNumeral();
            }
            if (num == 0) {
                return builder.toString();
            }
        }
    }

    public String[] convertRomanNumberToArabicNumber(String[] romanNumbers) {
        //TODO написать логику преобразования числа из римского в арабское
        RomanNumeral romanNumeral1 = null;
        RomanNumeral romanNumeral2 = null;
        RomanNumeral[] values = RomanNumeral.values();
        boolean arabicNumerals = new Main().isArabicNumerals(romanNumbers[0]);
        //TODO придумать что делать с римскими цифрами
        if (!arabicNumerals) {
            for (RomanNumeral numeral : values) {
                if (numeral == RomanNumeral.valueOf(romanNumbers[0]) && romanNumeral1 == null) {
                    romanNumeral1 = numeral;
                }
                if (numeral == RomanNumeral.valueOf(romanNumbers[romanNumbers.length - 1]) && romanNumeral2 == null) {
                    romanNumeral2 = numeral;
                }
            }
            return new String[]{String.valueOf(romanNumeral1.getArabicNumeral()), String.valueOf(romanNumeral2.getArabicNumeral())};
        }
        for (RomanNumeral numeral : values) {
            if (numeral.getArabicNumeral() == Integer.parseInt(romanNumbers[0])) {
                romanNumeral1 = numeral;
            }
            if (numeral.getArabicNumeral() == Integer.parseInt(romanNumbers[romanNumbers.length-1])) {
                romanNumeral2 = numeral;
            }
        }
        return new String[]{String.valueOf(romanNumeral1.getArabicNumeral()), String.valueOf(romanNumeral2.getArabicNumeral())};
    }
}
