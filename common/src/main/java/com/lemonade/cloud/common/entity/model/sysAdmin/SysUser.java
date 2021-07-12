package com.lemonade.cloud.common.entity.model.sysAdmin;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lemonade.cloud.common.entity.model.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_user")
@ApiModel("系统用户")
public class SysUser extends BaseEntity implements Serializable {

    @ApiModelProperty(value = "name",name = "姓名")
    private String name;

    @ApiModelProperty(value = "mobile",name = "姓名")
    private String mobile;

    @ApiModelProperty(value = "username",name = "姓名")
    private String username;

    @ApiModelProperty(value = "password",name = "密码")
    private String password;

    @ApiModelProperty(value = "description",name = "描述")
    private String description;

    @ApiModelProperty(value = "status",name = "状态")
    private String status;

    @ApiModelProperty(value = "roles",name = "角色")
    @TableField(exist = false)
    private Set<SysRole> roles;

    @TableLogic(delval = "1")
    @ApiModelProperty(value = "deleted",name = "是否删除")
    private String deleted = "0";
}
