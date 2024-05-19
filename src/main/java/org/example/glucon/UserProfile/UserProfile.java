package org.example.glucon.UserProfile;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.glucon.User.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "UserProfile")
public class UserProfile {

    @Id
    @GeneratedValue
    @Column(name = "id", length = 50)
    private Long id;

    @Column(name = "account", length = 100)
    @Builder.Default
    private String account = "";

    @Column(name = "password", length = 100)
    @Builder.Default
    private String password = "";

    @Column(name = "phone", length = 50)
    @Builder.Default
    private String phone = "";

    @Column(name = "email", length = 50)
    @Builder.Default
    private String email = "";

    @Column(name = "fb_id", length = 50)
    @Builder.Default
    private String fb_id = "";

    @Column(name = "code", length = 50)
    @Builder.Default
    private String code = "";

    @Column(name = "verified", columnDefinition = "boolean default false")
    private boolean verified;

    @Column(name = "privacy_policy", columnDefinition = "boolean default false")
    private boolean privacy_policy;

    @Column(name = "must_change_password", columnDefinition = "boolean default false")
    private boolean must_change_password;

    @Column(name = "fcm_id", length = 100)
    @Builder.Default
    private String fcm_id = "";

    @Column(name = "login_times")
    private int login_times;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_at")
    private LocalDateTime created_at;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "updated_at")
    private LocalDateTime updated_at;
//    @Enumerated(EnumType.STRING)
//    private Role role;
}
