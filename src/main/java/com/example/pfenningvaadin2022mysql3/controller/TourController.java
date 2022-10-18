package com.example.pfenningvaadin2022mysql3.controller;



import com.example.pfenningvaadin2022mysql3.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pfenning2022")
public class TourController {


    private final TourService tourService;

  /*  @GetMapping("tours")
    public List<Tour> findAllTours() {
        return tourService.findAllTours();
    }*/
}