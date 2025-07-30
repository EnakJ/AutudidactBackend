package com.autodidacte.autodidacteback.services;

import com.autodidacte.autodidacteback.entities.MatriculeCounter;
import com.autodidacte.autodidacteback.repositories.MatCounterRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Year;

@Service @Transactional
public class MatCounterServiceImpl implements MatCounterService {
    private final MatCounterRepository matCounterRepository;

    public MatCounterServiceImpl(MatCounterRepository matCounterRepository) {
        this.matCounterRepository = matCounterRepository;
    }

    @Override
    public String generateMatricule(String prefix) {
        int year = Year.now().getValue();
        MatriculeCounter counter = matCounterRepository.findById(prefix)
                .orElseGet(() -> {
                   MatriculeCounter c = new MatriculeCounter();
                   c.setPrefix(prefix);
                   c.setLastNumber(0);

                   return c;
                });
        counter.setLastNumber(counter.getLastNumber() + 1);
        matCounterRepository.save(counter);
        return String.format("%s-%d-%04d", prefix, year, counter.getLastNumber());
    }
}
