package com.sosddemo.ruoyiDemo;


import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.sosddemo.annotation.Log;
import com.sosddemo.common.Result;
import com.sosddemo.entity.SysUser;
import com.sosddemo.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author author
 * @since 2024-04-08
 */


@RestController
@RequestMapping("/sys-user")
public class SysUserController {
    @Autowired
    SysUserServiceImpl sysUserService;

    @SaIgnore
    @GetMapping("/isLogin")
    public SaResult isLogin() {
        return SaResult.ok(StpUtil.getLoginIdAsString()+"是否登录：" + StpUtil.isLogin());
    }

    @PostMapping("/insert")
    Result insert(@RequestBody SysUser sysUser){

        String operateUserId=StpUtil.getLoginIdAsString();
        ;
        return Result.success(sysUserService.insert(operateUserId,sysUser));
    };

    @PutMapping("/delete")
    Result delete(@RequestBody SysUser sysUser){
        String operateUserId=StpUtil.getLoginIdAsString();
        return Result.success(sysUserService.delete(operateUserId,sysUser));
    };

    @PutMapping("/modify")
    Result modify(@RequestBody SysUser sysUser){
        String operateUserId=StpUtil.getLoginIdAsString();
        return Result.success(sysUserService.modify(operateUserId,sysUser));

    };
    @GetMapping("/getByDate")

    Result getByDate(@RequestParam("begin") String begin, @RequestParam("end") String end){
      return Result.success(sysUserService.getByDate(LocalDate.parse(begin),LocalDate.parse(end)));
    };
    @GetMapping("/getByUsername")
    Result getByUsername(@RequestParam("user_name")String username){
        return Result.success(sysUserService.getByUsername(username));

    };
    @GetMapping("/getByPhoneNumbe")
    Result getByPhoneNumber(@RequestParam("phonenumber") String phonenumber){
        return Result.success(sysUserService.getByPhoneNumber(phonenumber));
    };
    @GetMapping("/getByStatus")
    Result getByStatus(@RequestParam("status") String status){
        return Result.success(sysUserService.getByStatus(status));
    };


}
