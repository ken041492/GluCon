package org.example.glucon.Friend;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.example.glucon.BaseResponse;

import java.util.List;

@Data
@SuperBuilder
public class FriendResponse extends BaseResponse {

        private String status;

        private String message;

        private List<FriendsInfo> friends;
}
