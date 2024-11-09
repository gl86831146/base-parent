package top.gsc.web.sys_user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import top.gsc.result.ResultVo;
import top.gsc.utils.ResultUtils;
import top.gsc.web.sys_user.entity.SysUser;
import top.gsc.web.sys_user.entity.SysUserPage;
import top.gsc.web.sys_user.service.SysUserService;

@RestController
@RequestMapping("/api/sysUser")
@AllArgsConstructor
public class SysUserController {

    private final SysUserService sysUserService;

    // 新增用户
    @PostMapping
    @Operation(summary = "新增用户")
    public ResultVo<?> add(@RequestBody SysUser sysUser) {
        if (sysUserService.save(sysUser)) {
            return ResultUtils.success("新增成功!");
        }
        return ResultUtils.error("新增失败！");
    }

    // 编辑用户
    @PutMapping
    @Operation(summary = "编辑用户")
    public ResultVo<?> edit(@RequestBody SysUser sysUser) {
        if (sysUserService.updateById(sysUser)) {
            return ResultUtils.success("编辑成功!");
        }
        return ResultUtils.error("编辑失败！");
    }

    // 删除用户
    @Operation(summary = "删除用户")
    @DeleteMapping("/{userId}")
    public ResultVo<?> delete(@PathVariable("userId") Long userId) {
        if (sysUserService.removeById(userId)) {
            return ResultUtils.success("删除成功!");
        }
        return ResultUtils.error("删除失败！");
    }

    // 用户列表
    @PostMapping("/list")
    @Operation(summary = "用户列表")
    public ResultVo<?> list(@RequestBody SysUserPage parm) {
        // 构造分页对象
        Page<SysUser> page = new Page<>(parm.getCurrentPage(), parm.getPageSize());
        // 构造查询条件
        QueryWrapper<SysUser> query = new QueryWrapper<>();
        if (parm.getNickName() != null && !parm.getNickName().isEmpty()) {
            query.lambda().like(SysUser::getNickName, parm.getNickName());
        }
        if (parm.getPhone() != null && !parm.getPhone().isEmpty()) {
            query.lambda().like(SysUser::getPhone, parm.getPhone());
        }
        query.lambda().orderByDesc(SysUser::getCreateTime); // 按创建时间降序排列
        // 查询列表
        Page<SysUser> list = sysUserService.page(page, query);
        return ResultUtils.success("查询成功", list);
    }
}
