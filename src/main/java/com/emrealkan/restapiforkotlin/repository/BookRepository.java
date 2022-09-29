package com.emrealkan.restapiforkotlin.repository;

import com.emrealkan.restapiforkotlin.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
