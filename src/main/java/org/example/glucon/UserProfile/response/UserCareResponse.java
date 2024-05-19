package org.example.glucon.UserProfile.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.example.glucon.BaseResponse;
import org.example.glucon.UserCare.UserCare;

import java.util.List;

@Data
@SuperBuilder
public class UserCareResponse extends BaseResponse {

    private String status;

    private String message;

    private List<UserCare> cares;
}
