package org.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) { StringCalculator calculator = new StringCalculator();
        Scanner strIng = new Scanner(System.in);
        System.out.println("Enter your string: ");

        String equation = strIng.nextLine();
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

        String[] ourNumbers = numbers.split(",");
        int sum = 0;
        int size = ourNumbers.length;

        if (size < 3){
            for (String num : ourNumbers) {
                sum += Integer.parseInt(num);
            }
        }

        return sum;
    }
}