package org.example.glucon.News;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class News {
    @Id
    @GeneratedValue
    private int id;

    private int member_id;

    @Builder.Default
    private int group = 0;

    @Builder.Default
    private String title = "0";

    @Builder.Default
    private String message = "0";

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime pushed_at;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created_at;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updated_at;
}
