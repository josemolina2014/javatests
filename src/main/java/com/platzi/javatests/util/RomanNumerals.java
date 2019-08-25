package com.platzi.javatests.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RomanNumerals
{
    public static String arabicToRomanRecursive(int number) {
        if (number > 3999)
            return "Fail, 3999 is the maximun number allowed";

        int denominador = 10;
        int iter = 0;
        while (true) {
            if (number < denominador)
                break;
            else
                denominador = denominador * 10;
            iter++;
        }
        return arabicToRomanRecursive(number, denominador / 10);
    }

    private static String arabicToRomanRecursive(int number, int denominator)
    {
        if (number == 0)
            return "";

        List<String> unidadesList;

        if (number <= 10) unidadesList = Arrays.asList("I", "V", "X");
        else if (number <= 100) unidadesList = Arrays.asList("X", "L", "C");
        else if (number <= 1000) unidadesList = Arrays.asList("C", "D", "M");
        else unidadesList = Collections.singletonList("M");

        String operadorResta = "I";
        if (denominator == 10)
            operadorResta = "X";
        else if (denominator == 100)
            operadorResta = "C";

        int unidades = number / denominator;
        int resto = number % denominator;

        String unidadesRoman;

        if ((number == denominator) && (denominator > 1))
            unidadesRoman = unidadesList.get(2);
        else {
            if (unidades < 4) {
                unidadesRoman = getUnitsOf(unidades, unidadesList.get(0));
            } else if (unidades < 9) {
                unidadesRoman = unidadesList.get(1);
                if (unidades < 5)
                    unidadesRoman = operadorResta + unidadesRoman;
                else {
                    unidadesRoman += getUnitsOf(unidades - 5, unidadesList.get(0));
                }
            } else {
                unidadesRoman = unidadesList.get(0) + unidadesList.get(2);
            }
        }

        if (denominator == 1)
            return unidadesRoman;
        else
            return unidadesRoman + arabicToRomanRecursive(resto, denominator / 10);

    }

    private static String getUnitsOf(int iterations, String unitElement) {
        iterations = Math.min(iterations, 3);

        String elementalUnit = "";
        for (int i = 0; i < iterations; i++)
            elementalUnit += unitElement;

        return elementalUnit;
    }
}
