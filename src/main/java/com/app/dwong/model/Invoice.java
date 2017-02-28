package com.app.dwong.model;

import com.app.dwong.api.resources.InvoiceResource;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by dwong on 2/28/17.
 */
@Document(collection = "Invoices")
public class Invoice {

    @Id
    String id;
    List<Product> products;
    Float total;
    int sequence;

    public Invoice(){}

    public Invoice(List<Product> products, Float total) {
        this.products = products;
        this.total = total;
    }

    public Invoice(InvoiceResource invoiceResource) {
        this.products = invoiceResource.getProducts();
        this.total = invoiceResource.getTotal();
        this.sequence = invoiceResource.getSequence();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
}
