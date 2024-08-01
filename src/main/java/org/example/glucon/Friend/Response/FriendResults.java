package org.example.glucon.Friend.Response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.glucon.BaseResponse;

import javax.management.relation.Relation;
import java.time.LocalDateTime;
import java.util.List;

@Data
@SuperBuilder
public class FriendResults extends BaseResponse {

    private String status;

    private String message;

    private List<FriendsResultsInfo> results;

    @Data
    @SuperBuilder
    public static class FriendsResultsInfo {

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

        private RelationInfo relation;
    }

    @Data
    @Builder
    public static class RelationInfo {

        private int id;

        private String name;

        private String account;
    }
}
