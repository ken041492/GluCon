package org.example.glucon.UserProfile.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Vip {
    @Id
    @GeneratedValue
    private Long id;

    @Builder.Default
    private Long user_id = 0L;

    @Builder.Default
    private Integer level = 0;

    @Builder.Default
    private Double remark = 0.0;

    @Builder.Default
    private String started_at = "";

    @Builder.Default
    private String ended_at = "";

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created_at;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updated_at;
}
