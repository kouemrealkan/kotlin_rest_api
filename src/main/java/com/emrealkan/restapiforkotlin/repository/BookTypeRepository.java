package com.emrealkan.restapiforkotlin.repository;

import com.emrealkan.restapiforkotlin.model.BookType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookTypeRepository extends JpaRepository<BookType,Long> {
}
