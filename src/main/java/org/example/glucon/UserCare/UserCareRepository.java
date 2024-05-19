package org.example.glucon.UserCare;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCareRepository extends JpaRepository<UserCare, Long> {

    Optional<UserCare> findFirstByOrderByIdAsc();
}
