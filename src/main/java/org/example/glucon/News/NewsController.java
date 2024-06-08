package org.example.glucon.News;

import lombok.RequiredArgsConstructor;
import org.example.glucon.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService service;

    @GetMapping()
    public ResponseEntity<BaseResponse> getNews() {
        return ResponseEntity.ok(service.getNews());
    }
}
