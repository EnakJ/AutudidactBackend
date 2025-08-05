package com.autodidacte.autodidacteback.repositories;

import com.autodidacte.autodidacteback.entities.Formation;
import com.autodidacte.autodidacteback.entities.Parcours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormationRepository extends JpaRepository<Formation, String> {
    Formation getFormationByFormId(String id);
    Formation getFormationByFormMatricule(String matricule);
    List<Formation> findAll();
    List<Formation> findByFormIntituleContains(String intitule);
    List<Formation> findAllByParcours(Parcours parcours);
}
