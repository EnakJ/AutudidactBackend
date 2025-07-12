package com.autodidacte.autodidacteback.dtos;

import lombok.Data;

@Data
public class LessonDTO {
    private String id;
    private String lessonTitre;
    private String lessonMatricule;
    private Long lessonDuree;
    private String lessonType;
    private String lessonStatus;
}
