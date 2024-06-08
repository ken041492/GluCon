package org.example.glucon.Friend;

import lombok.RequiredArgsConstructor;
import org.example.glucon.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/api/friend")
@RequiredArgsConstructor
public class FriendController {

    private final FriendService service;

    @GetMapping("/list")
    public ResponseEntity<BaseResponse> getFriends() {
        return ResponseEntity.ok(service.getFriends());
    }
}
