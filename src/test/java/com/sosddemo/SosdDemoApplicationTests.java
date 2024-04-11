package com.sosddemo;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.stp.StpUtil;

import com.sosddemo.annotation.Log;
import com.sosddemo.entity.SysUser;
import com.sosddemo.mapper.SysUserMapper;
import com.sosddemo.service.impl.SysUserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SosdDemoApplicationTests {



    @Autowired
    SysUserServiceImpl sysUserService;

    @Test
    @Log
    void contextLoads() {

        SysUser sysUser=new SysUser();

        sysUser.setUpdateBy("1");

       sysUserService.insert("1",sysUser);


    }



}


