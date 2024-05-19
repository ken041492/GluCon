package org.example.glucon.DiaryDiet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiaryDietRepository extends JpaRepository<DiaryDiet, Long> {

    Optional<DiaryDiet> findFirstByOrderByIdAsc();
}
