package org.example.glucon.Friend;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FriendsInfo {

    private Integer id;

    private String name;

    private Integer relation_type;
}
