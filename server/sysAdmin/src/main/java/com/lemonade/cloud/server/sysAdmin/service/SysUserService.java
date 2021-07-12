package com.lemonade.cloud.server.sysAdmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lemonade.cloud.common.entity.model.sysAdmin.SysUser;


public interface SysUserService extends IService<SysUser> {


    SysUser getUserByUsername(String username);
}
