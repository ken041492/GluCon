package org.example.glucon.DiaryDiet;

import lombok.RequiredArgsConstructor;
import org.example.glucon.BaseResponse;
import org.example.glucon.BloodPressure.BloodPressure;
import org.example.glucon.BloodPressure.BloodPressureRepository;
import org.example.glucon.BloodSugar.BloodSugarRepository;
import org.example.glucon.Weight.WeightRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DiaryDietService {

    private final DiaryDietRepository diaryDietRepository;
    private final BloodPressureRepository bloodPressureRepository;
    private final WeightRepository weightRepository;
    private final BloodSugarRepository bloodSugarRepository;

    public BaseResponse getDiary() {
        var DiaryDiets = diaryDietRepository.findAll();
        if(DiaryDiets.isEmpty()) {
            return DiaryResponse.builder()
                    .status("0")
                    .message("ok")
                    .diary(List.of())
                    .build();
        } else {
            List<DiaryEntry> diaryDietList = new ArrayList<>();

//            for(DiaryDiet diaryDiet : DiaryDiets) {
//                var bloodPressure = bloodPressureRepository.findById(Long.valueOf(diaryDiet.getId()));
//                var weight = weightRepository.findById(Long.valueOf(diaryDiet.getId()));
//                var bloodSugar = bloodSugarRepository.findById(Long.valueOf(diaryDiet.getId()));
//
//                diaryDietList.add(DiaryEntry.builder()
//
//
//                        .build());
//            }

            return DiaryResponse.builder()
                    .status("0")
                    .message("ok")
                    .diary(diaryDietList)
                    .build();
        }
    }
}
