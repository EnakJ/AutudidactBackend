package com.autodidacte.autodidacteback.services;

import org.springframework.http.ResponseEntity;

public interface MatCounterService {
    String generateMatricule(String prefix);
}
