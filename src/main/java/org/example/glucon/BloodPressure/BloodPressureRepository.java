package org.example.glucon.BloodPressure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Repository
public interface BloodPressureRepository extends JpaRepository<BloodPressure, Long> {

    Optional<BloodPressure> findFirstByOrderByIdAsc();
}
