package org.example.glucon.Friend.Response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.example.glucon.BaseResponse;

import java.time.LocalDateTime;
import java.util.List;

@Data
@SuperBuilder
public class FriendRequests extends BaseResponse {

    private String status;

    private String message;

    private List<FriendRequests.FriendsRequestsInfo> requests;

    @Data
    @SuperBuilder
    public static class FriendsRequestsInfo {

        private int id;

        private int user_id;

        private int relation_id;

        private int type;

        private int status;

        private int read;

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime created_at;

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime updated_at;

        private FriendRequests.UserInfo user;
    }

    @Data
    @Builder
    public static class UserInfo {

        private int id;

        private String name;

        private String account;
    }
}
