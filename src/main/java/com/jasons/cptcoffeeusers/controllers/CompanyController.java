package com.jasons.cptcoffeeusers.controllers;

import com.jasons.cptcoffeeusers.api.CompanyApi;
import com.jasons.cptcoffeeusers.entities.CompanyEntity;
import com.jasons.cptcoffeeusers.model.Company;
import com.jasons.cptcoffeeusers.model.GetAllCompaniesResponseWrapper;
import com.jasons.cptcoffeeusers.model.GetCompanyNameResponseWrapper;
import com.jasons.cptcoffeeusers.services.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

    @RestController
    public class CompanyController implements CompanyApi {

        @Autowired
        CompanyService companyService;

        private static final Logger log =
                LoggerFactory.getLogger(CompanyController.class);


        @Override
        public ResponseEntity<GetCompanyNameResponseWrapper> getCompanyName(String name, String xCorrelationId) {
            log.info("CorrletationId: " + xCorrelationId +   " || GET /v1/company by name initiated");
            Company company = new Company();
            Optional<CompanyEntity> entity = companyService.getCompanyByName(name);

            company.setName(entity.get().getName());
            company.setCode(entity.get().getCode());

            GetCompanyNameResponseWrapper wrapper = new GetCompanyNameResponseWrapper();
            wrapper.setData(company);
            wrapper.setError(null);

            log.info("CorrletationId: " + xCorrelationId +   " || GET /v1/company by name successfull");
            return ResponseEntity.status(HttpStatus.OK)
                    .body(wrapper);

        }


        @Override
        public ResponseEntity<GetAllCompaniesResponseWrapper> getAllCompanies(String xCorrelationId) {
            log.info("CorrletationId: " + xCorrelationId +   " || GET /v1/company initiated");
            List<Company> companies = new ArrayList<>();


            companyService.getAllCompanies().forEach(companyEntity -> {
                Company company = new Company();
                company.setName(companyEntity.getName());
                company.setCode(companyEntity.getCode());
                companies.add(company);
            });

            GetAllCompaniesResponseWrapper wrapper = new GetAllCompaniesResponseWrapper();

            wrapper.setData(companies);
            wrapper.setError(null);

            log.info("CorrletationId: " + xCorrelationId +   " || GET /v1/company by name successfull");

            return ResponseEntity.status(HttpStatus.OK)
                    .body(wrapper);
        }


}
