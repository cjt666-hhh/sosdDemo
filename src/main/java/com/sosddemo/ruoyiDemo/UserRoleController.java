package com.sosddemo.ruoyiDemo;


import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.sosddemo.common.Result;
import com.sosddemo.service.impl.UserRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户角色关联表 前端控制器
 * </p>
 *
 * @author author
 * @since 2024-04-08
 */
@SaCheckLogin
@RestController
@RequestMapping("/user-role")
public class UserRoleController {

    @Autowired
    UserRoleServiceImpl userRoleServicel;

    @RestController
    public class YourController {

        @PostMapping("/allocate")
        public Result allocate(@RequestParam("user_id") long userId, @RequestParam("role_id") long roleId) {
            // 在这里添加分配角色的业务逻辑
            // ...

            // 假设业务逻辑执行成功后返回一个成功的Result对象
            return Result.success(userRoleServicel.allocate(userId,roleId));
        }
    }
    @DeleteMapping("/delete")
    Result delete(@RequestParam("user_id") long userId, @RequestParam("role_id") long roleId){
        return Result.success(userRoleServicel.delete(userId,roleId));
    };


    @GetMapping("/getUserByRole")
    Result getUserByRole(@RequestParam("role_id")Long roleId){
        return  userRoleServicel.getUserByRole(roleId);
    };

    @GetMapping("/getRoleByUser")
    Result getRoleByUser(@RequestParam("user_id")Long userId){
        return userRoleServicel.getRoleByUser(userId);
    };



}
