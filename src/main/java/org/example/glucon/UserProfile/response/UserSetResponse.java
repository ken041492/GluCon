package org.example.glucon.UserProfile.response;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class UserSetResponse {

    private Long id;

    @Builder.Default
    private String name = "";

    @Builder.Default
    private String status = "";

    @Builder.Default
    private int groups = 0;

    @Builder.Default
    private LocalDate birthday = LocalDate.now();

    @Builder.Default
    private float height = 0;

    @Builder.Default
    private float weight = 0;

    @Builder.Default
    private boolean gender = false;

    @Builder.Default
    private String address = "";

    @Builder.Default
    private String inviteCode = "";

    @Builder.Default
    private int unreadRecodeOne = 0;

    @Builder.Default
    private int unreadRecodeTwo = 0;

    @Builder.Default
    private int unreadRecodeThree = 0;

    @Builder.Default
    private int badge = 0;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}

