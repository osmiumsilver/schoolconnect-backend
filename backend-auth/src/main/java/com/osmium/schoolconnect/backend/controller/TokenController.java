package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.misc.RequestException;
import com.osmium.schoolconnect.backend.misc.Result;
import com.osmium.schoolconnect.backend.misc.ResultCode;
import com.osmium.schoolconnect.backend.service.IOpenIDService;
import com.osmium.schoolconnect.backend.utils.RedisUtils;
import com.osmium.schoolconnect.backend.utils.SecurityUtils;
import io.jsonwebtoken.Claims;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
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

    private final JwtEncoder encoder;
    private final IOpenIDService iOpenIDService;
    private final RedisUtils redisUtils;
    private final SecurityUtils securityUtils;
    public TokenController(JwtEncoder encoder, IOpenIDService iOpenIDService, RedisUtils redisUtils, SecurityUtils securityUtils) {
        this.encoder = encoder;
        this.iOpenIDService = iOpenIDService;
        this.redisUtils = redisUtils;
        this.securityUtils = securityUtils;
    }


    @Operation(summary = "签发JWT")
    @PostMapping("/token")
    public Result<String> token(Authentication authentication, @RequestBody String access) { //我要签发JWT了
        var now = Instant.now();
        long expiry = 259200L;
        String scope = authentication.getAuthorities().stream()//使用Stream API来作一些提取
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
        JwtClaimsSet claims = JwtClaimsSet.builder() //设计基本信息
                .issuer("https://api.abelyao.cn/api/auth/token")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiry))
                .subject(authentication.getName())
                .claim("scope", scope)
                .claim("access", access)
                .build();

        redisUtils.setCacheObject("r_openid:"+authentication.getName(),access);
        // @formatter:on
        return Result.success("Token 成功生成", encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue());

    }
    @Operation(summary = "登出")
    @PostMapping("/logout")
    public String logout(Authentication authentication,@RequestBody String jwt){
        String lol = securityUtils.getClaimFromToken(jwt, Claims::getSubject);
        if(lol.equals(authentication.getName())) {
            redisUtils.deleteObject("r_openid:" + authentication.getName());
            return "ok";
        }
            else throw  new RequestException(ResultCode.AUTH_INVALID);
    }



}
