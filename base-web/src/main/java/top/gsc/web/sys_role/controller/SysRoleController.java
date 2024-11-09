package top.gsc.web.sys_role.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import top.gsc.result.ResultVo;
import top.gsc.utils.ResultUtils;
import top.gsc.web.sys_role.entity.RoleParm;
import top.gsc.web.sys_role.entity.SelectItem;
import top.gsc.web.sys_role.entity.SysRole;
import top.gsc.web.sys_role.service.SysRoleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/role")
@AllArgsConstructor
@Tag(name = "SysRoleController", description = "系统角色管理")
public class SysRoleController {

    private final SysRoleService sysRoleService;

    // 新增角色
    @PostMapping
    @Operation(summary = "新增角色")
    public ResultVo<?> add(@RequestBody SysRole sysRole) {
        if (sysRoleService.save(sysRole)) {
            return ResultUtils.success("新增成功!");
        }
        return ResultUtils.error("新增失败!");
    }

    // 编辑角色
    @PutMapping
    @Operation(summary = "编辑角色")
    public ResultVo<?> edit(@RequestBody SysRole sysRole) {
        if (sysRoleService.updateById(sysRole)) {
            return ResultUtils.success("编辑成功!");
        }
        return ResultUtils.error("编辑失败!");
    }

    // 删除角色
    @DeleteMapping("/{roleId}")
    @Operation(summary = "删除角色")
    public ResultVo<?> delete(@PathVariable("roleId") Long roleId) {
        if (sysRoleService.removeById(roleId)) {
            return ResultUtils.success("删除成功!");
        }
        return ResultUtils.error("删除失败!");
    }

    @PostMapping("/getList")
    @Operation(summary = "角色列表")
    public ResultVo<?> getList(@RequestBody RoleParm parm) {
        // 构造分页对象
        Page<SysRole> page = new Page<>(parm.getCurrentPage(), parm.getPageSize());
        // 构造查询条件
        QueryWrapper<SysRole> query = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(parm.getRoleName())) {
            query.lambda().like(SysRole::getRoleName, parm.getRoleName());
        }
        IPage<SysRole> list = sysRoleService.page(page, query);
        return ResultUtils.success("查询成功", list);
    }
        @GetMapping("/selectList")
        @Operation(summary = "角色下拉数据")
        public ResultVo<?> selectList() {
            List<SysRole> list = sysRoleService.list();
            List<SelectItem> selectItems = new ArrayList<>();

            Optional.ofNullable(list).orElse(new ArrayList<>()).forEach(item -> {
                SelectItem vo = new SelectItem();
                vo.setCheck(false);
                vo.setLabel(item.getRoleName());
                vo.setValue(item.getRoleId());
                selectItems.add(vo);
            });

            return ResultUtils.success("查询成功", selectItems);
        }
    }
