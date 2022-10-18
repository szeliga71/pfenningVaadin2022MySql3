package com.example.pfenningvaadin2022mysql3.repository;

import com.example.pfenningvaadin2022mysql3.model.Markt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarktRepository extends JpaRepository<Markt,Long> {

    @Query("select m from Markt m " +
            "where lower(m.id) like lower(concat('%', :searchTerm, '%')) " )

    List<Markt> search(@Param("searchTerm") String searchTerm);
}
