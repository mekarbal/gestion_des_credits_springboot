package com.spring_credit.start.repositories;

import com.spring_credit.start.models.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRespository extends JpaRepository<History,Long> {
}
