package top.gsc.web.sys_user_role.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SysUserRole {

    @TableId(type = IdType.AUTO)
    private Long userRoleId; // 用户角色关联ID

    private Long userId; // 用户ID

    private Long roleId; // 角色ID

    @TableLogic
    private Integer deleted; // 逻辑删除字段

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime; // 创建时间

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime; // 更新时间
}
