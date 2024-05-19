package org.example.glucon.HbA1c;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HbA1cRepository extends JpaRepository<HbA1c, Long>{

    Optional<HbA1c> findFirstByOrderByIdAsc();
}
