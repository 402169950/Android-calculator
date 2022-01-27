package com.tongliu.calculator.logic;

import android.text.TextUtils;

import com.tongliu.calculator.logic.inf.CalculatorInf;
import com.tongliu.calculator.utils.NumberUtils;

public class CalculatorImpl implements CalculatorInf<String> {
    private StringBuilder operationSb;
    private String result;
    private boolean invalidOperation = false;
    private boolean hasCalculated = false;

    private CalculatorImpl() {
        operationSb = new StringBuilder();
    }

    private static CalculatorImpl mInstance;

    public static CalculatorImpl getInstance() {
        return mInstance = mInstance == null ? new CalculatorImpl() : mInstance;
    }

    @Override
    public void clear() {
        operationSb = new StringBuilder();
        hasCalculated = false;
        result = "";
    }

    @Override
    public void appendNumber(String number) {
        operationSb.append(number).append(' ');
    }

    @Override
    public void appendOperator(String opt) {
        operationSb.append(opt).append(' ');
    }

    @Override
    public void calculate() {
        try {
            String[] args = operationSb.toString().split(" ");

            if (args.length != 0) {
                //we first manually check the first 3 chars in the string.
                if (args.length == 1)
                    if (NumberUtils.isNumber(args[0]))
                        result = args[0];
                    else
                        throw new NumberFormatException("Not an Operator");
                else if (args.length == 2)
                    throw new NumberFormatException("Not an Operator");
                else if (!NumberUtils.isNumber(args[0]) || NumberUtils.isNumber(args[1]) || !NumberUtils.isNumber(args[2]))
                    throw new NumberFormatException("Not an Operator");
                else {
                    result = String.valueOf(calculate(args[0], args[1], args[2]));
                    if ((args.length - 1 - 2) % 2 != 0)
                        throw new NumberFormatException("Not an Operator");
                    for (int i = 3; i < args.length; i += 2) {
                        int rightNum = Integer.parseInt(args[i + 1]);
                        if (NumberUtils.isNumber(args[i]) || !NumberUtils.isNumber(args[i + 1]))
                            throw new NumberFormatException("Not an Operator");
                        result = String.valueOf(calculate(Integer.parseInt(result), args[i], rightNum));

                    }
                }
                invalidOperation = false;
            } else
                throw new NumberFormatException("Input cannot be empty");
        } catch (NumberFormatException e) {
            invalidOperation = true;
            result = e.getMessage();
        }
        operationSb.append(" = ").append(result);
        hasCalculated = true;
    }

    private Integer calculate(String left, String operator, String right) {

        int leftInt = Integer.parseInt(left);
        ;
        int rightInt = Integer.parseInt(right);
        return calculate(leftInt, operator, rightInt);
    }

    /**
     * Calculate the arithmetic expression
     * @param left the left-side number.
     * @param operator the operator.
     * @param right the right-side number.
     * @return
     */
    public static Integer calculate(int left, String operator, int right) {
        int result = 0;
        switch (operator) {
            case "+":
                result = left + right;
                break;
            case "-":
                result = left - right;
                break;
            case "*":
                result = left * right;
                break;
            case "/":
                result = left / right;
                break;
            case "%":
                result = left % right;
                break;
            case "POW":
                result = (int) Math.pow(left, right);
                break;
            case "MAX":
                result = Math.max(left, right);
                break;
            case "MIN":
                result = Math.min(left, right);
                break;
        }
        return result;
    }

    @Override
    public String getResult() {
        return result;
    }

    @Override
    public boolean hasError() {
        return invalidOperation;
    }

    @Override
    public boolean hasCalculated() {
        return hasCalculated;
    }

    @Override
    public String toString() {
        return operationSb.toString();
    }
}
