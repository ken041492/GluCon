package org.example.glucon.UserProfile.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.example.glucon.BaseResponse;
import org.example.glucon.HbA1c.HbA1c;

import java.util.List;

@Data
@SuperBuilder
public class A1cResponse extends BaseResponse {

    private String status;
    private List<HbA1c> a1cs;
    private String message;
}
