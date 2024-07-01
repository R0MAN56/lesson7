package org.example.impl;

import org.example.ComplexCalc;

import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
public class Controller extends ComplexCalc {
    public Controller(double r, double i) {
        super(r, i);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите первое комплексное число (действительную и мнимую части через пробел): ");
        double real1 = sc.nextDouble();
        double imag1 = sc.nextDouble();
        ComplexCalc c1 = new ComplexCalc(real1, imag1);

        System.out.print("Введите второе комплексное число (действительную и мнимую части через пробел): ");
        double real2 = sc.nextDouble();
        double imag2 = sc.nextDouble();
        ComplexCalc c2 = new ComplexCalc(real2, imag2);

        System.out.println("1. Сумма");
        System.out.println("2. Произведение");
        System.out.println("3. Частное");
        System.out.print("Введите свой выбор: ");
        int choice = sc.nextInt();

        Logger logger = Logger.getLogger("CalculatorLog");
        FileHandler fh;
        try {
            fh = new FileHandler("calculator.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (Exception e) {
            e.printStackTrace();
        }

        switch (choice)
        {
            case 1:
                ComplexCalc sum = ComplexCalc.add(c1, c2);
                String logMessage = String.format("Сумма: %.2f + %.2fi");
                logger.info(logMessage);
                System.out.println(logMessage);
                break;

            case 2:
                ComplexCalc product = ComplexCalc.multiply(c1, c2);
                logMessage = String.format("Произведение: %.2f + %.2fi");
                logger.info(logMessage);
                System.out.println(logMessage);
                break;

            case 3:
                ComplexCalc quotient = ComplexCalc.divide(c1, c2);
                logMessage = String.format("Частное: %.2f + %.2fi");
                logger.info(logMessage);
                System.out.println(logMessage);
                break;

            default:
                System.out.println("Неверный выбор");
        }
    }
}