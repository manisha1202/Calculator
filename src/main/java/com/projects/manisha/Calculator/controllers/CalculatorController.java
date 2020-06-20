package com.projects.manisha.Calculator.controllers;

import com.projects.manisha.Calculator.models.Calculator;
import com.projects.manisha.Calculator.services.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @Autowired
    private CalculateService calculateService;

    @RequestMapping("/sum")
    public double getSum(@RequestBody Calculator calculator){
        return calculateService.parseExpression(calculator);
    }

}
