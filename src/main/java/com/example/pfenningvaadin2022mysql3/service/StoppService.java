package com.example.pfenningvaadin2022mysql3.service;

import com.example.pfenningvaadin2022mysql3.model.Stopp;
import com.example.pfenningvaadin2022mysql3.repository.StoppRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoppService {



    private final StoppRepository stoppRepository;


    public List<Stopp> getAllStopp(String stopp) {
        return stoppRepository.findAll();
    }

    public List<Stopp> getAllStopps() {
        return stoppRepository.findAll();
    }

    public List<Stopp> getAllStopps(String stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return stoppRepository.findAll();
        } else {
            return stoppRepository.search(stringFilter);
        }
    }
    public Stopp getStoppById(long id) {
        return stoppRepository.findById(id).orElseThrow(); //OPTIONAL
    }



    public void addStopp(Stopp stopp) {
        if (stopp == null) {
            System.err.println("Stopp is null. Are you sure you have connected your form to the application?");
            return;
        }
        stoppRepository.save(stopp);

    }



    public void deleteStoppById(long id) {
        stoppRepository.deleteById(id);

    }

    public void deleteStopp(Stopp stopp) {
        stoppRepository.delete(stopp);

    }
}
