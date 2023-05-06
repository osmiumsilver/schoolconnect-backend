package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.entity.User;
import com.osmium.schoolconnect.backend.entity.dto.UserPassDTO;
import com.osmium.schoolconnect.backend.entity.pojo.StudentInfoVO;
import com.osmium.schoolconnect.backend.misc.RequestException;
import com.osmium.schoolconnect.backend.misc.ResultCode;
import com.osmium.schoolconnect.backend.service.ILoginService;
import com.osmium.schoolconnect.backend.service.IUserService;
import com.osmium.schoolconnect.backend.utils.SecurityUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * @Author
 * @Date 2023/2/11
 * @Description 学生操作学籍
 */
@RestController
@RequestMapping("/user/info")
@Tag(name = "用户信息用户"
)
public class UserInfoControllerForUsers {
    private final IUserService iUserService;
private final ILoginService iLoginService;
final PasswordEncoder passwordEncoder;

    public UserInfoControllerForUsers(IUserService iUserService, ILoginService iLoginService, PasswordEncoder passwordEncoder) {
        this.iUserService = iUserService;
        this.iLoginService = iLoginService;
        this.passwordEncoder = passwordEncoder;
    }

    @Operation(summary = "用户端获取自身信息")
    @GetMapping
    public User getInfo(Authentication authentication) {
        return iUserService.getById(authentication.getName());
    }

    @Operation(summary="学生获取自身信息")
    @GetMapping("/student")
    public StudentInfoVO getStudentInfo(Authentication authentication){
        return iUserService.selectStudentById(authentication.getName());
    }

    @Operation(summary = "学生修改学籍信息")

    @PutMapping
    public Boolean updateInfo(@RequestBody User newUser) {
        if(!newUser.getEmployeeId().equals(SecurityUtils.getUserId()))
            throw new RequestException(ResultCode.AUTH_NO_PERMISSION);

        return iUserService.updateById(newUser);
    }

@Operation(summary = "修改个人密码")
    @PostMapping("/change")
public Boolean changePassword(@RequestBody UserPassDTO newUserPass) {
    if(!newUserPass.getEmployeeId().equals(SecurityUtils.getUserId()))
        throw new RequestException(ResultCode.AUTH_NO_PERMISSION);
    if(!passwordEncoder.matches(newUserPass.getOldPass(),iLoginService.getById(newUserPass.getEmployeeId()).getPassword()))
        throw new RequestException(ResultCode.AUTH_PWD_ERR);
    return iLoginService.updatePassword(newUserPass.getEmployeeId(),passwordEncoder.encode(newUserPass.getNewPass()));
}

}
