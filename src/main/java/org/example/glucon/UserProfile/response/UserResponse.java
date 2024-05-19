package org.example.glucon.UserProfile.response;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import org.example.glucon.Default.Default;
import org.example.glucon.Setting.Setting;

import java.util.List;
@Data
@Builder
public class UserResponse {
    private String status;
    private UserInfo user;
    private String message;
}
