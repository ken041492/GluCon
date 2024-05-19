package org.example.glucon.UserSet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserSetRepository extends JpaRepository<UserSet, Long> {

    Optional<UserSet> findFirstByOrderByIdAsc();

}
