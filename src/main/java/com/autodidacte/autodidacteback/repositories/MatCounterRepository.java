package com.autodidacte.autodidacteback.repositories;

import com.autodidacte.autodidacteback.entities.MatriculeCounter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatCounterRepository extends JpaRepository<MatriculeCounter, String> {
}
