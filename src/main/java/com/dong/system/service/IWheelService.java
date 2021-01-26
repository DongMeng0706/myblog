package com.dong.system.service;

import com.dong.system.entity.Wheel;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 轮播表 服务类
 * </p>
 */
public interface IWheelService extends IService<Wheel> {
    public List<Wheel> selectAll();
}
