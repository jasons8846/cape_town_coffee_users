package com.jasons.cptcoffeeusers.services.Impl;

import com.jasons.cptcoffeeusers.entities.CompanyEntity;
import com.jasons.cptcoffeeusers.exceptions.NotFoundException;
import com.jasons.cptcoffeeusers.repositories.CompanyRepository;
import com.jasons.cptcoffeeusers.services.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CompanyServiceImpl implements CompanyService {

    private static final Logger log =
            LoggerFactory.getLogger(CompanyServiceImpl.class);
    @Autowired
    CompanyRepository companyRepository;

    @Override
    public Optional<CompanyEntity> getCompanyByName(String name) {

        Optional<CompanyEntity> entity = companyRepository.getCompanyByNameContaining(name)
                .stream()
                .filter(e -> e.getActive() == true)
                .findFirst();


        if(entity.isEmpty()){
            log.warn("Get company by name: No company data is available for the request");
            throw new NotFoundException("No company data is available for the request");
        }

        return entity;
    }

    @Override
    public List<CompanyEntity> getAllCompanies() {
        List<CompanyEntity> entities  = companyRepository.findAll()
                .stream()
                .filter(e -> e.getActive() == true)
                .collect(Collectors.toList());

        if(entities.isEmpty()){
            log.warn("Get all companies: No company data is available for the request");
            throw new NotFoundException("No company data is available for the request");
        }else{
            return entities;
        }
    }


}
