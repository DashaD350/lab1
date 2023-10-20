package org.example;
import java.util.Scanner;

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
                int pastDelimiterIndex = numbers.indexOf("n");
                String delimiter = numbers.substring(2, pastDelimiterIndex-1);
                String numbersSubstring = numbers.substring(pastDelimiterIndex + 1).replace(delimiter, ",");

                String[] ourNumbers = numbersSubstring.split("(,)|(\\\\n)");

                int sum = 0;
                for (String num : ourNumbers) {
                    sum += Integer.parseInt(num);
                }

                return sum;

            } else
            { String[] ourNumbers = numbers.split("(,)|(\\\\n)");
                int sum = 0;

                for (String num : ourNumbers) {
                    sum += Integer.parseInt(num);
                }

                return sum;
            }
        }
        return 0;
    }
}