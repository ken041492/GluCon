package org.example.glucon.Setting;

import org.example.glucon.UserSet.UserSet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SettingRepository extends JpaRepository<Setting, Long> {
    Optional<Setting> findFirstByOrderByIdAsc();

}
