package edu.uark.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionRestController {

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {

        return "Succesful test. (TransactionRestController)";
    }
}
