package com.dong.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dong.system.entity.Menu;
import com.dong.util.TreeMenu;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface IMenuService extends IService<Menu> {
    public List<TreeMenu> selectMenuAllMy();

    public List<Menu> selectMenuAll();


}
