package com.dong.system.service;

import com.dong.system.entity.Power;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface IPowerService extends IService<Power> {
      public List<Power> MySelectByAllMenu();
      public List<Power> selectByUserId(Integer id);
}
