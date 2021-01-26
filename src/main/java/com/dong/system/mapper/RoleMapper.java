package com.dong.system.mapper;

import com.dong.system.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 */
public interface RoleMapper extends BaseMapper<Role> {
        public List<Role> selectUserid(@Param("id") int userid);
}
