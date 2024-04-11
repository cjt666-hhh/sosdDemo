package com.sosddemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sosddemo.common.Result;
import com.sosddemo.entity.SysRole;
import com.sosddemo.entity.SysUser;
import com.sosddemo.entity.UserRole;
import com.sosddemo.mapper.SysRoleMapper;
import com.sosddemo.mapper.SysUserMapper;
import com.sosddemo.mapper.UserRoleMapper;
import com.sosddemo.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 * 用户角色关联表 服务实现类
 * </p>
 *
 * @author author
 * @since 2024-04-08
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    SysUserMapper sysUserMapper;

    @Autowired
    SysRoleMapper sysRoleMapper;

    @Override
    public Result allocate(long userId, long roleId) {

        UserRole ur = new UserRole();
        ur.setRoleId(roleId);
        ur.setUserId(userId);

        return Result.success(save(ur));
    }

    @Override
    public Result delete(long userId, long roleId) {
        QueryWrapper<UserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId).eq("role_id", roleId);

        // 执行删除操作，这里以Mapper为例
        return Result.success(userRoleMapper.delete(queryWrapper));


    }

    @Override
    public Result getUserByRole(Long roleId) {

        QueryWrapper<UserRole> queryWrapper=new QueryWrapper<UserRole>()
                .eq("role_id",roleId);


        List<UserRole> urs=userRoleMapper.selectList(queryWrapper);

        List<SysUser> users=new ArrayList<>();
        for (UserRole ur :urs){
            users.add(sysUserMapper.selectById(ur.getUserId()));
        }

        return Result.success(users);


    }

    @Override
    public Result getRoleByUser(Long userId) {
        QueryWrapper<UserRole> queryWrapper=new QueryWrapper<UserRole>()
                .eq("user_id",userId);


        List<UserRole> urs=userRoleMapper.selectList(queryWrapper);

        List<SysRole> roles=new ArrayList<>();
        for (UserRole ur :urs){
            roles.add(sysRoleMapper.selectById(ur.getRoleId()));
        }

        return Result.success(roles);

    }


}