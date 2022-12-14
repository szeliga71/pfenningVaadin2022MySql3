package com.example.pfenningvaadin2022mysql3.service;

import com.example.pfenningvaadin2022mysql3.model.Markt;
import com.example.pfenningvaadin2022mysql3.repository.MarktRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarktService {

    private final MarktRepository marktRepository;



    public List<Markt> getAllMarkt(String stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return marktRepository.findAll();
        } else {
            return marktRepository.search(stringFilter);
        }
    }

    public List<Markt> getAllMarkts() {
        return marktRepository.findAll();
    }

    public void addMarkt(Markt markt) {
        marktRepository.save(markt);
    }
    public void saveMarkt(Markt markt) {
        if (markt == null) {
            System.err.println("Contact is null. Are you sure you have connected your form to the application?");
            return;
        }
        marktRepository.save(markt);
    }

    public void deleteMarkt(Markt markt) {
        marktRepository.delete(markt);

    }
}
