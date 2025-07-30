package com.autodidacte.autodidacteback.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity @Data
public class MatriculeCounter {
    @Id
    private String prefix;
    private int lastNumber;
}
