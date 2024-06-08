package org.example.glucon.DiaryDiet;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class TagResponse {

    @Builder.Default
    private List<String> name = new ArrayList<>();

    @Builder.Default
    private String message = "ok";
}
