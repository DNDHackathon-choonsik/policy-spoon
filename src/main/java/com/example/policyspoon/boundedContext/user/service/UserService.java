package com.example.policyspoon.boundedContext.user.service;

import com.example.policyspoon.base.exception.CustomException;
import com.example.policyspoon.base.exception.ErrorCode;
import com.example.policyspoon.base.utils.JwtUtils;
import com.example.policyspoon.boundedContext.user.dto.JwtResponse;
import com.example.policyspoon.boundedContext.user.dto.KakaoUserInfo;
import com.example.policyspoon.boundedContext.user.dto.OAuthTokenResponse;
import com.example.policyspoon.boundedContext.user.dto.UserUpdateDto;
import com.example.policyspoon.boundedContext.user.entity.User;
import com.example.policyspoon.boundedContext.user.repository.UserRepository;
import com.example.policyspoon.boundedContext.user.service.feign.KakaoAuthClient;
import com.example.policyspoon.boundedContext.user.service.feign.KakaoInfoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.policyspoon.base.constant.Constants.ACCESS_TOKEN_EXPIRATION_MS;
import static com.example.policyspoon.base.constant.Constants.BEARER_PREFIX;
import static com.example.policyspoon.base.exception.ErrorCode.DUPLICATED;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final KakaoAuthClient kakaoAuthClient;
    private final KakaoInfoClient kakaoInfoClient;
    private final JwtUtils jwtUtils;

    @Value("${spring.security.oauth2.client.registration.kakao.authorization-grant-type}")
    private String GRANT_TYPE;

    @Value("${spring.security.oauth2.client.registration.kakao.client-id}")
    private String CLIENT_ID;

    @Value("${spring.security.oauth2.client.registration.kakao.redirect-uri}")
    private String REDIRECT_URI;

    @Transactional
    public JwtResponse login(String code) {
        OAuthTokenResponse oauthToken = getAccessToken(code);
        KakaoUserInfo userInfo = getUserInfo(oauthToken.getAccessToken());

        User user = userRepository.findByEmail(userInfo.getEmail())
                .orElseGet(() -> signUp(userInfo.getEmail(), userInfo.getName()));

        String access = jwtUtils.createJwt(user.getEmail(), ACCESS_TOKEN_EXPIRATION_MS);

        return JwtResponse.builder()
                .userId(user.getId())
                .accessToken(access)
                .build();
    }

    @Transactional
    public User signUp(String email, String name) {
        if (userRepository.existsByEmail(email)) {
            throw new CustomException(DUPLICATED, "email="+email);
        }

        User user = User.builder()
                .email(email)
                .nickname(name)
                .point(5)
                .build();

        return userRepository.save(user);
    }

    public OAuthTokenResponse getAccessToken(String code) {
        return kakaoAuthClient.getToken(GRANT_TYPE, CLIENT_ID, REDIRECT_URI, code);
    }

    public KakaoUserInfo getUserInfo(String accessToken) {
        return kakaoInfoClient.getUserInfo(BEARER_PREFIX + accessToken);
    }

    @Transactional
    public User update(Long userId, UserUpdateDto dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.DATA_NOT_FOUND));

        user.setBirth(dto.getBirth());
        user.setGender(dto.getGender());
        user.setArea(dto.getArea());

        return user;
    }
}
