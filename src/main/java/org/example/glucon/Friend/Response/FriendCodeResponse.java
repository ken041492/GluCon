package org.example.glucon.Friend.Response;


import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.glucon.BaseResponse;

@SuperBuilder
@Data
public class FriendCodeResponse extends BaseResponse {

    private String status;

    private String message;

    private String invite_code;
}
