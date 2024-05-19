package org.example.glucon.UserProfile.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DefaultResponse {

    private Long id;

    @Builder.Default
    private int sugarDeltaMax = 0;

    @Builder.Default
    private int sugarDeltaMin = 0;

    @Builder.Default
    private int sugarMorningMax = 0;

    @Builder.Default
    private int sugarMorningMin = 0;

    @Builder.Default
    private int sugarEveningMax = 0;

    @Builder.Default
    private int sugarEveningMin = 0;

    @Builder.Default
    private int sugarBeforeMax = 0;

    @Builder.Default
    private int sugarBeforeMin = 0;

    @Builder.Default
    private int sugarAfterMax = 0;

    @Builder.Default
    private int sugarAfterMin = 0;

    @Builder.Default
    private int systolicMax = 0;

    @Builder.Default
    private int systolicMin = 0;

    @Builder.Default
    private int diastolicMax = 0;

    @Builder.Default
    private int diastolicMin = 0;

    @Builder.Default
    private int pulseMax = 0;

    @Builder.Default
    private int pulseMin = 0;

    @Builder.Default
    private int weightMax = 0;

    @Builder.Default
    private int weightMin = 0;

    @Builder.Default
    private int bmiMax = 0;

    @Builder.Default
    private int bmiMin = 0;

    @Builder.Default
    private int bodyFatMax = 0;

    @Builder.Default
    private int bodyFatMin = 0;

    @Builder.Default
    private String created_at = "";

    @Builder.Default
    private String updated_at = "";

}
