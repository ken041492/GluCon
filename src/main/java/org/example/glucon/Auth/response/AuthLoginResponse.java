package org.example.glucon.Auth.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.example.glucon.BaseResponse;

@Data
@SuperBuilder
public class AuthLoginResponse extends BaseResponse{

    private String token;
}
