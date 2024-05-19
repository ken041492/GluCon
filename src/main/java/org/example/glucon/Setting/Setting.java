package org.example.glucon.Setting;

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
@Table(name = "Setting")
public class Setting {

    @Id
    @GeneratedValue
    @Column(name = "id", length = 50)
    private Long id;

    @Column(name = "user_id", length = 50)
    private Long user_id;

    @Builder.Default
    @Column(name = "after_recording")
    private int after_recording = 0;

    @Builder.Default
    @Column(name = "no_recording_for_a_day")
    private int no_recording_for_a_day = 0;

    @Builder.Default
    @Column(name = "over_max_or_under_min")
    private int over_max_or_under_min = 0;

    @Builder.Default
    @Column(name = "after_meal")
    private int after_meal = 0;

    @Builder.Default
    @Column(name = "unit_of_sugar")
    private int unit_of_sugar = 0;

    @Builder.Default
    @Column(name = "unit_of_weight")
    private int unit_of_weight = 0;

    @Builder.Default
    @Column(name = "unit_of_height")
    private int unit_of_height = 0;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_at")
    private LocalDateTime created_at;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "updated_at")
    private LocalDateTime updated_at;
}
