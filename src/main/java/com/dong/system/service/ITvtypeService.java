package com.dong.system.service;

import com.dong.system.entity.Tvtype;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface ITvtypeService extends IService<Tvtype> {
    public Tvtype[] selectDistinct();
}
