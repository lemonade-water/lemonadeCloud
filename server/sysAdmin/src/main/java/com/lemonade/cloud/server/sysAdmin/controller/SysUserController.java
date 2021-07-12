package com.lemonade.cloud.server.sysAdmin.controller;

import com.lemonade.cloud.common.entity.model.sysAdmin.SysUser;
import com.lemonade.cloud.common.entity.vo.Result;
import com.lemonade.cloud.server.sysAdmin.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/sysUser")
@Api("sysUser")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    @GetMapping("/getUserByUsername")
    @ApiOperation(value = "/getUserByUsername",notes = "根据username获取用户信息")
    public Result<SysUser> getUserByUsername(@RequestParam("username")
                                                     @ApiParam("username") String username){
        SysUser user = sysUserService.getUserByUsername(username);
        return Result.success(user);
    }
}
