package org.example.glucon.Share.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShareLocation {

    @Builder.Default
    public String lat = "";

    @Builder.Default
    public String lng = "";
}
