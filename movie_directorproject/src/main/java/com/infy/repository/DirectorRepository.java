package com.infy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infy.entity.Director;
@Repository("DirectorRepository")
public interface DirectorRepository extends JpaRepository<Director,Integer> {
   @Query("from director d where first_name=?1")
   Optional<Director> findByfirst_name(String first_name);

}
