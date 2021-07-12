package com.lemonade.cloud.server.sysAdmin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lemonade.cloud.common.entity.model.sysAdmin.SysUser;
import com.lemonade.cloud.server.sysAdmin.mapper.SysUserMapper;
import com.lemonade.cloud.server.sysAdmin.service.SysRoleService;
import com.lemonade.cloud.server.sysAdmin.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysRoleService sysRoleService;

    @Override
    public SysUser getUserByUsername(String username){
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getUsername,username);
        SysUser user = sysUserMapper.selectOne(wrapper);
        if (user!=null){
            Set<String> roles = sysRoleService.getRolesByUserId(user.getId());
            if (roles!=null && !roles.isEmpty()){
                user.setRoles(new HashSet<>(sysRoleService.listByIds(roles)));
            }
        }
        return user;
    }
}
