package com.learning.command;

import com.learning.command.fx.Command;

public class AddCostomerCommand implements Command {
    private CustomerService customer_service;

    public AddCostomerCommand(CustomerService customer_service) {
        this.customer_service = customer_service;
    }
    @Override
    public void execute() {
    customer_service.addCustomer();
    }
}
