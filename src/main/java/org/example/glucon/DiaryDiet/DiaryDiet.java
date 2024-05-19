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
    private String id;

    @Column(name = "description", length = 100)
    private int description;

    @Column(name = "meal")
    private int meal;

    @Column(name = "tag", length = 100)
    private String tag;

    @Column(name = "image")
    private int image;

    @Column(name = "lat")
    private double lat;

    @Column(name = "lng")
    private double lng;

    @Column(name = "recorded_at")
    private LocalDateTime recordedAt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
