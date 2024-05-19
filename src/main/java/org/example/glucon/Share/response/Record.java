package org.example.glucon.Share.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Record {

    @Builder.Default
    private int id = 0;

    @Builder.Default
    private int user_id = 0;

    @Builder.Default
    private int systolic = 0;

    @Builder.Default
    private int diastolic = 0;

    @Builder.Default
    private int pulse = 0;

    @Builder.Default
    private double weight = 0.0;

    @Builder.Default
    private double body_fat = 0.0;

    @Builder.Default
    private double bmi = 0.0;

    @Builder.Default
    private double sugar = 0.0;

    @Builder.Default
    private int timeperiod = 0;

    @Builder.Default
    private String description = "";

    @Builder.Default
    private int meal = 3;

    @Builder.Default
    private List<List<String>> tag = new ArrayList<>();

    @Builder.Default
    private List<String> image = new ArrayList<>();

    @Builder.Default
    private ShareLocation location = new ShareLocation();

    @Builder.Default
    private ShareUser user = new ShareUser();

    @Builder.Default
    private int relation_type = 1;

    @Builder.Default
    private int relation_id = 0;

    @Builder.Default
    private String message = "";

    @Builder.Default
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime recorded_at;

    @Builder.Default
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created_at;

    @Builder.Default
    private int type = 5;

    @Builder.Default
    private String url = "";
}
