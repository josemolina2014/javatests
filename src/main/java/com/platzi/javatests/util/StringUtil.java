package com.platzi.javatests.util;

public class StringUtil {

    public static String repeat(String str, int times)
    {
        if(times<0){
            throw new IllegalArgumentException("Negative times not allowed");
        }
        String result = "";
        for (int i = 0; i < times; i++) {
            result += str;
        }
        return result;
    }

    public static boolean isEmpty(String str)
    {
//        if(str==null)
//            return false;
//
//        if(str.trim().isEmpty())
//            return true;
//        else
//            return false;

        return str==null || (str.trim().isEmpty());
    }
}


