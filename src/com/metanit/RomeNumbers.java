package com.metanit;

public class RomeNumbers {
    //Перечисление римских чисел
    enum RomanNumbers{
        M(1000),CM(900),D(500),CD(400),C(100),XC(90),L(50),XL(40),X(10),IX(9),V(5),IV(4),I(1);

        private int value;
        //Возвращение значение римского числа
        RomanNumbers(int value)
        {
            this.value = value;
        }

        public int getValue()
        {
            return value;
        }
    }

    //Получение из римского числа в арабское
    public int getRomanNumber(String s)
    {
        String romanNumber = s.toUpperCase();
        int result = 0;

        RomanNumbers[] numbers = RomanNumbers.values();
        int i=0;
        while((romanNumber.length()>0)&&(i<numbers.length))
        {
            RomanNumbers symbol = numbers[i];
            if(romanNumber.startsWith(symbol.name())){
                result += symbol.getValue();
                romanNumber = romanNumber.substring(symbol.name().length());
            } else{
                i++;
            }
        }

        return result;
    }

    //Получение из арабского в римское
    public String ArabickToRoman(int number)
    {
        RomanNumbers[] numbers = RomanNumbers.values();
        StringBuilder roman = new StringBuilder();
        int i =0;
        while ((number > 0) && (i<numbers.length))
        {
            if(numbers[i].getValue()<=number)
            {
                roman.append(numbers[i].toString());
                number-=numbers[i].getValue();
            }
            else
            {
                i++;
            }
        }
        return roman.toString();
    }

    //Проверка является ли число римским
    public boolean isRomeNumbers(String s) {
        try {
            int i = getRomanNumber(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
