package com.lemonade.cloud.common.entity.model.sysAdmin;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lemonade.cloud.common.entity.model.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_user_role")
public class SysUserRole extends BaseEntity implements Serializable {
    private String userId;
    private String roleId;
}
