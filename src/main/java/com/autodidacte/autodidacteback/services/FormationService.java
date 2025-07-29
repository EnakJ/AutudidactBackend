package com.autodidacte.autodidacteback.services;

import com.autodidacte.autodidacteback.entities.Formation;
import com.autodidacte.autodidacteback.entities.Parcours;
import com.autodidacte.autodidacteback.exceptions.FormationNotFoundExeption;

import java.util.List;

public interface FormationService {
    Formation getFormationById(String id) throws FormationNotFoundExeption;
    Formation getFormationByMatricule(String matricule) throws FormationNotFoundExeption;
    List<Formation> findFormationByMotCle(String motCle) throws FormationNotFoundExeption;
    List<Formation> findAllFormation();
    List<Formation> findFormationByParcours(Parcours parcours);
    Formation saveFormation(Formation formation);
    Formation updateFormation(Formation formation);
    void deleteFormation(String formationId) throws FormationNotFoundExeption;
}
