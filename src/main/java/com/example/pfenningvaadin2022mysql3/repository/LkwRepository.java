package com.example.pfenningvaadin2022mysql3.repository;


import com.example.pfenningvaadin2022mysql3.model.Lkw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LkwRepository extends JpaRepository<Lkw,Long> {

    @Query("select l from Lkw l " +
            "where lower(l.kenz) like lower(concat('%', :searchTerm, '%')) " )

            //"or lower(f.vorname) like lower(concat('%', :searchTerm, '%'))")
    List<Lkw> search(@Param("searchTerm") String searchTerm);
}

