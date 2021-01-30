package com.spring_credit.start.repositories;

import com.spring_credit.start.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    public String findByEmail(String email);
}
