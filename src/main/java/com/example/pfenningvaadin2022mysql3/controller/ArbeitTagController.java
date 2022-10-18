package com.example.pfenningvaadin2022mysql3.controller;



import com.example.pfenningvaadin2022mysql3.model.ArbeitTag;
import com.example.pfenningvaadin2022mysql3.service.ArbeitTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pfenning2022")
public class ArbeitTagController {

    //private final ArbeitTagService arbeitTagService;

    /*@GetMapping("/arbeitTag")
    public List<ArbeitTag>getAllArbeitTages(){
        return arbeitTagService.getAllArbeitTages();
    }*/


   /* @GetMapping("arbeitTages")
    public List<ArbeitTag>getAllArbeitTages(){
        return arbeitTagService.findAllArbeitTages();
    }*/

    // @GetMapping("fahrerName")
    //public List<Fahrer>fFF(){
    // return arbeitTagService.fFF();

   /* @GetMapping("arbeitTagById/{id}")
    public ArbeitTag getAllArbeitTagById(@PathVariable long id) {
        return arbeitTagService.getArbeitTagById(id);


    }*/
}



