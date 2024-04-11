package com.sosddemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sosddemo.common.Result;
import com.sosddemo.entity.SysUser;
import com.sosddemo.entity.UserRole;
import com.sosddemo.mapper.SysRoleMapper;
import com.sosddemo.mapper.UserRoleMapper;
import com.sosddemo.service.ISysRoleService;
import com.sosddemo.service.IUserRoleService;
import com.sosddemo.common.Result;
import com.sosddemo.entity.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author author
 * @since 2024-04-08
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Autowired
    SysRoleMapper sysRoleMapper;

    @Override
    public Result insert(String userName, SysRole role) {
        role.setCreateBy(userName);
        return Result.success(save(role));
    }

    @Override
    public Result delete(String userName, SysRole role) {
        role.setUpdateBy(userName);


        return Result.success(updateById(role));
    }

    @Override
    public Result modify(String userName, SysRole role) {
        role.setUpdateBy(userName);


        return Result.success(updateById(role));
    }

    @Override
    public List<SysRole> getByDate(LocalDate begin, LocalDate end) {
        QueryWrapper<SysRole> queryWrapper= new QueryWrapper<SysRole>().between("create_time",begin.atStartOfDay(),end.atStartOfDay());

        return sysRoleMapper.selectList(queryWrapper);
    }

    @Override
    public List<SysRole> getByAuthen(String roleKey) {
        QueryWrapper<SysRole> queryWrapper= new QueryWrapper<SysRole>().eq("role_key",roleKey);

        return sysRoleMapper.selectList(queryWrapper);
    }

    @Override
    public List<SysRole> getByRolename(String rolename) {
        QueryWrapper<SysRole> queryWrapper= new QueryWrapper<SysRole>().eq("role_name",rolename);

        return sysRoleMapper.selectList(queryWrapper);
    }


}
