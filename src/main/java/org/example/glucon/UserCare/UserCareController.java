package org.example.glucon.UserCare;

import lombok.RequiredArgsConstructor;
import org.example.glucon.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/user/care")
@RequiredArgsConstructor
public class UserCareController {

    private final UserCareService service;

    @PostMapping("/care")
    public ResponseEntity<BaseResponse> createUserCare(@RequestBody CareRequest request) {
        return ResponseEntity.ok(service.createUserCare(request));
    }
}
