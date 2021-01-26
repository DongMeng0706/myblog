package com.dong.system.service;

import com.dong.system.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface IRoleService extends IService<Role> {

    public Integer insert(Role role);

    public List<Role> selectRoleUserid(int userid);
}
