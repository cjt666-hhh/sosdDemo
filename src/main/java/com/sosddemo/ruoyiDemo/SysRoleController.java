package com.sosddemo.ruoyiDemo;


import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.stp.StpUtil;
import com.sosddemo.common.Result;
import com.sosddemo.entity.SysRole;
import com.sosddemo.service.impl.SysRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 角色信息表 前端控制器
 * </p>
 *
 * @author author
 * @since 2024-04-08
 */
@SaCheckLogin
@RestController
@RequestMapping("/sys-role")
public class SysRoleController {

    @Autowired
    SysRoleServiceImpl sysRoleService;
    @PostMapping("/insert")

    Result insert(@RequestBody SysRole role){
        String operateUserId= StpUtil.getLoginIdAsString();
        return Result.success(sysRoleService.insert(operateUserId,role));
    };

    @PutMapping("/delete")
    Result delete(@RequestBody SysRole role){
        String operateUserId= StpUtil.getLoginIdAsString();
        return Result.success(sysRoleService.delete(operateUserId,role));
    };

    @PostMapping("/modify")
    Result modify(@RequestBody SysRole role){
        String operateUserId= StpUtil.getLoginIdAsString();
        return Result.success(sysRoleService.modify(operateUserId,role));
    };

    @GetMapping("/getByDate")
    Result getByDate(@RequestParam("begin") String begin, @RequestParam("end") String end){
        return Result.success(sysRoleService.getByDate(LocalDate.parse(begin),LocalDate.parse(end)));
    };
    @GetMapping("/getByAuthen")
    Result getByAuthen(@RequestParam("role_key") String roleKey){
        return Result.success(sysRoleService.getByAuthen(roleKey));
    };
    @GetMapping("/getByRolename")
    Result getByRolename(@RequestParam("role_name") String rolename){
        return Result.success(sysRoleService.getByRolename(rolename));
    };


}
