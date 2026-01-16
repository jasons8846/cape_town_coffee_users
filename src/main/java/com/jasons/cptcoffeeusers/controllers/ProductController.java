package com.jasons.cptcoffeeusers.controllers;

import com.jasons.cptcoffeeusers.api.ProductsApi;
import com.jasons.cptcoffeeusers.entities.ProductEntity;
import com.jasons.cptcoffeeusers.model.GetCpyProductResponse;
import com.jasons.cptcoffeeusers.model.GetCpyProductResponseWrapper;
import com.jasons.cptcoffeeusers.model.Product;
import com.jasons.cptcoffeeusers.model.ProductVariant;
import com.jasons.cptcoffeeusers.services.ProductService;
import com.jasons.cptcoffeeusers.supportfunctions.CursorCrypto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController implements ProductsApi {

    @Autowired
    ProductService productService;

    @Autowired
    CursorCrypto cursorCrypto;

    private static final Logger log =
            LoggerFactory.getLogger(CompanyController.class);

    @Override
    public ResponseEntity<GetCpyProductResponseWrapper> retrieveCpyProducts(String companyCode, Integer pageSize, String xCorrelationId, String cursor) {

        log.info("CorrletationId: " + xCorrelationId + " || GET /v1/product by company code initiated");

        Integer parseCursor = 0;

        if (cursor == null) {
            parseCursor = 0;
        } else {
            System.out.print("Decrypting");
            parseCursor = Integer.valueOf(cursorCrypto.decrypt(cursor));
        }


        List<ProductEntity> productEntities = productService.getCompanyProducts(companyCode, parseCursor, pageSize);

        GetCpyProductResponseWrapper wrapper = new GetCpyProductResponseWrapper();
        GetCpyProductResponse response = new GetCpyProductResponse();
        List<Product> products = new ArrayList<>();

        productEntities.forEach(productEntity -> {
            Product product = new Product();
            ProductVariant productVariant = new ProductVariant();

            productVariant.setDescription(productEntity.getProductVariant().getDescription());
            productVariant.setSequence(productEntity.getProductVariant().getSequence());

            product.setName(productEntity.getName());
            product.setCompanyCode(productEntity.getCompanyCode());
            product.setPrice(productEntity.getPrice());
            product.setCurrency(productEntity.getCurrency());
            product.setVariant(productVariant);
            product.setSequence(productEntity.getSequence());
            product.setCode(productEntity.getCode());

            products.add(product);
        });

        if (products.size() > pageSize) {

            response.setProducts(products
                    .stream()
                    .limit(products.size() - 1)
                    .collect(Collectors.toList()));
            response.setNextCursor(cursorCrypto.encrypt(String.valueOf(productEntities.get(productEntities.size() - 1).getId())));

        } else {
            response.setProducts(products
                    .stream()
                    .limit(products.size())
                    .collect(Collectors.toList()));
            response.setNextCursor(null);
        }


        wrapper.setData(response);
        wrapper.setError(null);

        log.info("CorrletationId: " + xCorrelationId + " || GET /v1/product by company code successful");
        return ResponseEntity.status(HttpStatus.OK)
                .body(wrapper);
    }
}
