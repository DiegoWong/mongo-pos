package com.app.dwong.repositories;

import com.app.dwong.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepository extends PagingAndSortingRepository<Product, String> {

    public List<Product> findByName(@Param("name")String name);
    public List<Product> findByDescriptionContaining(@Param("description")String description);

}
