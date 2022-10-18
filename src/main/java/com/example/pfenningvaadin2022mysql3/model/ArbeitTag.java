package com.example.pfenningvaadin2022mysql3.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class ArbeitTag {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;


   @ManyToOne//(fetch = FetchType.LAZY)
    @NotNull
    @JsonIgnoreProperties({"arbeitTages"})
    //private Fahrer fahrerId;
private Fahrer fahrerName;


    private LocalDate arbeitbeginDate;

    private LocalTime arbeitbeginZeit;
    private LocalTime arbeitendeZeit;

    private int kilometer;

    private String fahrerbruch;
    private String unfall;
    private String pause;




    @OneToMany(mappedBy = "arbeitTagId")
    @Nullable
    //@JoinColumn(name="arbeit_tag_id")
    private List<Tour> touren;


    @Override
    public String toString() {
        return  ""+ id;
    }
}
