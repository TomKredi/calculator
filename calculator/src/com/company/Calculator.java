package com.company;


import java.util.Arrays;
import java.util.Scanner;
import com.company.Roman;

public class Calculator {

    public static void main(String[] args) {
        Scanner q = new Scanner(System.in);
        String input = q.nextLine();


        boolean isRoman = false;
        String[] operands = input.split(" ");
        String first = operands[0];
        String second = operands[2];
        String operator = String.valueOf(operands[1]);

        if ((Roman.isValidRoman(first) && Roman.isValidRoman(second))) {
            int transformedFirst = Roman.toArab(first);
            int transformedSecond = Roman.toArab(second);
            System.out.println("ОТВЕТ " + Roman.toRoman(Integer.parseInt(Calculator.Operation(transformedFirst, transformedSecond, operator))));


        } else if (Calculator.isValidArab(first) && Calculator.isValidArab(second)){
            int transformedFirst = Integer.parseInt(first);
            int transformedSecond = Integer.parseInt(second);
            System.out.println("ОТВЕТ " + Calculator.Operation(transformedFirst, transformedSecond, operator));
        } else {
            throw new RuntimeException("ВАШИ ДАННЫЕ НЕ ВАЛИДНЫ, КАЛКУЛЯТОР ПРИНИМАЕТ ЧИСЛО ОТ 1 ДО 10 или римское от I до X");
        }

    }

    private static String Operation(int transformedFirst, int transformedSecond, String operator) {
        String result = null;
        if (operator.equals("+")) {
            operator = "+";
            result = String.valueOf(transformedFirst + transformedSecond);
        }
        else if (operator.equals("-")) {
            operator = "-";
            result = String.valueOf(transformedFirst - transformedSecond); }

        else if (operator.equals("*")) {
            operator = "*";
            result = String.valueOf(transformedFirst * transformedSecond);}
        else if (operator.equals("/")) {
            operator = "/";
            result = String.valueOf(transformedFirst / transformedSecond);}
        return result;
    }

    private static boolean isValidArab(String number) {
        boolean isValid = false;
        try {
            if (Integer.parseInt(number) > 0 &&  Integer.parseInt(number) <= 10) {
                isValid = true;
            }
        } catch (Exception ex) {
            return false;
        }

        return isValid;
    }


}
