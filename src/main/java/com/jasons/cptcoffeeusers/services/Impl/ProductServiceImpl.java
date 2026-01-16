package com.jasons.cptcoffeeusers.services.Impl;

import com.jasons.cptcoffeeusers.entities.CompanyEntity;
import com.jasons.cptcoffeeusers.entities.ProductEntity;
import com.jasons.cptcoffeeusers.exceptions.NotFoundException;
import com.jasons.cptcoffeeusers.model.Product;
import com.jasons.cptcoffeeusers.repositories.CompanyRepository;
import com.jasons.cptcoffeeusers.repositories.ProductRepository;
import com.jasons.cptcoffeeusers.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    ProductRepository productRepository;

    @Autowired
    CompanyRepository companyRepository;

    private static final Logger log =
            LoggerFactory.getLogger(ProductServiceImpl.class);

    @Override
    public List<ProductEntity> getCompanyProducts(String companyCode, Integer cursor, Integer pageSize) {

        if(ValidateCompanyCode(companyCode) == false){
            log.warn("Get company products: Company code " + companyCode + " is not valid");
            throw new NotFoundException("Company code " + companyCode + " is not valid");
        }


        List<ProductEntity> productEntities = productRepository.getProductsByCompanyCode(companyCode, cursor, pageSize+1)
                .stream()
                .collect(Collectors.toList());

        if(productEntities == null){
            log.warn("Get company products: No products available for company code " + companyCode);
            throw new NotFoundException("No products available for company code " + companyCode);
        }

        return productEntities;
    }

    private boolean ValidateCompanyCode(String companyCode){
        CompanyEntity entity = companyRepository.getCompanyByCode(companyCode);

        if(entity == null || entity.getActive() == false){
            return false;
        }
        return true;
    };
}
