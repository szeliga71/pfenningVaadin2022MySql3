package com.example.pfenningvaadin2022mysql3.model;

import com.example.pfenningvaadin2022mysql3.vaadin.mobil.MArbeitTagForm;
import com.vaadin.flow.server.VaadinSession;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Tour {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalTime abfahrtlager;
    private LocalTime ankunftlager;

   /* @ManyToOne
    @JoinColumn(name="arbeit_tag.id")
    @NotNull
    @JsonIgnoreProperties({"touren"})
    private ArbeitTag arbeit_tag_id;*/
    @ManyToOne//(fetch=FetchType.LAZY)
    private ArbeitTag arbeitTagId;

    @ManyToOne//(fetch=FetchType.LAZY)
    //@JoinColumn(name = "lkw.kenz")
    @NotNull
    private Lkw lkwId;



   /*@JoinTable(name="lkw")
   @NotNull
   private String lkw_kenz;*/
    private int kilometer ;
    private int kilometerRewe;

    private String tourNr;

    /*@OneToMany(mappedBy="tour_id") //(cascade = CascadeType.REMOVE)
    //@JoinColumn(name="tour_id",updatable = false,insertable = false)
    private List<Stopp> stopps;*/
    @OneToMany(mappedBy="tourId")
    //@JoinColumn(name="tour_id")
    //@NotNull
    private List<Stopp> stopps;


    @Override
    public String toString() {
        return  tourNr; }



}


