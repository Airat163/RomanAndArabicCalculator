package com.calculator;

import com.calculator.convert_number.ConvertNumberImpl;

import java.util.Scanner;

public class Main {
    private static final ConvertNumberImpl CONVERT_NUMBER = ConvertNumberImpl.getInstance();
    private static final Parser PARSER = Parser.getInstance();


    //получить строку от пользователя из консоли
    public String enteringDataIntoTheConsole() {
        try (Scanner scanner = new Scanner(System.in)) {
            return scanner.nextLine();
        }
    }

    //достать из строки 2 числа и положить в массив
    private static String[] getArrayOfNumbers(String input, boolean isArabicNumerals) {
        return PARSER.parseStringAndReturnAnArrayOfNumbers(input, isArabicNumerals);
    }

    //проверить какой знак ввел пользователь
    private static MathSymbol checkWhichCharacterTheUserEntered(String input) {
        String[] inputSymbols = input.split(" ");
        MathSymbol[] mathSymbols = MathSymbol.values();
        for (MathSymbol symbol : mathSymbols) {
            if (symbol.getSymbol().equals(inputSymbols[1])) {
                return symbol;
            }
        }
        throw new IllegalArgumentException();
    }

    //проверить какие числа ввел пользователь римские или арабские
    public static boolean isArabicNumerals(String inputData) {
        String[] strings = inputData.split(" ");
        return Character.isDigit((strings[0].charAt(0)));
    }

    //провести математическую операцию и вернуть результат в зависимости от системы счисления
    private static String calculateNumbers(String[] values, MathSymbol mathSymbol, boolean isArabicNumbers) {
        CalculatorImpl calculator = CalculatorImpl.valueOf(String.valueOf(mathSymbol));
        String resultArabicNumber = String.valueOf(calculator.mathOperation(Integer.parseInt(values[0]), Integer.parseInt(values[1])));
        if (!isArabicNumbers) {
            return CONVERT_NUMBER.convertArabicNumberToRomanNumber(resultArabicNumber);
        }
        return resultArabicNumber;
    }
    public static String calc(String input) {
        String[] inputValues = input.split(" ");
        boolean isArabicNumerals = isArabicNumerals(inputValues[0]);
        String[] arrayOfNumbers = getArrayOfNumbers(input, isArabicNumerals);
        MathSymbol mathSymbol = checkWhichCharacterTheUserEntered(input);
        return calculateNumbers(arrayOfNumbers, mathSymbol, isArabicNumerals);
    }

    public static void main(String[] args) {
        String input = new Main().enteringDataIntoTheConsole();
        System.out.println(calc(input));
    }
}
