package org.example;

public class ComplexCalc {
    public double real;
    public double imag;

    public ComplexCalc(double r, double i){
        this.real = r;
        this.imag = i;
    }

    public static ComplexCalc add(ComplexCalc n1, ComplexCalc n2)
    {
        ComplexCalc temp = new ComplexCalc(0, 0);
        temp.real = n1.real + n2.real;
        temp.imag = n1.imag + n2.imag;
        return temp;
    }

    public static ComplexCalc multiply(ComplexCalc n1, ComplexCalc n2)
    {
        ComplexCalc temp = new ComplexCalc(0, 0);
        temp.real = n1.real*n2.real - n1.imag*n2.imag;
        temp.imag = n1.real*n2.imag + n1.imag*n2.real;
        return temp;
    }

    public static ComplexCalc divide(ComplexCalc n1, ComplexCalc n2)
    {
        ComplexCalc temp = new ComplexCalc(0, 0);
        double denominator = n2.real*n2.real + n2.imag*n2.imag;
        temp.real = (n1.real*n2.real + n1.imag*n2.imag) / denominator;
        temp.imag = (n1.imag*n2.real - n1.real*n2.imag) / denominator;
        return temp;
    }
}