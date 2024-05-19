package org.example.glucon.UserProfile.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.example.glucon.BaseResponse;
import org.example.glucon.MedicalInfo.MedicalInfo;


@Data
@SuperBuilder
public class MedicalInfoResponse extends BaseResponse {

    private String status;
    private MedicalInfo medical_info;
    private String message;

}

