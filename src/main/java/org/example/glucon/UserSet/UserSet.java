package org.example.glucon.UserSet;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "UserSet")
public class UserSet {

    @Id
    @GeneratedValue
    @Column(name = "id", length = 50)
    private Long id;

    @Column(name = "name", length = 100)
    @Builder.Default
    private String name = "";

    @Builder.Default
    @Column(name = "status", length = 50)
    private String status = "";

    @Column(name = "groups")
    private int groups;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "birthday")
    @Builder.Default
    private LocalDate birthday = LocalDate.now();

    @Column(name = "height")
    private float height;

    @Column(name = "weight")
    private float weight;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "address", length = 100)
    @Builder.Default
    private String address = "";

    @Column(name = "invite_code", length = 10)
    @Builder.Default
    private String invite_code = "";

    @Column(name = "unread_recode_one")
    private int unread_recode_one;

    @Column(name = "unread_recode_two")
    private int unread_recode_two;

    @Column(name = "unread_recode_three")
    private int unread_recode_three;

    @Column(name = "badge")
    private int badge;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_at")
    private LocalDateTime created_at;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "updated_at")
    private LocalDateTime updated_at;
}
