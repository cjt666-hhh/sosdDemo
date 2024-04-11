package com.sosddemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sosddemo.common.Result;
import com.sosddemo.entity.SysRole;
import com.sosddemo.entity.SysUser;
import com.sosddemo.entity.UserRole;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 用户角色关联表 服务类
 * </p>
 *
 * @author author
 * @since 2024-04-08
 */
public interface IUserRoleService extends IService<UserRole> {

    Result allocate(long userId, long roleId);

    Result delete(long userId, long roleId);

    Result getUserByRole(Long roleId);

    Result getRoleByUser(Long userId);






}
