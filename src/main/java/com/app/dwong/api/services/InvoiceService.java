package com.app.dwong.api.services;

import com.app.dwong.api.resources.InvoiceResource;
import com.app.dwong.model.Invoice;
import com.app.dwong.model.Product;
import com.app.dwong.repositories.InvoiceRepository;
import com.app.dwong.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

    ProductRepository productRepository;
    InvoiceRepository invoiceRepository;
    SequenceService sequenceService;


    @Autowired
    public InvoiceService(ProductRepository productRepository,
                          InvoiceRepository invoiceRepository,
                          SequenceService sequenceService) {
        this.productRepository = productRepository;
        this.invoiceRepository = invoiceRepository;
        this.sequenceService = sequenceService;
    }

    public Invoice createInvoice(InvoiceResource invoiceResource) {
        invoiceResource.getProducts().stream().forEach((product -> {
            Product persistedProduct =  productRepository.findOne(product.getId());
            persistedProduct.setQuantity(persistedProduct.getQuantity() - product.getQuantity());
            productRepository.save(persistedProduct);
        }));
        invoiceResource.setSequence(sequenceService.getNextSequence("invoice"));
        return invoiceRepository.save(new Invoice(invoiceResource));
    }

}
