package org.example.glucon.Friend;

import lombok.RequiredArgsConstructor;
import org.example.glucon.BaseResponse;
import org.example.glucon.Share.ShareRepository;
import org.example.glucon.UserProfile.UserProfileRepository;
import org.example.glucon.UserSet.UserSetRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FriendService {

    private final FriendRepository friendRepository;
    private final UserSetRepository userSetRepository;
    private final ShareRepository shareRepository;

    public BaseResponse getFriends() {
        var friends = friendRepository.findAll();
        if (friends.isEmpty()) {
            return FriendResponse.builder()
                    .status("0")
                    .message("ok")
                    .friends(List.of())
                    .build();
        } else {
            List<FriendsInfo> friendsList = new ArrayList<>();
            for (Friend friend : friends) {

                var userSet = userSetRepository.findById(Long.valueOf(friend.getId()));
                var share = shareRepository.findById(Long.valueOf(friend.getId()));

                friendsList.add(FriendsInfo.builder()
                                .id(friend.getId())
                                .name(userSet.get().getName())
                                .relation_type(share.get().getRelation_type())
                        .build());
            }

            return FriendResponse.builder()
                    .status("0")
                    .message("ok")
                    .friends(friendsList)
                    .build();
        }
    }
}
