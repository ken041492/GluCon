package org.example.glucon.Share.response;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.example.glucon.BaseResponse;

import java.util.List;

@Data
@SuperBuilder
public class ShareResponse extends BaseResponse {

    @Builder.Default
    private String status = "";

    @Builder.Default
    private String message = "";

    @Builder.Default
    private List<Record> records = List.of();
}
