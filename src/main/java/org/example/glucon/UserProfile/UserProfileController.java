package org.example.glucon.UserProfile;

import lombok.RequiredArgsConstructor;
import org.example.glucon.BaseResponse;
import org.example.glucon.UserProfile.response.MedicalInfoResponse;
import org.example.glucon.UserSet.request.UserSetUpdateRequest;
import org.example.glucon.UserProfile.response.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService service;

    @GetMapping("/user")
    public ResponseEntity<UserResponse> getUserProfile() {
        return ResponseEntity.ok(service.getUser());
    }


    @PatchMapping("/user")
    public ResponseEntity<BaseResponse> updateUser(@RequestBody UserSetUpdateRequest request) {

        Optional<UserProfile> updatedUserProfile = service.updateUserFcmId(request);

        if (updatedUserProfile.isPresent()) {
            return ResponseEntity.ok(BaseResponse.SUCCESS("成功"));
        }
        return ResponseEntity.ok(BaseResponse.FAILED("失敗"));

    }

    @GetMapping("/user/medical")
    public ResponseEntity<MedicalInfoResponse> getMedicalProfile() {
        return ResponseEntity.ok(service.getMedicalInfo());
    }

    @GetMapping("/user/a1c")
    public ResponseEntity<BaseResponse> getA1c() {
        return ResponseEntity.ok(service.getA1c());
    }

    @GetMapping("/user/care")
    public ResponseEntity<BaseResponse> getUserCare() {
        return ResponseEntity.ok(service.getUserCare());
    }
}
