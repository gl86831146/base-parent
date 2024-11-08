package top.gsc.web.sys_role.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 系统角色实体类
 */
@Data
@TableName("sys_role")
public class SysRole {

    @TableId(type = IdType.AUTO)
    private Long roleId; // 角色ID

    private String roleName; // 角色名称

    private String remark; // 角色描述

    private String type; // 角色类型

    @TableLogic
    private Integer deleted; // 逻辑删除字段

}
