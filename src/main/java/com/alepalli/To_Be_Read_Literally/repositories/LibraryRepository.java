package com.alepalli.To_Be_Read_Literally.repositories;

import com.alepalli.To_Be_Read_Literally.entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LibraryRepository extends JpaRepository<Library, Long> {

    List<Library> findByUserId(Long userId);
    Optional<Library> findByUserIdAndBookId(Long userId, Long bookId);
}
