package com.jasons.cptcoffeeusers.services;


import com.jasons.cptcoffeeusers.entities.ProductEntity;
import com.jasons.cptcoffeeusers.model.Product;

import java.util.List;

public interface ProductService {

    public List<ProductEntity> getCompanyProducts(String companyCode, Integer cursor, Integer pageSize);

}