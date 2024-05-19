package org.example.glucon.UserProfile.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SettingResponse {

    private Long userId;

    @Builder.Default
    private boolean after_recording = false;

    @Builder.Default
    private boolean no_recording_for_a_day = false;

    @Builder.Default
    private boolean over_max_or_under_min = false;

    @Builder.Default
    private boolean after_meal = false;

    @Builder.Default
    private boolean unit_of_sugar = false;

    @Builder.Default
    private boolean unit_of_weight = false;

    @Builder.Default
    private boolean unit_of_height = false;

    @Builder.Default
    private String created_at = "";

    @Builder.Default
    private String updated_at = "";
}
