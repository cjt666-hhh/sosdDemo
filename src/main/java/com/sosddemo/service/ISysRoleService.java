package com.sosddemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sosddemo.common.Result;
import com.sosddemo.entity.SysRole;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 角色信息表 服务类
 * </p>
 *
 * @author author
 * @since 2024-04-08
 */
public interface ISysRoleService extends IService<SysRole> {

    Result insert(String userName, SysRole role);

    Result delete(String userName,SysRole role);

    Result modify(String userName,SysRole role);

    List<SysRole> getByDate(LocalDate begin, LocalDate end);

    List<SysRole> getByAuthen(String roleKey);
    List<SysRole> getByRolename(String rolename);





}
