package org.example.glucon.UserProfile;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.glucon.BaseResponse;
import org.example.glucon.BloodPressure.BloodPressure;
import org.example.glucon.Default.Default;
import org.example.glucon.Default.DefaultRepository;
import org.example.glucon.HbA1c.HbA1c;
import org.example.glucon.HbA1c.HbA1cRepository;
import org.example.glucon.MedicalInfo.MedicalInfo;
import org.example.glucon.MedicalInfo.MedicalInfoRepository;
import org.example.glucon.Setting.Setting;
import org.example.glucon.Setting.SettingRepository;
import org.example.glucon.UserCare.UserCare;
import org.example.glucon.UserCare.UserCareRepository;
import org.example.glucon.UserProfile.Request.LastRecordRequest;
import org.example.glucon.UserProfile.response.*;
import org.example.glucon.UserSet.request.UserSetUpdateRequest;
import org.example.glucon.UserSet.UserSet;
import org.example.glucon.UserSet.UserSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;

    private final SettingRepository settingRepository;

    private final DefaultRepository defaultRepository;

    private final MedicalInfoRepository medicalInfoRepository;

    private final HbA1cRepository HbA1cRepository;

    private final UserCareRepository userCareRepository;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public UserResponse getUser() {

        Integer loginId = (Integer) redisTemplate.opsForValue().get("loginId");

        Optional<UserProfile> firstUserProfile = userProfileRepository.findById(loginId.longValue());

        Optional<Setting> firstSetting = settingRepository.findById(loginId.longValue());

        Optional<Default> firstDefault = defaultRepository.findById(loginId.longValue());

        Setting setting = Setting.builder()
                .id(firstSetting.get().getId())
                .user_id(firstSetting.get().getId())
                .created_at(firstSetting.get().getCreated_at())
                .updated_at(firstSetting.get().getUpdated_at())
                .build();

        Vip vip = Vip.builder()
                .id(firstDefault.get().getId())
                .user_id(firstDefault.get().getId())
                .created_at(firstDefault.get().getCreated_at())
                .updated_at(firstDefault.get().getUpdated_at())
                .build();

        Default defaultSetting = Default.builder()
                .id(firstDefault.get().getId())
                .user_id(firstDefault.get().getId())
                .created_at(firstDefault.get().getCreated_at())
                .updated_at(firstDefault.get().getUpdated_at())
                .build();

        return UserResponse.builder()
                .status("0")
                .message("ok")
                .user(UserInfo.builder()
                        .id(firstUserProfile.get().getId())
                        .email(firstUserProfile.get().getEmail())
                        .created_at(firstUserProfile.get().getCreated_at())
                        .updated_at(firstUserProfile.get().getUpdated_at())
                        .setting(setting)
                        .vip(vip)
                        .defaultValue(defaultSetting)
                        .build()
                )
                .build();
    }

    public Optional<UserProfile> updateUserFcmId(UserSetUpdateRequest request) {
        Logger logger = LogManager.getLogger(getClass());
        Integer loginId = (Integer) redisTemplate.opsForValue().get("loginId");

        Optional<UserProfile> userProfileOptional = userProfileRepository.findById(loginId.longValue());

        if (!userProfileOptional.isPresent()) {
            logger.error("No UserProfile found");
            return Optional.empty();
        }

        return userProfileOptional.map(userProfile -> {
            userProfile.setFcm_id(request.getFcm_id());
            logger.info("Updating fcm_id for userProfile id: " + userProfile.getId());
            return userProfileRepository.save(userProfile);
        });
    }

    public MedicalInfoResponse getMedicalInfo() {
        Integer loginId = (Integer) redisTemplate.opsForValue().get("loginId");

        Optional<MedicalInfo> firstMedicalInfo = medicalInfoRepository.findById(loginId.longValue());

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        LocalDateTime dateTime = LocalDateTime.parse(formattedDateTime, formatter);


        return MedicalInfoResponse.builder()
                .status("0")
                .message("ok")
                .medical_info(MedicalInfo.builder()
                        .id(firstMedicalInfo.get().getId())
                        .created_at(dateTime)
                        .updated_at(dateTime)
                        .build())
                .build();
    }

    public A1cResponse getA1c() {
        Integer loginId = (Integer) redisTemplate.opsForValue().get("loginId");

        Optional<HbA1c> firstHbA1c = HbA1cRepository.findById(loginId.longValue());

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        LocalDateTime dateTime = LocalDateTime.parse(formattedDateTime, formatter);

        return A1cResponse.builder()
                .status("0")
                .message("ok")
                .a1cs(HbA1cRepository.findAll())
                .build();
    }

    public UserCareResponse getUserCare() {
        Integer loginId = (Integer) redisTemplate.opsForValue().get("loginId");

        List<UserCare> userCares = userCareRepository.findAllByUserId(loginId.longValue());

        return UserCareResponse.builder()
                .status("0")
                .message("ok")
                .cares(userCares)
                .build();
    }

    public BaseResponse lastRecord(LastRecordRequest request) {

        var bloodPressure = LastRecordResponse.BloodPressure
                .builder()
                .build();

        var bloodSugar = LastRecordResponse.BloodSugar
                .builder()
                .build();

        var weights = LastRecordResponse.Weights
                .builder()
                .build();

        return LastRecordResponse.builder()
                .status("0")
                .message("ok")
                .blood_pressures(bloodPressure)
                .blood_sugars(bloodSugar)
                .weights(weights)
                .build();
    }
}
