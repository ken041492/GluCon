package org.example.glucon.UserSet.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserSetUpdateRequest {

    @Builder.Default
    private String fcm_id = "";

    @Builder.Default
    private String name = "";

    @Builder.Default
    private String birthday = "";

    @Builder.Default
    private Double height = 0.0;

    @Builder.Default
    private boolean gender = false;

    @Builder.Default
    private String address = "";

    @Builder.Default
    private String weight = "";

    @Builder.Default
    private String phone = "";

    @Builder.Default
    private String email = "";
}
