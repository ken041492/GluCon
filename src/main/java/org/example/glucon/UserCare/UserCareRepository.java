package org.example.glucon.UserCare;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserCareRepository extends JpaRepository<UserCare, Long> {

    Optional<UserCare> findFirstByOrderByIdAsc();

    @Query("SELECT u FROM UserCare u WHERE u.user_id = :user_id")
    List<UserCare> findAllByUserId(Long user_id);
}
