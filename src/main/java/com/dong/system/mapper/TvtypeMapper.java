package com.dong.system.mapper;

import com.dong.system.entity.Tvtype;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.catalina.LifecycleState;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 */
public interface TvtypeMapper extends BaseMapper<Tvtype> {

    public Tvtype[] selectDistinct();
}
