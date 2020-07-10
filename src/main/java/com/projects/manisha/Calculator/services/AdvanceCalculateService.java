package com.projects.manisha.Calculator.services;

import com.projects.manisha.Calculator.models.Calculator;
import org.springframework.stereotype.Service;

import java.util.Stack;

@Service
public class AdvanceCalculateService {
    public double parseExpression(Calculator calculator) {
        String arr[]=calculator.getExpression().trim().split(" ");
        if(!isOperator(arr[0])){
            return calculate(arr[1],Double.parseDouble(arr[0]));
        }
        return calculate(arr[0],Double.parseDouble(arr[1]));
    }

    private boolean isOperator(String s) {
        if(s.equals("!") || s.equals("lg") || s.equals("sqrt") || s.equals("pi")){
            return true;
        }
        return false;
    }

    private double calculate(String operator,double number) throws ArithmeticException {
        double result;
        switch (operator) {
            case "!":
                int fact=1;
                for(int i=1;i<=number;i++){
                    fact=fact*i;
                }
                result = fact;
                break;
            case "lg":
                result = Math.log(number);
                break;
            case "sqrt":
                result = Math.sqrt(number);
                break;
            case "pi":
                result = 3.14159265 * number;
                break;
            default:
                result = 0;
        }
        return result;
    }
}
