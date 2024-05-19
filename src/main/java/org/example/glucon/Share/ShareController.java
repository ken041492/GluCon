package org.example.glucon.Share;

import lombok.RequiredArgsConstructor;
import org.example.glucon.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/share")
@RequiredArgsConstructor
public class ShareController {

    private final ShareService service;

    @GetMapping("/{type}")
    public ResponseEntity<BaseResponse> getShare(@PathVariable("type") int relation_id) {
        return ResponseEntity.ok(service.getShare(relation_id));
    }


}
