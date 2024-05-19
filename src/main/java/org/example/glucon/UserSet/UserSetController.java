package org.example.glucon.UserSet;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.glucon.BaseResponse;
import org.example.glucon.UserProfile.UserProfile;
import org.example.glucon.UserProfile.response.UserResponse;
import org.example.glucon.UserSet.request.UserSetUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserSetController {

    final UserSetService userSetService;

    Logger logger = LogManager.getLogger(getClass());

//    @PatchMapping("/user")
//    public ResponseEntity<BaseResponse> updateUser(@RequestBody UserSetUpdateRequest request) {
//        Optional<UserProfile> updatedUserProfile = userSetService.updateUserFcmId(request);
//
//        if (updatedUserProfile.isPresent()) {
//            return ResponseEntity.ok(BaseResponse.SUCCESS("成功"));
//        }
//        return ResponseEntity.ok(BaseResponse.FAILED("失敗"));
//
//    }
}
