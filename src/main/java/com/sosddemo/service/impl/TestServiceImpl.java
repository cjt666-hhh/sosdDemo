package com.sosddemo.service.impl;

import com.sosddemo.annotation.Log;
import com.sosddemo.entity.Test;
import com.sosddemo.mapper.TestMapper;
import com.sosddemo.service.ITestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2024-04-01
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService {
    @Log
    public String hello(){
        return "hello";
    }

    @Log
    public Test tt(int id){

        Test tt=query().eq("id",id).getEntity();
        return tt;
    }



}
