package com.capgemini.wsb.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.wsb.persistence.entity.VisitEntity;

@Repository
public interface VisitRepository extends JpaRepository<VisitEntity, Long> {

}
