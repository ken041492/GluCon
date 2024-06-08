package org.example.glucon.News;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.glucon.BaseResponse;

import java.util.List;

@Data
@SuperBuilder
public class NewsResponse extends BaseResponse {

    private String status;

    private String message;

    private List<News> news;
}
