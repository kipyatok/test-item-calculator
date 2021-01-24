package com.metanit;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String lineValue;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку:");
        lineValue = scanner.nextLine();
        if (lineValue == "")
        {
            try{
                throw new IllegalArgumentException();
            } catch (NumberFormatException e)
            {
                System.out.println("Пустая строка");
            }
        }
        ParsingString(lineValue);
    }

    //Разбор строки и получение результата
    private static void ParsingString(String s){
        char[] allSing = {'+','-','*','/'};
        MathMethods math = new MathMethods();
        String sing="";
        int firstNumber=0;
        int twoNumber=0;
        int result=0;
        boolean arabick=false;
        RomeNumbers rNumber = new RomeNumbers();
        for(int i=0;i<allSing.length;i++)
        {
            sing = String.valueOf(allSing[i]);
            //Проверка есть ли математическая операция в строке
            if (s.contains(sing)) {
                String s1= s.substring(0,s.indexOf(sing));
                String s2 = s.substring(s.indexOf(sing)+1);
                // Проверка являются ли переменные числами
                if (math.isNumeric(s1) && math.isNumeric(s2)) {
                    firstNumber = Integer.parseInt(s1);
                    twoNumber = Integer.parseInt(s2);
                    arabick = true;
                    break;
                }
                else
                    //Проверка являются ли переменные римскими числами
                    if (rNumber.isRomeNumbers(s1) && rNumber.isRomeNumbers(s2)){
                        firstNumber = rNumber.getRomanNumber(s1);
                        twoNumber = rNumber.getRomanNumber(s2);
                        break;
                    }
                else
                    throw new IllegalArgumentException();

            }
        }
        //Проверка условии задачи
        if ((firstNumber>10 || firstNumber<1)||(twoNumber>10 || twoNumber<1))
            throw new IllegalArgumentException();
        else {
            result = math.Result(firstNumber, twoNumber, sing.charAt(0));
            if (arabick) {
                System.out.println(result);
            } else {
                System.out.println(rNumber.ArabickToRoman(result));
            }
        }

    }

}
