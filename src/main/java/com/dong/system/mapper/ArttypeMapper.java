package com.dong.system.mapper;

import com.dong.system.entity.Arttype;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 资源类型表 Mapper 接口
 * </p>
 */
public interface ArttypeMapper extends BaseMapper<Arttype> {

    public Arttype selectbyId( Integer acttypeid);

    public List<Arttype> selectAll();

}
