package com.lemonade.cloud.server.sysAdmin.service.impl;

import com.lemonade.cloud.common.entity.model.sysAdmin.SysUser;
import com.lemonade.cloud.server.sysAdmin.provider.SysUserProvider;
import com.lemonade.cloud.server.sysAdmin.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private SysUserProvider sysUserProvider;

    @Override
    public SysUser getSysUserByUsername(String username) {
        return sysUserProvider.getSysUserByUsername(username).getData();
    }
}
