package com.sosddemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sosddemo.common.Result;
import com.sosddemo.entity.SysUser;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author author
 * @since 2024-04-08
 */
public interface ISysUserService extends IService<SysUser> {
    Result insert(String userName, SysUser sysUser);

    Result delete(String userName,SysUser sysUser);

    Result modify(String userName,SysUser sysUser);

    List<SysUser> getByDate(LocalDate begin,LocalDate end);

    List<SysUser> getByUsername(String username);

    List<SysUser> getByPhoneNumber(String phonenumber);

    List<SysUser> getByStatus(String status);









}
