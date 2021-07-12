package com.lemonade.cloud.server.sysAdmin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lemonade.cloud.common.entity.model.sysAdmin.SysRole;
import com.lemonade.cloud.common.entity.model.sysAdmin.SysUserRole;
import com.lemonade.cloud.server.sysAdmin.mapper.SysRoleMapper;
import com.lemonade.cloud.server.sysAdmin.service.SysRoleService;
import com.lemonade.cloud.server.sysAdmin.service.SysUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Resource
    private SysRoleMapper mapper;

    @Resource
    private SysUserRoleService sysUserRoleService;
    @Override
    public Set<String> getRolesByUserId(String id) {
        LambdaQueryWrapper<SysUserRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUserRole::getUserId,id);
        return sysUserRoleService.list(wrapper).stream().map(SysUserRole::getRoleId).collect(Collectors.toSet());
    }
}
