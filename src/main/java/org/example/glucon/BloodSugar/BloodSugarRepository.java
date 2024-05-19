package org.example.glucon.BloodSugar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BloodSugarRepository extends JpaRepository<BloodSugar, Long> {

    Optional<BloodSugar> findFirstByOrderByIdAsc();
}
