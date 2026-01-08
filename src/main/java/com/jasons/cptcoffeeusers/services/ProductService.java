package com.jasons.cptcoffeeusers.services;


import com.jasons.cptcoffeeusers.model.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getCompanyProducts(String companyCode);

}