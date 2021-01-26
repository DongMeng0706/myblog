package com.dong.system.service;

import com.dong.system.entity.Dept;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dong.system.entity.Tree;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface IDeptService extends IService<Dept> {

    public List<Tree<Dept>> getTree();
    public Tree<Dept> getuserTree();
}
