package com.jasons.cptcoffeeusers.controllers;

import com.jasons.cptcoffeeusers.api.ProductsApi;
import com.jasons.cptcoffeeusers.model.GetCpyProductResponseWrapper;
import com.jasons.cptcoffeeusers.model.Product;
import com.jasons.cptcoffeeusers.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController implements ProductsApi {

    @Autowired
    ProductService productService;

    private static final Logger log =
            LoggerFactory.getLogger(CompanyController.class);

    @Override
    public ResponseEntity<GetCpyProductResponseWrapper> retrieveCpyProducts(String companyCode, String xCorrelationId) {

        log.info("CorrletationId: " + xCorrelationId +   " || GET /v1/product by company code initiated");
        List<Product> products = new ArrayList<>();

        GetCpyProductResponseWrapper wrapper = new GetCpyProductResponseWrapper();

        wrapper.setData(productService.getCompanyProducts(companyCode));
        wrapper.setError(null);

        log.info("CorrletationId: " + xCorrelationId +   " || GET /v1/product by company code successful");
        return ResponseEntity.status(HttpStatus.OK)
                .body(wrapper);
    }
}
