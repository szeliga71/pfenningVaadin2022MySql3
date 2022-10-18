package com.example.pfenningvaadin2022mysql3.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Markt {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String nummer;
    private String adres;



    @Override
    public String toString() {
        return nummer ;
    }
}

