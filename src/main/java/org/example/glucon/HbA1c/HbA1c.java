package org.example.glucon.HbA1c;

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
@Table(name = "HbA1c")
public class HbA1c {
    @Id
    @GeneratedValue
    @Column(name = "id", length = 50)
    private Long id;

    @Column(name = "user_id", length = 50)
    @Builder.Default
    private int user_id = 0;

    @Column(name = "a1c")
    @Builder.Default
    private String a1c = "";

    @Column(name = "recorded_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime recordedAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
