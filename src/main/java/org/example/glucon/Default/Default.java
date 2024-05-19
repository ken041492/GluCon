package org.example.glucon.Default;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "_Default")
public class Default {

    @Id
    @GeneratedValue
    @Column(name = "id", length = 50)
    private Long id;

    @Column(name = "user_id", length = 50)
    private Long user_id;

    @Column(name = "sugar_morning_max")
    @Builder.Default
    private int sugar_morning_max = 0;

    @Column(name = "sugar_morning_min")
    @Builder.Default
    private int sugar_morning_min = 0;

    @Column(name = "sugar_evening_max")
    @Builder.Default
    private int sugar_evening_max = 0;

    @Column(name = "sugar_evening_min")
    @Builder.Default
    private int sugar_evening_min = 0;

    @Column(name = "sugar_before_max")
    @Builder.Default
    private int sugar_before_max = 0;

    @Column(name = "sugar_before_min")
    @Builder.Default
    private int sugar_before_min = 0;

    @Column(name = "sugar_after_max")
    @Builder.Default
    private int sugar_after_max = 0;

    @Column(name = "sugar_after_min")
    @Builder.Default
    private int sugar_after_min = 0;

    @Column(name = "systolic_max")
    @Builder.Default
    private int systolic_max = 0;

    @Column(name = "systolic_min")
    @Builder.Default
    private int systolic_min = 0;

    @Column(name = "diastolic_max")
    @Builder.Default
    private int diastolic_max = 0;

    @Column(name = "diastolic_min")
    @Builder.Default
    private int diastolic_min = 0;

    @Column(name = "pulse_max")
    @Builder.Default
    private int pulse_max = 0;

    @Column(name = "pulse_min")
    @Builder.Default
    private int pulse_min = 0;

    @Column(name = "weight_max")
    @Builder.Default
    private int weight_max = 0;

    @Column(name = "weight_min")
    @Builder.Default
    private int weight_min = 0;

    @Column(name = "bmi_max")
    @Builder.Default
    private int bmi_max = 0;

    @Column(name = "bmi_min")
    @Builder.Default
    private int bmi_min = 0;

    @Column(name = "body_fat_max")
    @Builder.Default
    private int body_fat_max = 0;

    @Column(name = "body_fat_min")
    @Builder.Default
    private int body_fat_min = 0;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_at")
    private LocalDateTime created_at;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "updated_at")
    private LocalDateTime updated_at;
}
