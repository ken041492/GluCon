package org.example.glucon.Friend;

import lombok.RequiredArgsConstructor;
import org.example.glucon.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/friend")
@RequiredArgsConstructor
public class FriendController {

    private final FriendService service;

    @GetMapping("/list")
    public ResponseEntity<BaseResponse> getFriends() {
        return ResponseEntity.ok(service.getFriends());
    }

    @GetMapping("/code")
    public ResponseEntity<BaseResponse> getFriendCode() {
        return ResponseEntity.ok(service.getFriendCode());
    }

    @GetMapping("/results")
    public ResponseEntity<BaseResponse> getResults() {
        return ResponseEntity.ok(service.getFriendResults());
    }

    @GetMapping("/requests")
    public ResponseEntity<BaseResponse> getRequests() {
        return ResponseEntity.ok(service.getFriendRequests());
    }

    @PostMapping("/send")
    public ResponseEntity<BaseResponse> sendRequest(@RequestBody SendRequest request) {
        return ResponseEntity.ok(service.sendFriendRequest(request));
    }

    @GetMapping("/{invite_id}/accept")
    public ResponseEntity<BaseResponse> acceptRequest(@PathVariable("invite_id") Long id) {
        return ResponseEntity.ok(service.acceptFriendRequest(id));
    }
}
