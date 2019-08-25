package com.platzi.javatests.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RomanNumerals {

//    enum RomanNumeral  {
//        M(1000),CM(900),D(500),CD(400),
//                C(100),XC(90),L(50),XL(40),
//                X(10),IX(9),V(5),IV(4),
//                I(1)
//    }

    public static String arabicToRoman(int n) {


        String operatorde5 = "V";
        String operatorde10 = "X";
        String operatorde50 = "L";

        int unidades = n%10;
        int decenas = n/10;

        String unidadesRoman="";
        String decenasRoman="";

        if(unidades<4)
        {
            unidadesRoman = getUnitsOfI(unidades);
        }
        else if (unidades <9)
        {
            unidadesRoman="V";
            if (unidades<5)
                unidadesRoman ="I"+unidadesRoman;
            else{
                unidadesRoman += getUnitsOfI(unidades-5);
            }
        }else unidadesRoman = "IX";

        if(decenas>0)
        {
            if(decenas<4)
            {
                decenasRoman = getUnitsOfX(decenas);
            }
            else if (decenas<9)
            {
                decenasRoman="L";
                if(decenas<5)
                    decenasRoman ="X"+decenasRoman;
                else
                {
                    decenasRoman += getUnitsOfX(decenas-5);
                }

            }
        }

     return decenasRoman + unidadesRoman;
    }

    public static String arabicToRomanFor(int number) {
        String value = "";
        String unitIteratorGreater="";
        String unitIteratorLess="";
        System.out.println("number = " + number);
        System.out.println("miles = " + (number % 1000));
        System.out.println("unidad de miles = " + (number / 1000));
        for (int miles = 0; miles <= (number / 1000); miles++) {
            int unitOfMiles = (number % 1000);
            System.out.println("miles = " + miles);
            System.out.println("unitOfMiles = " + unitOfMiles);
            for (int centenas = 0; centenas <= unitOfMiles / 100; centenas++) {
                int unitOfCent=unitOfMiles % 100;
                System.out.println("centenas = " + centenas);
                System.out.println("unitOfCent = " + unitOfCent);
                String unidadesRoman = "";
                for (int decenas = 0; decenas <= unitOfCent / 10; decenas++)
                {
                    int unidades = unitOfCent % 10;
                    System.out.println("decenas = " + decenas);
                    System.out.println("unidades de decena = " + unidades);
                    System.out.println("Variables V - I");

                    if(unidades<4)
                    {
                        unidadesRoman = getUnitsOfI(unidades);
                    }
                    else if (unidades <9)
                    {
                        unidadesRoman="V";
                        if (unidades<5)
                            unidadesRoman ="I"+unidadesRoman;
                        else{
                            unidadesRoman += getUnitsOfI(unidades-5);
                        }
                    }else unidadesRoman = "IX";

                }
                System.out.println("unidadesRoman = " + unidadesRoman);
            }
        }

        return "";
    }


    public static String arabicToRomanRecursive(int number) {
        if (number > 3999)
            return "Fail, 3999 is the maximun number allowed";

        List<String> unidades = Arrays.asList("unidades", "decenas",  "Centenas","Miles" );
//        "I", "V", "X", "L", "C", "M"
//        List<String[]> unidadesRomanos = Arrays.asList({"I", "V"}, {"X", "L"}, {"C", "L"} );
        int denominador = 10;
        int iter=0;
        while (true) {
            if (number < denominador)
                break;
            else
                denominador = denominador * 10;
            iter++;
        }


//        System.out.println("arabicToRomanRecursive(number,"+denominador+"); = " + arabicToRomanRecursive(number, denominador/10));

    return arabicToRomanRecursive(number, denominador/10);

//
    }
    public static String arabicToRomanRecursive(int number, int denominator) {

        if(number==0)
            return "";

        List<String> unidadesList = null;

        if(number<=10)  unidadesList = Arrays.asList( "I", "V", "X");
        else if (number<=100) unidadesList = Arrays.asList( "X", "L","C");
        else if (number<=1000) unidadesList = Arrays.asList( "C", "D", "M");
        else unidadesList = Arrays.asList( "M");

        String operadorResta = "I";
        if(denominator==10)
            operadorResta = "X";
        else if(denominator==100)
            operadorResta = "C";

        int unidades = number / denominator;
        int resto = number % denominator;

        String unidadesRoman = "";

        if((number ==denominator ) && (denominator>1))
            unidadesRoman = unidadesList.get(2);
        else
        {
            if(unidades<4)
            {
                unidadesRoman = getUnitsOf(unidades,unidadesList.get(0));
            }
            else if (unidades <9)
            {
                unidadesRoman=unidadesList.get(1);
                if (unidades<5)
                    unidadesRoman =operadorResta+unidadesRoman;
                else{
                    unidadesRoman += getUnitsOf(unidades-5, unidadesList.get(0));
                }
            }
            else
            {
                unidadesRoman = unidadesList.get(0)+unidadesList.get(2);
            }
        }

        if(denominator==1)
            return unidadesRoman;
        else
            return unidadesRoman + arabicToRomanRecursive(resto,denominator/10);

    }



    private static String getUnitsOfI(int iterations)
    {
       return getUnitsOf(iterations,"I");
    }
    private static String getUnitsOfX(int iterations)
    {
        return getUnitsOf(iterations,"X");
    }

    private static String getUnitsOfL(int iterations)
    {
        return getUnitsOf(iterations,"L");
    }




    private static String getUnitsOf(int iterations, String unitElement)
    {
        iterations = Math.min(iterations, 3);

        String elementalUnit = "";
        for (int i = 0; i < iterations; i++)
            elementalUnit += unitElement;

        return elementalUnit;
    }
}
