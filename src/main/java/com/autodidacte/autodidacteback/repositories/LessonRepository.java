package com.autodidacte.autodidacteback.repositories;

import com.autodidacte.autodidacteback.entities.Formation;
import com.autodidacte.autodidacteback.entities.Lesson;
import com.autodidacte.autodidacteback.entities.Parcours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LessonRepository extends JpaRepository<Lesson, String> {
    Lesson getById(String id);
    List<Lesson> findAll();
    List<Lesson> findByLessonTitreContains(String titre);
    Lesson getByLessonMatricule(String matricule);
    List<Lesson> findAllByFormation(Formation formation);
    List<Lesson> findAllByFormation_Parcours(Parcours parcours);
}
