package org.example.glucon.UserProfile;

import org.example.glucon.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long>{

    Optional<UserProfile> findFirstByOrderByIdAsc();

    Optional<UserProfile> findByCode(String inviteCode);
}
