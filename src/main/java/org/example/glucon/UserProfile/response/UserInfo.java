package org.example.glucon.UserProfile.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import org.example.glucon.Default.Default;
import org.example.glucon.Setting.Setting;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Data
@Builder
public class UserInfo {

    @Id
    @GeneratedValue
    private Long id;

    @Builder.Default
    private String fcm_id = "";

    @Builder.Default
    private String name = "";

    @Builder.Default
    private String account = "";

    @Builder.Default
    private String status = "";

    @Builder.Default
    private String fb_id = "";

    @Builder.Default
    private String birthday = "";

    @Builder.Default
    private Double height = 0.0;

    @Builder.Default
    private Integer gender = 0;

    @Builder.Default
    private String address = "";

    @Builder.Default
    private Double weight = 0.0;

    @Builder.Default
    private String phone = "";

    @Builder.Default
    private String email = "";

    @Builder.Default
    private String inviteCode = "";

    @Builder.Default
    private List<Integer> unread_records = new ArrayList<>(Arrays.asList(0, 0, 0));

    @Builder.Default
    private Integer verified = 0;

    @Builder.Default
    private Integer privacy_policy = 0;

    @Builder.Default
    private Integer must_change_password = 0;

    @Builder.Default
    private Integer login_times = 0;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created_at;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updated_at;

    private Setting setting;

    private Vip vip;

    @Builder.Default
    private String group = "";

    private Default defaultValue;
}
