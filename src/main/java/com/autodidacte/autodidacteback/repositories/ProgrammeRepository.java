package com.autodidacte.autodidacteback.repositories;

import com.autodidacte.autodidacteback.entities.Programme;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProgrammeRepository extends JpaRepository<Programme, String> {
    Optional<Programme> findById(String id);
    Programme findByProgMatricule(String matricule);
    List<Programme> findAll();
    List<Programme> findByProgIntituleContains(String motCle);
}
