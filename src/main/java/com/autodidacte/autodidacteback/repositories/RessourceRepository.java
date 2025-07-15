package com.autodidacte.autodidacteback.repositories;

import com.autodidacte.autodidacteback.entities.Cours;
import com.autodidacte.autodidacteback.entities.Lesson;
import com.autodidacte.autodidacteback.entities.Ressource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RessourceRepository extends JpaRepository<Ressource, String> {
    Ressource getById(String id);
    Ressource getByRscMatricule(String matricule);
    List<Ressource> getAllByRscType(String type);
    List<Ressource> findByRscNameContains(String motCle);
    List<Ressource> getAllByLesson(Lesson lesson);
    List<Ressource> getByLessonCours(Cours cours);

}
