package com.spring_credit.start.repositories;

import com.spring_credit.start.models.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends JpaRepository<Credit,Long> {
}
