package com.sosddemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sosddemo.annotation.Log;
import com.sosddemo.common.Result;
import com.sosddemo.entity.SysUser;
import com.sosddemo.mapper.SysUserMapper;
import com.sosddemo.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author author
 * @since 2024-04-08
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Log
    @Override
    public Result insert(String userId, SysUser sysUser) {
        sysUser.setCreateBy(userId);
        return  Result.success( save(sysUser));
    }

    @Override
    public Result delete(String userName, SysUser sysUser) {
        sysUser.setUpdateBy(userName);
        ;
        return Result.success(sysUser.setDelFlag("2"));
    }

    @Override
    public Result modify(String userName, SysUser sysUser) {
        return Result.success(sysUser.setUpdateBy(userName));
    }

    @Override
    public List<SysUser> getByDate(LocalDate begin, LocalDate end) {
        QueryWrapper<SysUser>queryWrapper= new QueryWrapper<SysUser>().between("create_time",begin.atStartOfDay(),end.atStartOfDay());

        return sysUserMapper.selectList(queryWrapper);
    }

    @Override
    public List<SysUser> getByUsername(String username) {
        QueryWrapper<SysUser>queryWrapper= new QueryWrapper<SysUser>().eq("user_name",username);

        return sysUserMapper.selectList(queryWrapper);
    }

    @Override
    public List<SysUser> getByPhoneNumber(String phonenumber) {
        QueryWrapper<SysUser>queryWrapper= new QueryWrapper<SysUser>().eq("phonenumber",phonenumber);

        return sysUserMapper.selectList(queryWrapper);
    }

    @Override
    public List<SysUser> getByStatus(String status) {
        QueryWrapper<SysUser>queryWrapper= new QueryWrapper<SysUser>().eq("status",status);

        return sysUserMapper.selectList(queryWrapper);
    }


}
