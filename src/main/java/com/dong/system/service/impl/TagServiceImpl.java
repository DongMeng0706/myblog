package com.dong.system.service.impl;

import com.dong.system.entity.Tag;
import com.dong.system.mapper.TagMapper;
import com.dong.system.service.ITagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {
    @Autowired
    TagMapper tagMapper;

    @Override
    @Transactional
    public List<Tag> selectByArticleId(Integer id){
       return tagMapper.selectByArticleId(id);
    }
}
