package org.example.glucon.UserCare;

import lombok.RequiredArgsConstructor;
import org.example.glucon.BaseResponse;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserCareService {
    private final UserCareRepository repository;
    private RedisTemplate<String, Object> redisTemplate;

    public BaseResponse createUserCare(CareRequest request) {
        Integer loginId = (Integer) redisTemplate.opsForValue().get("loginId");
        Optional<UserCare> userCare = repository.findById(Long.valueOf(loginId));
        if (!userCare.isPresent()) {
            return BaseResponse.FAILED("失敗");
        }
        return BaseResponse.SUCCESS("成功");
    }
}
