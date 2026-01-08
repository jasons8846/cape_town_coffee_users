package com.jasons.cptcoffeeusers.repositories;

import com.jasons.cptcoffeeusers.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {


    public List<CompanyEntity> getCompanyByNameContaining(String name);
    public CompanyEntity getCompanyByCode(String code);
}

