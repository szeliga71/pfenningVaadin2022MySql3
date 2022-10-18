package com.example.pfenningvaadin2022mysql3.service;

import com.example.pfenningvaadin2022mysql3.model.Fahrer;
import com.example.pfenningvaadin2022mysql3.repository.FahrerRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FahrerService {

    private final FahrerRepository fahrerRepository;

    public List<Fahrer> getAllFahrer() {
        return fahrerRepository.findAll();
    }

    public List<Fahrer> getFahrerByName(String name) {
        return fahrerRepository.findByName(name);
    }

    public List<Fahrer> getAllFahrers(String stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return fahrerRepository.findAll();
        } else {
            return fahrerRepository.search(stringFilter);
        }
    }





    public Fahrer getFahrerbyName1(String name) {
       return fahrerRepository.findByName1(name); //OPTIONAL
    }



    public void addFahrer(Fahrer fahrer) {
        if (fahrer == null) {
            System.err.println("Fahrer is null. Are you sure you have connected your form to the application?");
            return;
        }
        fahrerRepository.save(fahrer);

    }



   public void deleteFahrerById(String id) {
        fahrerRepository.deleteById(id);

    }

    public void deleteFahrer(Fahrer fahrer) {
        fahrerRepository.delete(fahrer);

    }
}
