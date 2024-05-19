package org.example.glucon.BloodSugar;

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
@Table(name = "BloodSugar")
public class BloodSugar {

    @Id
    @GeneratedValue
    @Column(name = "id", length = 50)
    private Long id;

    @Column(name = "sugar")
    @Builder.Default
    private int sugar = 0;

    @Column(name = "exercise")
    @Builder.Default
    private int exercise = 0;

    @Column(name = "drug")
    @Builder.Default
    private int drug = 0;

    @Column(name = "timeperiod")
    @Builder.Default
    private int timeperiod = 0;

    @Column(name = "recorded_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime recorded_at;

    @Column(name = "created_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created_at;

    @Column(name = "updated_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updated_at;
}
