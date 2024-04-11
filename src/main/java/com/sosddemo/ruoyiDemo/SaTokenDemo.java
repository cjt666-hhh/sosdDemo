package com.sosddemo.ruoyiDemo;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sosddemo.annotation.Log;
import com.sosddemo.entity.SysUser;
import com.sosddemo.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@SaCheckLogin
@RequestMapping("/demo")
public class SaTokenDemo {

    @Autowired
    SysUserMapper sysUserMapper;
    @SaIgnore
    @GetMapping("/login/{id}")
    String getToken(@PathVariable Integer id) {
        StpUtil.login(id);

        return StpUtil.getTokenInfo().tokenValue;
    }

    @Log
    @SaIgnore
    @PostMapping("/doLogin")
    public SaResult doLogin(@RequestParam("user_name") String name, @RequestParam("password") String password) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<SysUser>().eq("user_name", name);
        SysUser sysUser = sysUserMapper.selectOne(queryWrapper);

        if (sysUser == null) {
            // 用户名不存在，抛出异常
            throw new RuntimeException("用户名不存在");
        }

        if (!sysUser.getPassword().equals(password)) {
            // 密码不正确，抛出异常
            throw new RuntimeException("密码错误");
        }

        StpUtil.login(sysUser.getUserId());
        return SaResult.ok("用户" + sysUser.getUserId() + "登录成功");
    }

    // 自定义用户名不存在的异常类
    class UsernameNotFoundException extends RuntimeException {
        public UsernameNotFoundException(String message) {
            super(message);
        }
    }

    // 自定义密码不正确的异常类
    class IncorrectPasswordException extends RuntimeException {
        public IncorrectPasswordException(String message) {
            super(message);
        }
    }


    @RequestMapping("/logout")
    String getToken() {
        StpUtil.logout();
        return StpUtil.getTokenInfo().tokenValue+"logout success!";
    }

    @RequestMapping("isLogin")
    public SaResult isLogin() {
        return SaResult.ok(StpUtil.getLoginIdAsString()+"是否登录：" + StpUtil.isLogin());
    }

    @PostMapping("/auth/{id}")
    String auth(@PathVariable Integer id) {
        return "success!";

    }
}
