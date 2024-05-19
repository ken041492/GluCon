package org.example.glucon.UserCare;

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
@Table(name = "UserCare")
public class UserCare {

    @Id
    @GeneratedValue
    @Column(name = "id", length = 50)
    private Long id;

    @Column(name = "user_id")
    @Builder.Default
    private int user_id = 0;

    @Column(name = "member_id")
    @Builder.Default
    private int member_id = 0;

    @Column(name = "reply_id")
    @Builder.Default
    private int reply_id = 0;

    @Column(name = "message", length = 100)
    @Builder.Default
    private String message = "";

    @Column(name = "created_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created_at;

    @Column(name = "updated_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updated_at;

}
