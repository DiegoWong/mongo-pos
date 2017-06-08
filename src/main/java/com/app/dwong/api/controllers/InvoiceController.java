package com.app.dwong.api.controllers;

import com.app.dwong.api.services.InvoiceService;
import com.app.dwong.api.resources.InvoiceResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dwong on 2/28/17.
 */
@RepositoryRestController
public class InvoiceController {

    InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @RequestMapping(value = "/invoices", method = RequestMethod.POST)
    public String createInvoice(@RequestBody InvoiceResource invoiceResource) {
        invoiceService.createInvoice(invoiceResource);
        return "created successfully";
    }
}
