package top.gsc.web.sys_user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.gsc.web.sys_user.entity.SysUser;
import top.gsc.web.sys_user.mapper.SysUserMapper;
import top.gsc.web.sys_user.service.SysUserService;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
}
