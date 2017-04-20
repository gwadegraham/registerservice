package edu.uark.controllers;

import edu.uark.commands.transaction.TransactionSaveCommand;
import edu.uark.models.api.CreateTransaction;
import edu.uark.models.api.Transaction;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionRestController {

    @RequestMapping(value = "/apiv0", method = RequestMethod.PUT)
    public Transaction putTransaction(@RequestBody CreateTransaction createTransaction) {

        //TODO : create object
        return new TransactionSaveCommand().execute();
    }

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {

        return "Succesful test. (TransactionRestController)";
    }
}
