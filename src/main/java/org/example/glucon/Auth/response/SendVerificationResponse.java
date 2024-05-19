package org.example.glucon.Auth.response;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.example.glucon.BaseResponse;

@Data
//@EqualsAndHashCode(callSuper = true) // 确保了在执行equals和hashCode方法时，父类的字段也会被考虑。
@SuperBuilder
public class SendVerificationResponse extends BaseResponse {

    private final String code;

}
