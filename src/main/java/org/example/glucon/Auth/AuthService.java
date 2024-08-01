package org.example.glucon.Auth;

import jakarta.servlet.http.HttpSession;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.example.glucon.Auth.request.CheckVerificationRequest;
import org.example.glucon.Auth.request.LoginRequest;
import org.example.glucon.Auth.request.RegisterRequest;
import org.example.glucon.Auth.request.VerificationRequest;
import org.example.glucon.Auth.response.AuthLoginResponse;
import org.example.glucon.Auth.response.SendVerificationResponse;
import org.example.glucon.BaseResponse;
import org.example.glucon.BloodPressure.BloodPressure;
import org.example.glucon.BloodPressure.BloodPressureRepository;
import org.example.glucon.BloodSugar.BloodSugar;
import org.example.glucon.BloodSugar.BloodSugarRepository;
import org.example.glucon.Default.Default;
import org.example.glucon.Default.DefaultRepository;
import org.example.glucon.DiaryDiet.DiaryDiet;
import org.example.glucon.DiaryDiet.DiaryDietRepository;
import org.example.glucon.HbA1c.HbA1c;
import org.example.glucon.HbA1c.HbA1cRepository;
import org.example.glucon.MedicalInfo.MedicalInfo;
import org.example.glucon.MedicalInfo.MedicalInfoRepository;
import org.example.glucon.Setting.Setting;
import org.example.glucon.Setting.SettingRepository;
import org.example.glucon.Share.Share;
import org.example.glucon.Share.ShareRepository;
import org.example.glucon.User.Role;
import org.example.glucon.User.User;
import org.example.glucon.User.UserRepository;
import org.example.glucon.UserCare.UserCare;
import org.example.glucon.UserCare.UserCareRepository;
import org.example.glucon.UserProfile.UserProfile;
import org.example.glucon.UserProfile.UserProfileRepository;
import org.example.glucon.UserSet.UserSet;
import org.example.glucon.UserSet.UserSetRepository;
import org.example.glucon.Weight.Weight;
import org.example.glucon.Weight.WeightRepository;
import org.example.glucon.config.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repository;

    private final UserProfileRepository userProfileRepository;

    private final UserSetRepository userSetRepository;

    private final SettingRepository settingRepository;

    private final DefaultRepository defaultRepository;

    private final MedicalInfoRepository medicalInfoRepository;

    private final HbA1cRepository hbA1cRepository;

    private final UserCareRepository userCareRepository;

    private final ShareRepository shareRepository;

    private final WeightRepository weightRepository;

    private final BloodPressureRepository bloodPressureRepository;

    private final BloodSugarRepository bloodSugarRepository;

    private final DiaryDietRepository diaryDietRepository;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public static Integer loginId;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public List<User> getUsers() {
        return repository.findAll();
    }

    public BaseResponse register(RegisterRequest request) {

        Optional<User> optionalUser = repository.findByEmail(request.getEmail());

        if(optionalUser.isPresent()) {
            return BaseResponse.FAILED("失敗");
        }

        Random random = new Random();

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        LocalDateTime dateTime = LocalDateTime.parse(formattedDateTime, formatter);

        var user = User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .role(Role.USER)
                .build();

        var userProfile = UserProfile.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .code(generateCode(6))
                .created_at(dateTime)
                .updated_at(dateTime)
                .build();

        var userSet = UserSet.builder()
                .build();

        var setting = Setting.builder()
                .created_at(dateTime)
                .updated_at(dateTime)
                .build();

        var _default = Default.builder()
                .user_id(random.nextLong(1,301))
                .created_at(dateTime)
                .updated_at(dateTime)
                .build();

        var medicalInfo = MedicalInfo.builder()
                .created_at(dateTime)
                .updated_at(dateTime)
                .build();

        var hbA1c = HbA1c.builder()
                .recorded_at(dateTime)
                .created_at(dateTime)
                .updated_at(dateTime)
                .build();

        var userCare = UserCare.builder()
                .created_at(dateTime)
                .updated_at(dateTime)
                .build();

        var share = Share.builder()
                .build();

        var weight = Weight.builder()
                .recorded_at(dateTime)
                .created_at(dateTime)
                .updated_at(dateTime)
                .build();

        var bloodPressure = BloodPressure.builder()
                .recorded_at(dateTime)
                .created_at(dateTime)
                .updated_at(dateTime)
                .build();

        var bloodSugar = BloodSugar.builder()
                .recorded_at(dateTime)
                .created_at(dateTime)
                .updated_at(dateTime)
                .build();

        var diaryDiet = DiaryDiet.builder()
                .recorded_at(dateTime)
                .created_at(dateTime)
                .updated_at(dateTime)
                .build();

        userProfileRepository.save(userProfile);
        userSetRepository.save(userSet);
        settingRepository.save(setting);
        defaultRepository.save(_default);
        medicalInfoRepository.save(medicalInfo);
        hbA1cRepository.save(hbA1c);
        userCareRepository.save(userCare);
        shareRepository.save(share);
        weightRepository.save(weight);
        bloodPressureRepository.save(bloodPressure);
        bloodSugarRepository.save(bloodSugar);
        diaryDietRepository.save(diaryDiet);

        repository.save(user);

        return BaseResponse.SUCCESS("成功");
    }

    public BaseResponse check(String email) {
        Optional<User> optionalUser = repository.findByEmail(email);
        if(!optionalUser.isPresent()) {
            return BaseResponse.SUCCESS("成功");
        }
        return BaseResponse.FAILED("The given data was invalid.");
    }

    public BaseResponse sendVerification(VerificationRequest request) {

        Optional<User> optionalUser = repository.findByEmail(request.getEmail());

        if(optionalUser.isPresent()) {
            return SendVerificationResponse.builder()
                    .status("0")
                    .code(generateCode(6))
                    .message("成功")
                    .build();
        }
        return BaseResponse.FAILED("The given data was invalid.");
    }

    private String generateCode(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for(int i = 0; i < length; i++) {
            sb.append(random.nextInt(10)); // 产生0-9之间的随机数字
        }
        return sb.toString();
    }

    public BaseResponse checkVerification(CheckVerificationRequest request) {
        return BaseResponse.SUCCESS("成功");
    }

    public BaseResponse login(LoginRequest request) {
        Optional<User> optionalUser = repository.findByEmail(request.getEmail());
        if(optionalUser.isPresent()) { // 如果用户存在
            User user = optionalUser.get();
            if(user.getPassword().equals(request.getPassword())) {
                var jwtToken = jwtService.generateToken(user);
                loginId = user.getId();

                redisTemplate.opsForValue().set("loginId", loginId);

                return AuthLoginResponse.builder()
                        .status("0")
                        .token(jwtToken)
                        .build();
            }
        }
        return BaseResponse.FAILED("失敗");
    }
}
