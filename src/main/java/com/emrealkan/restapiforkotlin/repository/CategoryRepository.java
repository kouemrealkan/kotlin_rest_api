package com.emrealkan.restapiforkotlin.repository;

import com.emrealkan.restapiforkotlin.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
