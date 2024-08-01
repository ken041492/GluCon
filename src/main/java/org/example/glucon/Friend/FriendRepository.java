package org.example.glucon.Friend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Integer> {

    @Query("SELECT f FROM Friend f WHERE f.status = :status AND f.relation_id = :relation_id")
    Optional<List<Friend>> findByStatusAndRelationId(Integer status, Long relation_id);

}
