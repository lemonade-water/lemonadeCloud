package com.lemonade.cloud.server.sysAdmin.controller;

import com.lemonade.cloud.common.entity.dto.SysUserDto;
import com.lemonade.cloud.common.entity.model.sysAdmin.SysUser;
import com.lemonade.cloud.common.entity.vo.Result;
import com.lemonade.cloud.server.sysAdmin.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

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

    @PostMapping("/add")
    @ApiOperation(value = "/add",notes = "添加用户")
    public Result<Boolean> add(@RequestBody @Valid SysUserDto sysUserDto){
        SysUser user = BeanUtils.instantiateClass(SysUser.class);
        BeanUtils.copyProperties(sysUserDto,user);
        return Result.success(sysUserService.add(user,sysUserDto.getRoleIds()));
    }

    @GetMapping("/test")
    @ApiOperation(value = "/test",notes = "test")
    public Result<Object> test(){
        return Result.success(true);
    }
}
