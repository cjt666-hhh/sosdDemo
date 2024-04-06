package com.sosddemo.controller;



import com.sosddemo.annotation.Log;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2024-04-01
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @Log
    @GetMapping("/hello/{a}")
    int hello(@PathVariable(value = "a")int a ){
        return a;
    }
}
