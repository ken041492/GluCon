package org.example.glucon.Share.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShareUser {

    @Builder.Default
    private int id = 0;

    @Builder.Default
    private String name = "";

    @Builder.Default
    private String account = "";
}
