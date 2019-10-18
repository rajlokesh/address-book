package com.company.data.repository;

import com.company.data.entity.Organization;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrganizationRepository extends CrudRepository<Organization, Long> {

    List<Organization> findByName(String organizationName);
}
