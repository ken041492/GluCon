package org.example.glucon.DiaryDiet;

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
@Table(name = "DiaryDiet")
public class DiaryDiet {

    @Id
    @GeneratedValue
    @Column(name = "id", length = 50)
    private Long id;

    @Column(name = "description", length = 100)
    @Builder.Default
    private int description = 0;

    @Column(name = "meal")
    @Builder.Default
    private int meal = 0;

    @Column(name = "tag", length = 100)
    @Builder.Default
    private String tag = "";

    @Column(name = "image")
    @Builder.Default
    private int image = 0;

    @Column(name = "lat")
    @Builder.Default
    private String lat = "";

    @Column(name = "lng")
    @Builder.Default
    private String lng = "";

    @Column(name = "recorded_at")
    private LocalDateTime recorded_at;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @Column(name = "updated_at")
    private LocalDateTime updated_at;
}
