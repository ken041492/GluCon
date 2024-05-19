package org.example.glucon.BloodSugar;

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
    private String id;

    @Column(name = "sugar")
    private int sugar;

    @Column(name = "exercise")
    private int exercise;

    @Column(name = "drug")
    private int drug;

    @Column(name = "timeperiod")
    private int timeperiod;

    @Column(name = "recorded_at")
    private LocalDateTime recordedAt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
