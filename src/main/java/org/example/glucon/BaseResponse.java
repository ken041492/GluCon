package org.example.glucon;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class BaseResponse {
    private String status;
    private String message;

    /**
     * @return 成功狀態
     */
    public static BaseResponse SUCCESS(String message) {
        return BaseResponse.builder()
                .status("0")       // "0" 表示成功
                .message(message) // 對應的消息
                .build();
    }

    /**
     * @return 失敗狀態
     */
    public static BaseResponse FAILED(String message) {
        return BaseResponse.builder()
                .status("1")       // "1" 表示失敗
                .message(message) // 對應的消息
                .build();
    }
}
