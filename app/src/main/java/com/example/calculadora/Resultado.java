package com.example.calculadora;

public class Resultado {
    private int num1;
    private int num2;

    public Resultado(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public int sumar() {
        return num1 + num2;
    }

    public int restar() {
        return num1 - num2;
    }

    public int multiplicar() {
        return num1 * num2;
    }

    public int dividir() {
        if (num2 == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        return  num1 / num2;
    }
}
