package org.example.glucon.Friend;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Friend")
public class Friend {

    @Id
    @GeneratedValue
    @Column(name = "id", length = 50)
    private String id;

    @Column(name = "userId")
    private long userId;

    @Column(name = "relationId")
    private long relationId;

    @Column(name = "friend_type")
    private int friendType;

    @Column(name = "status")
    private int status;

    @Column(name = "read")
    private boolean read;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
