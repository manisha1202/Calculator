package com.projects.manisha.Calculator.models;

public class Calculator {

    private String expression;

    public Calculator() {

    }

    public Calculator(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
