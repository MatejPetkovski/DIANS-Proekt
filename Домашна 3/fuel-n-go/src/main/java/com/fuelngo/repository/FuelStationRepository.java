package com.fuelngo.repository;

import com.fuelngo.model.FuelStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuelStationRepository extends JpaRepository<FuelStation,Long> {

    List<FuelStation> findByNameLike(String name);

    @Query("select name from FuelStation group by name")
    List<String> findNameDistinct();


}
