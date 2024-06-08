package org.example.glucon.DiaryDiet;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.example.glucon.BaseResponse;

import java.util.List;

@Data
@SuperBuilder
public class DiaryResponse extends BaseResponse {

    private String status;

    private String message;

    private List<DiaryEntry> diary;
}
