package com.projects.manisha.Calculator.controllers;

import com.projects.manisha.Calculator.models.Calculator;
import com.projects.manisha.Calculator.services.AdvanceCalculateService;
import com.projects.manisha.Calculator.services.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    @Autowired
    private CalculateService calculateService;
    @Autowired
    private AdvanceCalculateService advanceCalculateService;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/basic")
    public double basicCalculator(@RequestBody Calculator calculator){
        return calculateService.parseExpression(calculator);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/advance")
    public double advanceCalculator(@RequestBody Calculator calculator){
        return advanceCalculateService.parseExpression(calculator);
    }
}
