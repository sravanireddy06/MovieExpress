package com.infy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infy.entity.Director;
@Repository("DirectorRepository")
public interface DirectorRepository extends JpaRepository<Director,Integer> {
   @Query("from Director d where d.First_Name=?1")
   Optional<Director> findByFirst_Name(String first_name);

}
