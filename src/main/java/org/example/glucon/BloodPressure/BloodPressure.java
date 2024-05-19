package org.example.glucon.BloodPressure;

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
@Table(name = "BloodPressure")
public class BloodPressure {

    @Id
    @GeneratedValue
    @Column(name = "id", length = 50)
    private String id;

    @Column(name = "systolic", precision = 3)
    private float systolic;

    @Column(name = "diastolic", precision = 3)
    private float diastolic;

    @Column(name = "pulse", precision = 3)
    private float pulse;

    @Column(name = "recorded_at")
    private LocalDateTime recordedAt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
