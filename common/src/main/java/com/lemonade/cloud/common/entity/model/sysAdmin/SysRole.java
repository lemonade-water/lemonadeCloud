package com.lemonade.cloud.common.entity.model.sysAdmin;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lemonade.cloud.common.entity.model.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_role")
public class SysRole extends BaseEntity implements Serializable {
    private String code;
    private String name;
    private String description;

    @TableField(exist = false)
    private Set<String> resourceIds;
}
