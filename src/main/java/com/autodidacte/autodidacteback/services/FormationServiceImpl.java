package com.autodidacte.autodidacteback.services;

import com.autodidacte.autodidacteback.entities.Formation;
import com.autodidacte.autodidacteback.entities.Parcours;
import com.autodidacte.autodidacteback.exceptions.FormationNotFoundExeption;
import com.autodidacte.autodidacteback.repositories.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service @Transactional
public class FormationServiceImpl implements FormationService {
    @Autowired
    private FormationRepository formationRepository;
    @Override
    public Formation getFormationById(String id) throws FormationNotFoundExeption {
        return formationRepository.getFormationById(id);
    }

    @Override
    public Formation getFormationByMatricule(String matricule) throws FormationNotFoundExeption {
        return formationRepository.getFormationByFormMatricule(matricule);
    }

    @Override
    public List<Formation> findFormationByMotCle(String motCle) throws FormationNotFoundExeption {
        return formationRepository.findByFormIntituleContains(motCle);
    }

    @Override
    public List<Formation> findAllFormation() {
        return formationRepository.findAll();
    }

    @Override
    public List<Formation> findFormationByParcours(Parcours parcours) {
        return formationRepository.findAllByParcours(parcours);
    }

    @Override
    public Formation saveFormation(Formation formation) {
        formation.setId(UUID.randomUUID().toString());
        return formationRepository.save(formation);
    }

    @Override
    public Formation updateFormation(Formation formation) {
        return formationRepository.save(formation);
    }

    @Override
    public void deleteFormation(String formationId) throws FormationNotFoundExeption {
        formationRepository.deleteById(formationId);
    }
}
