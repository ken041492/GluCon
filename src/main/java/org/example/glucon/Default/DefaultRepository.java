package org.example.glucon.Default;

import org.example.glucon.Setting.Setting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DefaultRepository extends JpaRepository<Default, Long> {
    Optional<Default> findFirstByOrderByIdAsc();

}
