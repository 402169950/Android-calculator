package com.tongliu.calculator.utils;

public class NumberUtils {
    /**
     * Check if given number is a number
     * @param ch the number to be checked
     * @return {@value true} is a number. {@value false} is not a number.
     */
    public static boolean isNumber(String ch){
        boolean isNumber = true;
        for(int i = 0;i < ch.length();i++){
            if(ch.charAt(i) < 0x30 || ch.charAt(i) > 0x39) {
                isNumber = !isNumber;
                break;
            }
        }
       return isNumber;
    }
}
