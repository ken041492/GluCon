package org.example.glucon.Share;

import lombok.RequiredArgsConstructor;
import org.example.glucon.BloodPressure.BloodPressure;
import org.example.glucon.BloodPressure.BloodPressureRepository;
import org.example.glucon.BloodSugar.BloodSugar;
import org.example.glucon.BloodSugar.BloodSugarRepository;
import org.example.glucon.DiaryDiet.DiaryDiet;
import org.example.glucon.DiaryDiet.DiaryDietRepository;
import org.example.glucon.Share.response.Record;
import org.example.glucon.Share.response.ShareLocation;
import org.example.glucon.Share.response.ShareResponse;
import org.example.glucon.Share.response.ShareUser;
import org.example.glucon.UserProfile.UserProfile;
import org.example.glucon.UserProfile.UserProfileRepository;
import org.example.glucon.UserSet.UserSet;
import org.example.glucon.UserSet.UserSetRepository;
import org.example.glucon.Weight.Weight;
import org.example.glucon.Weight.WeightRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShareService {

    private final ShareRepository shareRepository;

    private final WeightRepository weightRepository;

    private final BloodPressureRepository bloodPressureRepository;

    private final BloodSugarRepository bloodSugarRepository;

    private final DiaryDietRepository diaryDietRepository;

    private final UserSetRepository userSetRepository;

    private final UserProfileRepository userProfileRepository;

    public ShareResponse getShare(int id) {

        Optional<Share> share = shareRepository.findFirstByOrderByIdAsc();
        Optional<Weight> weight = weightRepository.findFirstByOrderByIdAsc();
        Optional<BloodPressure> bloodPressure = bloodPressureRepository.findFirstByOrderByIdAsc();
        Optional<BloodSugar> bloodSugar = bloodSugarRepository.findFirstByOrderByIdAsc();
        Optional<DiaryDiet> diaryDiet = diaryDietRepository.findFirstByOrderByIdAsc();
        Optional<UserSet> userSet = userSetRepository.findFirstByOrderByIdAsc();
        Optional<UserProfile> userProfile = userProfileRepository.findFirstByOrderByIdAsc();

        String tag = diaryDiet.get().getTag();

        return ShareResponse.builder()
                .status("0")
                .message("ok")
                .records(List.of(Record.builder()
                                .id(Math.toIntExact(weight.get().getId()))
                                .recorded_at(weight.get().getRecorded_at())
                                .created_at(weight.get().getCreated_at())
                                .location(ShareLocation.builder()
                                        .lat(diaryDiet.get().getLat())
                                        .lng(diaryDiet.get().getLng())
                                        .build())
                                .user(ShareUser.builder()
                                        .id(Math.toIntExact(weight.get().getId()))
                                        .name(userSet.get().getName())
                                        .account(userProfile.get().getAccount())
                                        .build())

                                .relation_id(id)
                        .build()))
                .build();
    }
}
