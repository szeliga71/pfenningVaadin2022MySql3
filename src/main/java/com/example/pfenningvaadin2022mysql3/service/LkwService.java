package com.example.pfenningvaadin2022mysql3.service;

import com.example.pfenningvaadin2022mysql3.model.Lkw;
import com.example.pfenningvaadin2022mysql3.repository.LkwRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LkwService {


    private final LkwRepository lkwRepository;


    public List<Lkw> getAllLkw(String stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return lkwRepository.findAll();
        } else {
            return lkwRepository.search(stringFilter);
        }
    }

    public List<Lkw>findAllLkw(){
        return lkwRepository.findAll();
    }



    public void addLkw(Lkw lkw) {
        lkwRepository.save(lkw);
    }


    public void deleteLkw(Lkw lkw) {
        lkwRepository.delete(lkw);

    }
}
