package com.calculator;

import com.calculator.convert_number.ConvertNumberImpl;

import java.util.Scanner;

public class Main {
    private final ConvertNumberImpl convertNumber = ConvertNumberImpl.getInstance();
    private final Parser parser = Parser.getInstance();


    //получить строку от пользователя из консоли
    public String enteringDataIntoTheConsole() {
        Scanner scanner = new Scanner(System.in);
        String inputData = scanner.nextLine();
        scanner.close();
        return inputData;
    }

    //преобразовать строку чисел в массив чисел
    private String[] getArrayOfNumbers(String inputData) {
        return parser.parseStringAndReturnAnArrayOfNumbers(inputData);
    }

    //проверить какой знак ввел пользователь
    private MathSymbol checkWhichCharacterTheUserEntered(String inputData) {
        //TODO создать Енам MathSymbol который будет содержать константы математеческих знаков
        // написать логику проверки знака и вернуть енам
        String[] strings = inputData.split(" ");
        MathSymbol[] values = MathSymbol.values();
        for (MathSymbol symbol : values) {
            if (symbol.getSymbol().equals(strings[1])) {
                return symbol;
            }
        }
        throw new IllegalArgumentException();
    }

    //проверить какие числа ввел пользователь римские или арабские
    public boolean isArabicNumerals(String inputData) {
        //TODO написать логику проверки строки, если это римские числа то вернуть true, иначе false;
        String[] strings = inputData.split(" ");
        return Character.isDigit((strings[0].charAt(0)));
    }

    //провести математическую операцию и вернуть результат для арабских чисел
    private String calculateArabicNumbers(String[] input, MathSymbol mathSymbol) {
        //TODO написать логику подсчета исходя из знака
        CalculatorImpl calculator1 = CalculatorImpl.valueOf(String.valueOf(mathSymbol));
        return String.valueOf(calculator1.mathOperation(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
    }

    //провести математическую операцию и вернуть результат для римских чисел
    private String calculateRomanNumbers(String[] input, MathSymbol mathSymbol) {
        //TODO сначала перевести их в арабские числа с помощью класса ConvertNumberImpl,
        // посчитать и перевести результат в римское число, также с помощью класса ConvertNumberImpl
        // и вернуть результат в виде строки.
        String[] arabic = convertNumber.convertRomanNumberToArabicNumber(input);
        String resultArabicNumber = calculateArabicNumbers(arabic, mathSymbol);
        return convertNumber.convertArabicNumberToRomanNumber(resultArabicNumber);
    }

    //TODO написать метод который будет вызывать по цепочке нужные методы и выдавать результат пользователю
    public String calc(String input) {
        String[] arrayOfNumbers = getArrayOfNumbers(input);
        String[] sp = input.split(" ");
        MathSymbol mathSymbol = checkWhichCharacterTheUserEntered(input);
        boolean arabicNumerals = isArabicNumerals(sp[0]);
        if (arabicNumerals) {
            return calculateArabicNumbers(arrayOfNumbers, mathSymbol);
        } else {
            return calculateRomanNumbers(arrayOfNumbers, mathSymbol);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        String input = main.enteringDataIntoTheConsole();
        String result = new Main().calc(input);
        System.out.println(result);
    }
}
