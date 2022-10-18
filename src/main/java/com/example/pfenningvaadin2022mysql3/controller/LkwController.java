package com.example.pfenningvaadin2022mysql3.controller;

import com.example.pfenningvaadin2022mysql3.repository.LkwRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pfenning2022")
public class LkwController {

    private final LkwRepository lkwRepository;
}
