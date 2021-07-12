package com.lemonade.cloud.server.sysAdmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lemonade.cloud.common.entity.model.sysAdmin.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
}
