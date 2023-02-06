package com.osmium.schoolconnect.backend.auth.controller;

import com.osmium.schoolconnect.backend.auth.service.ILoginService;
import com.osmium.schoolconnect.backend.misc.Result;
import com.osmium.schoolconnect.backend.misc.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.stream.Collectors;

/**
 * @Author
 * @Date 2022/11/29
 * @Description
 */
@RestController
@Slf4j
@RequestMapping("/auth")
public class TokenController {

    @Autowired
    JwtEncoder encoder;

    ILoginService iLoginService;

    @PostMapping("/token")
    public Result<String> token(Authentication authentication,@RequestBody String openId){ //我要签发JWT了
        if (!authentication.isAuthenticated()){
            return Result.error(ResultCode.AUTH_LOGIN_FAIL);
        }
        //iLoginService.login(authentication.getName(), String.valueOf(authentication.getCredentials()));
        Instant now = Instant.now();
        long expiry = 36000L;
        String scope = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("https://api.abelyao.cn/api/auth/token")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiry))
                .subject(authentication.getName())
                .claim("scope", scope)
                .claim("openid",openId)
                .build();
        // @formatter:on
        return Result.success("Token 成功生成",encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue());

    }
}
