package org.example.glucon.Friend;

import lombok.RequiredArgsConstructor;
import org.example.glucon.BaseResponse;
import org.example.glucon.Friend.Response.FriendCodeResponse;
import org.example.glucon.Friend.Response.FriendRequests;
import org.example.glucon.Friend.Response.FriendResults;
import org.example.glucon.Share.ShareRepository;
import org.example.glucon.UserProfile.UserProfile;
import org.example.glucon.UserProfile.UserProfileRepository;
import org.example.glucon.UserSet.UserSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FriendService {

    private final UserProfileRepository ProfileRepository;
    private final FriendRepository friendRepository;
    private final UserSetRepository userSetRepository;
    private final ShareRepository shareRepository;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

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

    public BaseResponse getFriendCode() {

        Integer loginId = (Integer) redisTemplate.opsForValue().get("loginId");
        Optional<UserProfile> optionalUserProfile = ProfileRepository.findById(Long.valueOf(loginId));

        if (optionalUserProfile.isEmpty()) {
            return BaseResponse.FAILED("失敗");
        }

        UserProfile userProfile = optionalUserProfile.get();
        return FriendCodeResponse.builder()
                .status("0")
                .message("ok")
                .invite_code(userProfile.getCode())
                .build();
    }

    public BaseResponse getFriendResults() {

        List<Friend> optionalFriends = friendRepository.findAll();

        if (optionalFriends.isEmpty()) {
            return FriendResults.builder()
                    .status("0")
                    .message("ok")
                    .results(List.of())
                    .build();
        }
        var friendsList = new ArrayList<FriendResults.FriendsResultsInfo>();

        for (Friend friend : optionalFriends) {
            var userSet = userSetRepository.findById(Long.valueOf(friend.getId()));
            var userProfile = ProfileRepository.findById(Long.valueOf(friend.getId()));

            if(friend.isRead()) {
                var resultInfo = FriendResults.FriendsResultsInfo.builder()
                        .id(friend.getId())
                        .user_id((int) friend.getUser_id())
                        .relation_id((int) friend.getRelation_id())
                        .type(friend.getFriend_type())
                        .status(friend.getStatus())
                        .read(friend.isRead() ? 1: 0)
                        .created_at(friend.getCreated_at())
                        .updated_at(friend.getUpdated_at())
                        .relation(FriendResults.RelationInfo.builder()
                                .id(Math.toIntExact(userSet.get().getId()))
                                .name(userSet.get().getName())
                                .account(userProfile.get().getAccount())
                                .build()
                        ).build();
                friendsList.add(resultInfo);
            }
        }
        return FriendResults.builder()
                .status("0")
                .message("ok")
                .results(friendsList)
                .build();
    }

    public BaseResponse getFriendRequests() {
        Integer loginId = (Integer) redisTemplate.opsForValue().get("loginId");

        List<Friend> inviterList = friendRepository.findByStatusAndRelationId(0, Long.valueOf(loginId)).orElseThrow();

        if (inviterList.isEmpty()) {
            return FriendRequests.builder()
                    .status("0")
                    .message("ok")
                    .requests(List.of())
                    .build();
        }

        var friendsList = new ArrayList<FriendRequests.FriendsRequestsInfo>();

        for (Friend inviter : inviterList) {
            var userSet = userSetRepository.findById(Long.valueOf(inviter.getId()));
            var userProfile = ProfileRepository.findById(Long.valueOf(inviter.getId()));

            if(!inviter.isRead()) {
                var resultInfo = FriendRequests.FriendsRequestsInfo.builder()
                        .id(inviter.getId())
                        .user_id((int) inviter.getUser_id())
                        .relation_id((int) inviter.getRelation_id())
                        .type(inviter.getFriend_type())
                        .status(inviter.getStatus())
                        .read(inviter.isRead() ? 1: 0)
                        .created_at(inviter.getCreated_at())
                        .updated_at(inviter.getUpdated_at())
                        .user(FriendRequests.UserInfo.builder()
                                .id(Math.toIntExact(userSet.get().getId()))
                                .name(userSet.get().getName())
                                .account(userProfile.get().getAccount())
                                .build()
                        ).build();
                friendsList.add(resultInfo);
            }
        }

        return FriendRequests.builder()
                .status("0")
                .message("ok")
                .requests(friendsList)
                .build();
    }

    public BaseResponse sendFriendRequest(SendRequest request) {

        Optional<UserProfile> optionalRecieveUserProfile = ProfileRepository.findByCode(request.getInvite_code());

        if (optionalRecieveUserProfile.isEmpty()) {
            return BaseResponse.FAILED("失敗");
        }

        UserProfile recieveUserProfile = optionalRecieveUserProfile.get();
        Integer loginId = (Integer) redisTemplate.opsForValue().get("loginId");
        UserProfile sendUserProfile = ProfileRepository.findById(Long.valueOf(loginId)).get();

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        LocalDateTime dateTime = LocalDateTime.parse(formattedDateTime, formatter);

        var friend = Friend.builder()
                .user_id((long) sendUserProfile.getId())
                .relation_id((long) recieveUserProfile.getId())
                .friend_type(request.getType())
                .status(0)
                .read(false)
                .created_at(dateTime)
                .updated_at(dateTime)
                .build();

        friendRepository.save(friend);
        return BaseResponse.SUCCESS("成功");
    }

    public BaseResponse acceptFriendRequest(Long id) {
        Optional<Friend> optionalFriend = friendRepository.findById(Math.toIntExact(id));

        if (optionalFriend.isEmpty()) {
            return BaseResponse.FAILED("失敗");
        }

        Friend friend = optionalFriend.get();
        friend.setStatus(1);
        friend.setRead(true);
        friendRepository.save(friend);

        var friendRecieve = Friend.builder()
                .user_id(friend.getRelation_id())
                .relation_id(friend.getUser_id())
                .friend_type(friend.getFriend_type())
                .status(1)
                .read(false)
                .created_at(friend.getCreated_at())
                .updated_at(friend.getUpdated_at())
                .build();
        friendRepository.save(friendRecieve);
        return BaseResponse.SUCCESS("成功");
    }
}
