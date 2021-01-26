package com.dong.system.service.impl;

import com.dong.system.entity.RoleUser;
import com.dong.system.mapper.RoleUserMapper;
import com.dong.system.service.IRoleUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class RoleUserServiceImpl extends ServiceImpl<RoleUserMapper, RoleUser> implements IRoleUserService {

}
