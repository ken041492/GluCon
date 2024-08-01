package org.example.glucon.Friend;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SendRequest {

    private Integer type;

    private String invite_code;
}
