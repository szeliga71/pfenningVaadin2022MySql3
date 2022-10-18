package com.example.pfenningvaadin2022mysql3.repository;

import com.example.pfenningvaadin2022mysql3.model.ArbeitTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ArebeitTagRepository extends JpaRepository<ArbeitTag,Long> {
    @Query("select a from ArbeitTag a " +
            "where lower (a.fahrerName)  like lower(concat('%', :name, '%')) and  (a.arbeitbeginDate between :dateStart  and :dateStop)")

    List<ArbeitTag> betweName(@Param("dateStart") LocalDate dateStart,@Param("dateStop")LocalDate dateStop,@Param("name")String name );


    @Query("select a from ArbeitTag a " +
            "where a.arbeitbeginDate between :dateStart  and :dateStop")
    List<ArbeitTag> betwe(@Param("dateStart") LocalDate dateStart,@Param("dateStop")LocalDate dateStop);

   @Query("select a from ArbeitTag a  where a.arbeitbeginDate > :date ")
   List <ArbeitTag> findArbeitTagesByDate(@Param("date")LocalDate date);


    @Query("select a from ArbeitTag a " +
            "where lower(a.arbeitbeginDate) like lower(concat('%', :dateStart, '%'))")

    List<ArbeitTag> search(@Param("dateStart") String dateStart);//,@Param("dateStop") String dateStop);








    @Query("select a from ArbeitTag a " +
            //"where a.fahrer_name = :name")
            "where lower (a.fahrerName)  like lower(concat('%', :name, '%'))")

    List<ArbeitTag> searchName(@Param("name")String name );

@Query("select id from ArbeitTag  ")
   List <Long> getAllIds();

@Query("select a from ArbeitTag a where  a.id=(select max(id) from ArbeitTag where fahrerName.name=:name)")
    List<ArbeitTag> getArbeitTagByMaxIdName(@Param("name")String namee);
}
