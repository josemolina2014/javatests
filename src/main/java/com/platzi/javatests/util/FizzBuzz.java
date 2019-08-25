package com.platzi.javatests.util;

public class FizzBuzz {

    public static String fizzBuzz(int n)
    {
        /*
            Si el número es divisible por 3, retorna “Fizz”
            Si el número es divisible por 5, retorna “Buzz”
            Si el número es divisible por 3 y por 5, retorna “FizzBuzz”
            En otro caso, retorna el mismo número
         */
        String toReturnValue = "";

        if(((n % 3) == 0) && ((n % 5) == 0))  toReturnValue="FizzBuzz";
        else if(n % 3 == 0 ) toReturnValue = "Fizz";
        else if (n%5 == 0)  toReturnValue="Buzz";
        else toReturnValue = String.valueOf(n);

        return toReturnValue;
    }

}
