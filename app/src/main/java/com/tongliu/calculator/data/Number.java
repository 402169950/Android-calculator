package com.tongliu.calculator.data;

import java.util.ArrayList;
import java.util.List;

public class Number {
    private static Number mInstance;
    private List<Integer> numbers;
    private Number(){
        numbers = new ArrayList<>();
    }

    /**
     * Get the number {@link List<Integer>}.
     * @return the {@link List<Integer>} of number.
     */
    public List<Integer> getNumbers(){
        return this.numbers;
    }

    /**
     * Add a number to the number list to calculate.
     * @param number the number to be added.
     */
    public void addNumber(int number){
        numbers.add(number);
    }

    /**
     * Clear the number list.
     */
    public void clear(){
        numbers.clear();
    }

    /**
     * Get the singleton of Number entity.
     * @return the singletone of {@link Number}.
     */
    public static Number getInstance(){
        return mInstance = mInstance == null?new Number():mInstance;
    }


}
