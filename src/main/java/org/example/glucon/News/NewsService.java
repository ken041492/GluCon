package org.example.glucon.News;

import lombok.RequiredArgsConstructor;
import org.example.glucon.BaseResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsService {
    public BaseResponse getNews() {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        LocalDateTime dateTime = LocalDateTime.parse(formattedDateTime, formatter);

        return NewsResponse.builder()
                .status("0")
                .message("ok")
                .news(List.of(News.builder()
                        .member_id(0)
                        .pushed_at(dateTime)
                        .updated_at(dateTime)
                        .created_at(dateTime)
                        .build()))
                .build();
    }
}
