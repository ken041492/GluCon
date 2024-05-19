package org.example.glucon.UserSet;

import com.sun.tools.jconsole.JConsoleContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.example.glucon.BaseResponse;
import org.example.glucon.UserProfile.UserProfile;
import org.example.glucon.UserProfile.UserProfileRepository;
import org.example.glucon.UserSet.request.UserSetUpdateRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
@RequiredArgsConstructor
public class UserSetService {

    private final UserSetRepository userSetRepository;

}
