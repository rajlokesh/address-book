package com.company.data.repository;

import com.company.data.entity.Association;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AssociationRepository extends CrudRepository<Association, Long> {
    List<Association> findByUserId(Long userId);

    List<Association> findByOrganizationId(long organizationId);

    Optional<Association> findByOrganizationIdAndUserId(long orgId, long userId);
}
