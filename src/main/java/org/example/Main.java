package org.example;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) { StringCalculator calculator = new StringCalculator();
        Scanner str = new Scanner(System.in);
        System.out.println("Enter your string: ");

        String equation = str.nextLine();
        System.out.println("Your string: " + equation);
        System.out.println("Your result: ");
        System.out.println(calculator.add(equation));
    }
}

class StringCalculator {
    public int add(String numbers){
        if (numbers.isEmpty()) {
            return 0;
        }

        if (numbers.contains(",\\n")) {
            System.out.println("Not correct input");
        } else if (numbers.contains("\\n,")) {
            System.out.println("Not correct input");
        } else {
            if (numbers.startsWith("//")) {
                int preDelimiterIndex = numbers.lastIndexOf("[") + 1;
                /*String newlineSymbol ="\\n";*/
                int pastDelimiterIndex = numbers.indexOf("]");
                String delimiter = numbers.substring(preDelimiterIndex, pastDelimiterIndex);
                String numbersSubstring = numbers.substring(pastDelimiterIndex + 3).replace(delimiter, ",");

                String[] ourNumbers = numbersSubstring.split("(,)|(\\\\n)");

                int sum = 0;

                List <Integer> negative = new ArrayList<>();
                for (String num : ourNumbers) {
                    int value = Integer.parseInt(num);
                    if (value < 0) {
                        negative.add(value);
                    }else if (value <= 1000){
                        sum += value;
                    }
                }

                if (!negative.isEmpty()) {
                    System.out.println("Negative numbers not allowed: " + negative);
                    return 0;
                }

                return sum;

            } else
            { String[] ourNumbers = numbers.split("(,)|(\\\\n)");
                int sum = 0;

                List <Integer> negative = new ArrayList<>();
                for (String num : ourNumbers) {
                    int value = Integer.parseInt(num);
                    if (value < 0) {
                        negative.add(value);
                    } else if (value <= 1000){
                        sum += value;
                    }
                }

                if (!negative.isEmpty()) {
                    System.out.println("Negative numbers not allowed: " + negative);
                    return 0;
                }

                return sum;
            }
        }
        return 0;
    }
}