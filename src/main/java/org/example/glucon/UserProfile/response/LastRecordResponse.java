package org.example.glucon.UserProfile.response;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.example.glucon.BaseResponse;

@Data
@SuperBuilder
public class LastRecordResponse extends BaseResponse {

    private String status;

    private String message;

    private BloodPressure blood_pressures;

    private BloodSugar blood_sugars;

    private Weights weights;

    @Data
    @Builder
    public static class BloodPressure {

        @Builder.Default
        private int systolic = 0;

        @Builder.Default
        private int diastolic = 0;

        @Builder.Default
        private int pulse = 0;
    }

    @Data
    @Builder
    public static class BloodSugar {

        @Builder.Default
        private int sugar = 0;
    }

    @Data
    @Builder
    public static class Weights {

        @Builder.Default
        private int weight = 0;
    }
}
