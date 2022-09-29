package com.emrealkan.restapiforkotlin.repository;

import com.emrealkan.restapiforkotlin.model.MovieCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieCategoryRepository extends JpaRepository<MovieCategory,Long> {

}
