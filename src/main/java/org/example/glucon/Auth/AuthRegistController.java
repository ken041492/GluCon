package org.example.glucon.Auth;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.glucon.Auth.request.CheckVerificationRequest;
import org.example.glucon.Auth.request.LoginRequest;
import org.example.glucon.Auth.request.RegisterRequest;
import org.example.glucon.Auth.request.VerificationRequest;
import org.example.glucon.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthRegistController {

    private final AuthService service;

    @GetMapping("/register/check")
    public ResponseEntity<BaseResponse> check(@RequestParam String email) {
        return ResponseEntity.ok(service.check(email));
    }

    @PostMapping("/register")
    public ResponseEntity<BaseResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/verification/send")
    public ResponseEntity<BaseResponse> sendVerification(
            @RequestBody VerificationRequest request
    ) {
        return ResponseEntity.ok(service.sendVerification(request));
    }

    @PostMapping("/verification/check")
    public ResponseEntity<BaseResponse> checkVerification(
            @RequestBody CheckVerificationRequest request
    ) {
        return ResponseEntity.ok(service.checkVerification(request));
    }

    @PostMapping("/auth")
    public ResponseEntity<BaseResponse> auth(
            @RequestBody LoginRequest request,
            HttpSession session
    ) {
        session.setAttribute("USER_ACCOUNT", request.getEmail());
        return ResponseEntity.ok(service.login(request));
    }
}
