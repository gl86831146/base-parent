package top.gsc.web.sys_role_menu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.gsc.web.sys_role_menu.entity.SaveMenuParm;
import top.gsc.web.sys_role_menu.entity.SysRoleMenu;

public interface SysRoleMenuService extends IService<SysRoleMenu> {
    void saveRoleMenu(SaveMenuParm parm);
}
