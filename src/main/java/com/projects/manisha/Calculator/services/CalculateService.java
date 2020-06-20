package com.projects.manisha.Calculator.services;

import com.projects.manisha.Calculator.models.Calculator;
import org.springframework.stereotype.Service;

import java.util.Stack;

@Service
public class CalculateService {

    private double calculate(String operator,double leftOperand,double rightOperand) throws ArithmeticException {
        double result;
        switch (operator)
        {
            case "+":
                result = leftOperand + rightOperand;
                break;
            case "-":
                result = leftOperand - rightOperand;
                break;
            case "*":
                result = leftOperand * rightOperand;
                break;
            case "/":
                if(rightOperand==0) throw new ArithmeticException();
                result = leftOperand / rightOperand;
                break;
            case "^":
                result = Math.pow(leftOperand,rightOperand);
                break;
            default:
                result = 0;

        }
        return result;
    }

    public double parseExpression(Calculator calculator) {
        String arr[]=calculator.getExpression().split(" ");
//        for(int i=0;i<arr.length;i++){
//            System.out.println(arr[i].toString());
//        }

        Stack<Double> numbers = new Stack<>();
        Stack<String> operator = new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(!isOperator(arr[i])){
                numbers.push(Double.parseDouble(arr[i]));
            }else{
                while(!operator.isEmpty() && hasPrecedence(arr[i],operator.peek())){
                    numbers.push(calculate(operator.pop(),numbers.pop(),numbers.pop()));
                }
                operator.push(arr[i]);
            }
        }
        while(!operator.isEmpty()){
            numbers.push(calculate(operator.pop(),numbers.pop(),numbers.pop()));
        }
        return numbers.pop();
    }

    private boolean hasPrecedence(String s, String peek) {
        if((s.equals("*") || s.equals("/") || s.equals("^")) && (peek.equals("+") || peek.equals("-"))){
            return false;
        }
        return true;
    }

    private boolean isOperator(String s) {
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("^")){
            return true;
        }
        return false;
    }
}
