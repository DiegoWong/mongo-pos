package com.app.dwong.api.resources;

import com.app.dwong.model.Product;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class InvoiceResource {

    List<Product> products;
    int sequence;
    Float total;

    public InvoiceResource() {
    }

    @JsonCreator
    public InvoiceResource(@JsonProperty("products") List<Product> products,
                    @JsonProperty("total") Float total) {
        this.products = products;
        this.total = total;
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
