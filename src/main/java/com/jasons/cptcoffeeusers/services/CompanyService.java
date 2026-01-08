package com.jasons.cptcoffeeusers.services;


import com.jasons.cptcoffeeusers.entities.CompanyEntity;

import java.util.List;
import java.util.Optional;

public interface CompanyService {

    public Optional<CompanyEntity> getCompanyByName(String name);
    public List<CompanyEntity> getAllCompanies();
}