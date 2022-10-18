package com.example.pfenningvaadin2022mysql3.controller;




import com.example.pfenningvaadin2022mysql3.model.Fahrer;
import com.example.pfenningvaadin2022mysql3.service.FahrerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pfenning2022")
public class FahrerController {

    private final FahrerService fahrerService;


   @GetMapping("")
    public List<Fahrer> getAllFahrer() {
        return fahrerService.getAllFahrer();
    }

   /* @GetMapping("fahrerByName/{name}")
    public Fahrer getFahrerByName(@PathVariable String name){
       return fahrerService.getFahrerByName(name);
    }*/

   /* @GetMapping("/name/{name}")
    public List<Fahrer> getFahrerByName(@PathVariable String name) {
        return fahrerService.getFahrerByName(name);
    }*/

   /* @GetMapping("{id}")
    public Fahrer getFahrerByIdPf(@PathVariable String name) {
        return fahrerService.getFahrerById(name);*/



/*@PostMapping("add")
    public Fahrer addFahrer(@RequestBody Fahrer fahrer){
       return fahrerService.addFahrer(fahrer);
    }*/


   /*@GetMapping("/id_pf/{id_pf}")
    public List<Fahrer> getFahrerByIdPf(@PathVariable String id_pf) {
        return fahrerService.getFahrerByIdPf(id_pf);

    }*/

   /* @DeleteMapping("deleteFahrer/{id}")
    public void deleteFahrerById(@PathVariable String id){
        fahrerService.deleteFahrerById(id);
    }*/

}
