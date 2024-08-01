package org.example.glucon.UserProfile;

import lombok.RequiredArgsConstructor;
import org.example.glucon.BaseResponse;
import org.example.glucon.UserProfile.Request.BadgeRequest;
import org.example.glucon.UserProfile.Request.LastRecordRequest;
import org.example.glucon.UserProfile.response.MedicalInfoResponse;
import org.example.glucon.UserSet.request.UserSetUpdateRequest;
import org.example.glucon.UserProfile.response.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService service;

    @GetMapping()
    public ResponseEntity<UserResponse> getUserProfile() {
        return ResponseEntity.ok(service.getUser());
    }


    @PatchMapping()
    public ResponseEntity<BaseResponse> updateUser(@RequestBody UserSetUpdateRequest request) {

        Optional<UserProfile> updatedUserProfile = service.updateUserFcmId(request);

        if (updatedUserProfile.isPresent()) {
            return ResponseEntity.ok(BaseResponse.SUCCESS("成功"));
        }
        return ResponseEntity.ok(BaseResponse.FAILED("失敗"));

    }

    @GetMapping("/medical")
    public ResponseEntity<MedicalInfoResponse> getMedicalProfile() {
        return ResponseEntity.ok(service.getMedicalInfo());
    }

    @GetMapping("/a1c")
    public ResponseEntity<BaseResponse> getA1c() {
        return ResponseEntity.ok(service.getA1c());
    }

    @GetMapping("/care")
    public ResponseEntity<BaseResponse> getUserCare() {
        return ResponseEntity.ok(service.getUserCare());
    }

    @PutMapping("/badge")
    public ResponseEntity<BaseResponse> updateUserBadge(@RequestBody BadgeRequest request) {
        return ResponseEntity.ok(BaseResponse.SUCCESS("成功"));
    }

    @PostMapping("/records")
    public ResponseEntity<BaseResponse> recordInfo(@RequestBody LastRecordRequest request) {
        return ResponseEntity.ok(service.lastRecord(request));
    }
}
