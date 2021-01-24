package com.metanit;

public class MathMethods {

    //Суммирование
    public int Sum(int a,int b) {
        return a + b;
    }
    //Вычитание
    public int Subt(int a,int b)
    {
        return a-b;
    }
   //Умножение
    public int Mult(int a, int b){
        return a*b;
    }
    // Деление
    public int Div (int a, int b){
        return a/b;
    }

    //Получение результата в зависиммости от операции
    public int Result (int a,int b, char c){
        switch (c)
        {
            case '+':
                return  Sum(a,b);
            case '-':
                return  Subt(a,b);
            case '*':
                return Mult(a,b);
            case'/':
                return Div(a,b);
        }
        return -1;
    }
    //Проверка является ли строка числом
    public boolean isNumeric(String strNum) {
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}


