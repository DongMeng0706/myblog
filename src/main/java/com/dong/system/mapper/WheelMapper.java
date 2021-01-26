package com.dong.system.mapper;

import com.dong.system.entity.Wheel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 轮播表 Mapper 接口
 * </p>
 */
public interface WheelMapper extends BaseMapper<Wheel> {

     public List<Wheel> selectAll();
}
