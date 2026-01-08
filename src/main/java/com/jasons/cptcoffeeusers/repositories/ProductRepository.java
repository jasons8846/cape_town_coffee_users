package com.jasons.cptcoffeeusers.repositories;

import com.jasons.cptcoffeeusers.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    public List<ProductEntity> getProductsByCompanyCode(String companyCode);
    public ProductEntity getProductByCode(String code);
}