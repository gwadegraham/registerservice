package edu.uark.models.api;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by pedro on 4/18/17.
 */
public class CreateTransaction {

    private String cashierId;
    public String getCashierId() {

        return cashierId;
    }
    public CreateTransaction(String cashierId) {

        this.cashierId = cashierId;
    }

    public CreateTransaction() {

        cashierId = StringUtils.EMPTY;
    }
}
