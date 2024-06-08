package org.example.glucon.DiaryDiet;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class DiaryEntry {
    @GeneratedValue
    @Id
    private int id;

    private int user_id;

    private int systolic;

    private int diastolic;

    private int pulse;

    private double weight;

    private double body_fat;

    private double bmi;

    private double sugar;

    private int exercise;

    private int drug;

    private int timeperiod;

    private String description;

    private int meal;

    private List<TagResponse> tag;

    private List<String> image;

    private LocationResponse location;

    private String reply;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime recorded_at;

    private String type;

}
