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
public class Fahrer{

  //@Id
    //@GeneratedValue(strategy= GenerationType.IDENTITY)
  //private long id;
  @Id
    private String name;
    private String vorname;
    private String idPf;
    private String idRewe;
    private String sprache;



    @OneToMany(mappedBy="fahrerName")  //  (cascade = CascadeType.ALL)
    //@JoinColumn(name="arbeit_tag.fahrer_name",updatable = false,insertable = false)
    private List<ArbeitTag>arbeitTages;

    @Override
    public String toString() {
        return name ;
    }
}
