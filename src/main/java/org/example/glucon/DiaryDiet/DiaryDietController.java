package org.example.glucon.DiaryDiet;

import lombok.RequiredArgsConstructor;
import org.example.glucon.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class DiaryDietController {

    private final DiaryDietService service;

    @GetMapping("/diary")
    public ResponseEntity<BaseResponse> getDiary() {
        return ResponseEntity.ok(service.getDiary());
    }
}
