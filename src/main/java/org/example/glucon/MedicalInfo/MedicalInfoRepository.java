package org.example.glucon.MedicalInfo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicalInfoRepository extends JpaRepository<MedicalInfo, Long> {

    Optional<MedicalInfo> findFirstByOrderByIdAsc();
}
