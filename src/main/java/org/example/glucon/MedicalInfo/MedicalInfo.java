package org.example.glucon.MedicalInfo;

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
@Table(name = "MedicalInfo")
public class MedicalInfo {

    @Id
    @GeneratedValue
    @Column(name = "id", length = 50)
    private Long id;

    @Column(name = "user_id")
    @Builder.Default
    private int user_id = 0;

    @Column(name = "oad")
    @Builder.Default
    private int oad = 0;

    @Column(name = "insulin")
    @Builder.Default
    private int insulin = 0 ;

    @Column(name = "anti_hypertensives")
    @Builder.Default
    private int anti_hypertensives = 0;

    @Column(name = "diabetes_type")
    @Builder.Default
    private int diabetes_type = 0;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_at")
    private LocalDateTime created_at;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "updated_at")
    private LocalDateTime updated_at;
}
