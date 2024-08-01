package org.example.glucon.Friend;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Integer id;

    // 自己id
    @Column(name = "user_id") // 寄送邀請者的 id
    private long user_id;

    //好友id
    @Column(name = "relation_id")
    @Builder.Default
    private long relation_id = 0; // 接收邀請者的 id

    @Column(name = "friend_type")
    @Builder.Default
    private int friend_type = 0;

    //1:接受、2:拒絕
    @Column(name = "status")
    @Builder.Default
    private int status = 0;

    @Column(name = "read")
    @Builder.Default
    private boolean read = false;

    @Column(name = "created_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created_at;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "updated_at")
    private LocalDateTime updated_at;
}
