package com.dong.system.mapper;

import com.dong.system.entity.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 */
public interface DeptMapper extends BaseMapper<Dept> {
  public Long[] listParentDept();
  public Long[] listAllDept();


}
